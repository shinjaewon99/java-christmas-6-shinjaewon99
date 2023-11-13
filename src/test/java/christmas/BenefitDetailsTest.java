package christmas;

import christmas.service.BenefitDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BenefitDetailsTest {
    BenefitDetails benefitDetails = new BenefitDetails();

    @DisplayName("총 주문 금액이 10_000원 이상인지 확인")
    @ValueSource(ints = {10_000, 35_000})
    @ParameterizedTest
    void over_Before_TotalMoney(int beforeTotalMoney) {
        assertThat(true).isEqualTo(benefitDetails.minimumTotalMoney(beforeTotalMoney));
    }

    @DisplayName("총 주문 금액이 10_000원 보다 작은지 확인")
    @ValueSource(ints = {9_999, 5_000})
    @ParameterizedTest
    void under_Before_TotalMoney(int beforeTotalMoney) {
        assertThat(false).isEqualTo(benefitDetails.minimumTotalMoney(beforeTotalMoney));
    }

    @DisplayName("크리스마스 디데이 할인 (25일엔 3400원 할인)")
    @Test
    void apply_dDay_Discount() {
        assertThat(3400).isEqualTo(benefitDetails.calculatedDayDiscount(25));
    }

    @DisplayName("크리스마스 디데이 할인 (26일엔 0원 할인)")
    @Test
    void not_Apply_dDay_Discount() {
        assertThat(0).isEqualTo(benefitDetails.calculatedDayDiscount(26));
    }

    @DisplayName("디저트 메뉴를 메뉴 1개당 2_023원 할인")
    @Test
    void apply_Dessert_Discount() {
        assertThat(10_115).isEqualTo(benefitDetails.calculatedWeekdayDiscount("초코케이크", 5));
    }

    @DisplayName("디저트 메뉴가 아닌경우 0원 할인")
    @Test
    void not_Apply_Dessert_Discount() {
        assertThat(0).isEqualTo(benefitDetails.calculatedWeekdayDiscount("티본스테이크", 5));
    }

    @DisplayName("메인 메뉴를 메뉴 1개당 2_023원 할인")
    @Test
    void apply_Main_Discount() {
        assertThat(10_115).isEqualTo(benefitDetails.calculatedWeekendDiscount("티본스테이크", 5));
    }

    @DisplayName("메인 메뉴가 아닌경우 0원 할인")
    @Test
    void not_Apply_Main_Discount() {
        assertThat(0).isEqualTo(benefitDetails.calculatedWeekendDiscount("시저샐러드", 5));
    }

    @DisplayName("이벤트 달력에 별이 있으면 1_000원 할인")
    @Test
    void apply_Special_Discount() {
        assertThat(1_000).isEqualTo(benefitDetails.calculateSpecialDiscount(3));
    }

    @DisplayName("이벤트 달력에 별이 없으면 0원 할인")
    @Test
    void not_Apply_Special_Discount() {
        assertThat(0).isEqualTo(benefitDetails.calculateSpecialDiscount(20));
    }

    @DisplayName("고객이 입력한 방문 날짜가 평일인지 확인 ")
    @Test
    void customer_Visit_WeekDay() {
        assertThat(true).isEqualTo(benefitDetails.checkWeekday(13));
    }

    @DisplayName("고객이 입력한 방문 날짜가 주말인지 확인 ")
    @Test
    void customer_Visit_Weekend() {
        assertThat(true).isEqualTo(benefitDetails.checkWeekend(1));
    }
}
