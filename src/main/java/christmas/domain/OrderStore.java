package christmas.domain;

public class OrderStore {
    private static final String INPUT_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 입력해야 합니다. 다시 입력해 주세요.";
    private static final String MENU_EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public void createMenuOrder(String inputMenu) {
        validateMenuForm(inputMenu);
        String[] menuOrders = inputMenu.split(",");
        for (String menuOrder : menuOrders) {

        }
    }

    private void validateMenuForm(String inputMenu) {
        validateInputBlank(inputMenu);
        validateMenuFormat(inputMenu);
    }

    private void validateInputBlank(String inputMenu) {
        if (inputMenu.contains(" ") || inputMenu.equals(""))
            throw new IllegalArgumentException(INPUT_BLANK_EXCEPTION_MESSAGE);
    }

    private static void validateMenuFormat(String inputMenu) {
        if (!inputMenu.contains("-"))
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }
}
