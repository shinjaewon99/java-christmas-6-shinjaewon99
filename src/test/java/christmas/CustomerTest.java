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
    void Invalid_DateNumber_Type(String date) {
        assertThatThrownBy(() -> new Customer(date))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
