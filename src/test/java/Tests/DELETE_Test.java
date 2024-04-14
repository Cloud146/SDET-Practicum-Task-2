package Tests;

import Helpers.MyRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@Epic("SDET_Practice")
@Feature("Тестирование API")
@DisplayName("Удаление сущности: DELETE")
public class DELETE_Test extends BaseTest {

    @Test
    void testDeleteEntity() {
        MyRequest myRequest = new MyRequest();
        myRequest.setTitle("Сущность для удаления");
        myRequest.setVerified(true);
        myRequest.setAddition(new MyRequest.Addition());
        myRequest.getAddition().setAdditional_info("Дополнительные сведения");
        myRequest.getAddition().setAdditional_number(1235);
        myRequest.setImportant_numbers(new int[]{42, 87, 15});

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
                .post("/api/create");

        response.then()
                .statusCode(200)
                .body(notNullValue());

        int id = response.jsonPath().getInt("");

        given()
                .when()
                .delete("/api/delete/{id}", id)
                .then()
                .statusCode(404);


        given()
                .when()
                .get("/api/get/{id}", id)
                .then()
                .statusCode(404);
    }
}
