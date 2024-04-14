package Tests;

import static io.restassured.RestAssured.given;
import Helpers.Methods;
import Helpers.MyRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("SDET_Practice")
@Feature("Тестирование API")
@DisplayName("Обновление сущности: PATCH")
public class PATCH_Test extends BaseTest {

    public int id = 60;
    @Test
    public void testPatchEntity() {
        MyRequest patchRequest = new MyRequest();
        patchRequest.setTitle("Обновленный заголовок сущности");
        patchRequest.setVerified(false);
        patchRequest.setAddition(new MyRequest.Addition());
        patchRequest.getAddition().setAdditional_info("Обновленные дополнительные сведения");
        patchRequest.getAddition().setAdditional_number(456);
        patchRequest.setImportant_numbers(new int[]{1, 2, 3});

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(patchRequest);
        } catch (io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/api/patch/" +id);


        response.then()
                .statusCode(404);
    }

    @Test
    @Description("Get entity by id")
    void testGetEntityById() {
        Methods methods = new Methods();
          methods.method_Get(id, "Обновленный заголовок сущности", false, "Обновленные дополнительные сведения",
             456, new int[]{1, 2, 3});
    }

}
