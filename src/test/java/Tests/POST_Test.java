package Tests;

import Helpers.InputData;
import Helpers.Methods;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("SDET_Practice")
@Feature("Тестирование API")
@DisplayName("Создание сущности: POST")
public class POST_Test extends BaseTest {

    @Test
    void testCreateEntity() {
        InputData inputData = new InputData();
        Methods methods = new Methods();
        int id = methods.method_Post("Заголовок сущности", true, "Дополнительные сведения",
                1234, new int[]{42, 87, 15});
        methods.method_Get(id, inputData.title, inputData.verifiedStatus, inputData.additional_info,
                inputData.additional_number, inputData.important_numbers);
    }
}
