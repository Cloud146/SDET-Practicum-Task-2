package Tests;

import Helpers.Methods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("SDET_Practice")
@Feature("Тестирование API")
@DisplayName("Получение сущности: GET")
public class GET_Test extends BaseTest {
    @Test
    @Description("Get entity by id")
    void testGetEntityById() {
        Methods methods = new Methods();
        methods.method_Get(58, "Заголовок сущности", true, "Дополнительные сведения",
                1234, new int[]{42, 87, 15});
    }
}
