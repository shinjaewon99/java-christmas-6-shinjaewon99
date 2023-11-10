package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_RESTAURANT_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String REQUEST_INPUT_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String readDate() {
        System.out.println(REQUEST_INPUT_RESTAURANT_VISIT_DATE);
        return Console.readLine();
    }

    public String readMenuOrder() {
        System.out.println(REQUEST_INPUT_ORDER_MENU);
        return Console.readLine();
    }
}
