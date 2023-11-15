package christmas;

import christmas.menu.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @DisplayName("메뉴판에 존재하는 양송이수프 이름확인")
    @Test
    void Mushroom_Soup_Name_Check() {
        assertThat("양송이수프").isEqualTo(Order.APPETIZER_FIRST.getName());
    }

    @DisplayName("메뉴판에 존재하는 양송이수프 가격 확인")
    @Test
    void Mushroom_Soup_Price_Check() {
        assertThat(6_000).isEqualTo(Order.APPETIZER_FIRST.getPrice());
    }

    @DisplayName("메뉴판에 존재하는 바비큐립 이름확인")
    @Test
    void BBQ_Ribs_Name_Check() {
        assertThat("바비큐립").isEqualTo(Order.MAIN_SECOND.getName());
    }

    @DisplayName("메뉴판에 존재하는 바비큐립 가격 확인")
    @Test
    void BBQ_Ribs_Price_Check() {
        assertThat(54_000).isEqualTo(Order.MAIN_SECOND.getPrice());
    }

    @DisplayName("메뉴판에 존재하는 초코케이크 이름확인")
    @Test
    void Choco_Cake_Name_Check() {
        assertThat("초코케이크").isEqualTo(Order.DESSERT_FIRST.getName());
    }

    @DisplayName("메뉴판에 존재하는 초코케이크 가격 확인")
    @Test
    void Choco_Cake_Price_Check() {
        assertThat(15_000).isEqualTo(Order.DESSERT_FIRST.getPrice());
    }

    @DisplayName("메뉴판에 존재하는 제로콜라 이름확인")
    @Test
    void Zero_Coke_Name_Check() {
        assertThat("제로콜라").isEqualTo(Order.DRINK_FIRST.getName());
    }

    @DisplayName("메뉴판에 존재하는 제로콜라 가격 확인")
    @Test
    void Zero_Coke_Price_Check() {
        assertThat(3_000).isEqualTo(Order.DRINK_FIRST.getPrice());
    }

    @DisplayName("메뉴판에 존재하는 메뉴 개수 확인")
    @Test
    void Menu_Board_Exist_Menu_Check() {
        assertThat(12).isEqualTo(Order.values().length);
    }
}
