package christmas;

import christmas.menu.OrderType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTypeTest {
    @DisplayName("3개의 에피타이저 메뉴의 메뉴 종류 확인")
    @ValueSource(strings = {"MUSHROOM_SOUP", "TAPAS", "CAESAR_SALAD"})
    @ParameterizedTest
    void APPETIZER_MENU_TYPE_CHECK(String menuName) {
        OrderType orderType = OrderType.valueOf(menuName);
        Assertions.assertThat(orderType.getMenuType()).isEqualTo("APPETIZER");
    }

    @DisplayName("4개의 메인 메뉴의 메뉴 종류 확인")
    @ValueSource(strings = {"T_BONE_STEAK", "BBQ_RIB", "SEA_FOOD_PASTA", "CHRISTMAS_PASTA"})
    @ParameterizedTest
    void MAIN_MENU_TYPE_CHECK(String menuName) {
        OrderType orderType = OrderType.valueOf(menuName);
        Assertions.assertThat(orderType.getMenuType()).isEqualTo("MAIN");
    }

    @DisplayName("2개의 디저트 메뉴의 메뉴 종류 확인")
    @ValueSource(strings = {"CHOCO_CAKE", "ICE_CREAM"})
    @ParameterizedTest
    void DESSERT_MENU_TYPE_CHECK(String menuName) {
        OrderType orderType = OrderType.valueOf(menuName);
        Assertions.assertThat(orderType.getMenuType()).isEqualTo("DESSERT");
    }

    @DisplayName("3개의 음료 메뉴의 메뉴 종류 확인")
    @ValueSource(strings = {"ZERO_COKE", "RED_WINE", "CHAMPAGNE"})
    @ParameterizedTest
    void DRINK_MENU_TYPE_CHECK(String menuName) {
        OrderType orderType = OrderType.valueOf(menuName);
        Assertions.assertThat(orderType.getMenuType()).isEqualTo("DRINK");
    }

}
