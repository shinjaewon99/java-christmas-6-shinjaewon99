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

    @DisplayName("메뉴의 개수가 1 이상이 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"제로콜라-0, 초코케이크-1,아이스크림-5", "레드와인-5,티본스테이크-0", "시저샐러드-0"})
    @ParameterizedTest
    void Invalid_Menu_Count(String menu) {
        assertThatThrownBy(() -> orderStore.createMenuOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 형식이 예시와 다른 경우 예외가 발생한다.")
    @ValueSource(strings = {"제로콜라 -3, 초코케이크-1,아이스크림-5", "레드 와인-5,티본스테이크-4", "샴페인4", "제로콜라-a", "", " "})
    @ParameterizedTest
    void Invalid_Menu_Form(String menu) {
        assertThatThrownBy(() -> orderStore.createMenuOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴를 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-1", "초코케이크-4,아이스크림-2,초코케이크-5"})
    @ParameterizedTest
    void Invalid_Menu_Duplicate(String menu) {
        assertThatThrownBy(() -> orderStore.createMenuOrder(menu))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
