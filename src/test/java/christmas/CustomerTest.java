package christmas;

import christmas.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomerTest {
    @DisplayName("숫자가 아닌 방문 날짜 입력시 예외가 발생한다.")
    @ValueSource(strings = {"a", "12a", "a1"})
    @ParameterizedTest
    void invalid_DateNumber_Type(String date) {
        assertThatThrownBy(() -> new Customer(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 1 이상 31 이하가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"0", "32", "54"})
    @ParameterizedTest
    void invalid_DateNumber_Not_Exist(String date) {
        assertThatThrownBy(() -> new Customer(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜 입력시 공백이 존재하면 예외가 발생한다.")
    @ValueSource(strings = {" 1", "3 1", "", " "})
    @ParameterizedTest
    void invalid_DateNumber_Blank(String date) {
        assertThatThrownBy(() -> new Customer(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
