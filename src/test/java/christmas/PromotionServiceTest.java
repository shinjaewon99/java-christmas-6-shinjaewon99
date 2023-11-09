package christmas;

import christmas.service.PromotionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PromotionServiceTest {
    PromotionService service = new PromotionService();

    @DisplayName("숫자가 아닌 방문 날짜 입력시 예외가 발생한다.")
    @ValueSource(strings = {"a", "12a", "a1"})
    @ParameterizedTest
    void Invalid_DateNumber_Type(String date) {
        assertThatThrownBy(() -> service.validateVisitDate(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않은 방문 날짜 입력시 예외가 발생한다.")
    @ValueSource(strings = {"0", "32", "54"})
    @ParameterizedTest
    void Invalid_DateNumber_EXIST(String date) {
        assertThatThrownBy(() -> service.validateVisitDate(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜 입력시 공백이 존재하면 예외가 발생한다.")
    @ValueSource(strings = {" 1", "3 1", "", " "})
    @ParameterizedTest
    void Invalid_DateNumber_BLANK(String date) {
        assertThatThrownBy(() -> service.validateVisitDate(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
