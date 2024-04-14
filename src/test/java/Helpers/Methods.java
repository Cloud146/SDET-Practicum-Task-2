package Helpers;

import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class Methods {
    public void method_Get(int id, String title, boolean verifiedStatus, String additional_info,
                           int additional_number, int[] important_numbers){
        Response response = given()
                .when()
                .get("/get/{id}", id);

        List<Integer> importantNumbersList = Arrays.stream(important_numbers).boxed().collect(Collectors.toList());

        response.then()
                .statusCode(200)
                .body("title", equalTo(title))
                .body("verified", equalTo(verifiedStatus))
                .body("addition.additional_info", equalTo(additional_info))
                .body("addition.additional_number", equalTo(additional_number))
                .body("important_numbers", equalTo(importantNumbersList));
    }

    public int method_Post(String title, boolean verifiedStatus, String additional_info,
                           int additional_number, int[] important_numbers){
        MyRequest myRequest = new MyRequest();
        myRequest.setTitle(title);
        myRequest.setVerified(verifiedStatus);
        myRequest.setAddition(new MyRequest.Addition());
        myRequest.getAddition().setAdditional_info(additional_info);
        myRequest.getAddition().setAdditional_number(additional_number);
        myRequest.setImportant_numbers(important_numbers);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(myRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/create");

        response.then()
                .statusCode(200)
                .body(notNullValue());
        int id = response.jsonPath().getInt("");
        return id;
    }
}
