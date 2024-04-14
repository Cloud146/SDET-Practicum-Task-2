package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@Epic("SDET_Practice")
@Feature("Тестирование API")
@DisplayName("Получение всех сущностей: GET")
public class GetAll_Test{

    @Test
    @Description("Get all entities")
    void testGetAllEntities() {
        Response response = given()
                .when()
                .get("/api/getAll");

        System.out.println(response.asString());

        String responseBody = response.asString();
        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode entityNode = jsonNode.get("entity");
        List<JsonNode> entityList = new ArrayList<>();
        int entityCount = 0;
        for (JsonNode node : entityNode) {
            entityList.add(node);
            System.out.println(node);
            entityCount++;
        }
        assertEquals(entityCount, entityList.size());
    }
}
