package christmas;

import christmas.domain.OrderStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderStoreTest {
    OrderStore orderStore = new OrderStore();

    @DisplayName("메뉴판에 없는 메뉴를 입력하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"콜라-1, 초코케이크-1,아이스크림-5", "레드와인-5,스테이크-4", "감자샐러드-4"})
    @ParameterizedTest
    void Invalid_Menu_Not_Exist(String menu) {
        assertThatThrownBy(() -> orderStore.createMenuOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
