package christmas.domain;

import christmas.menu.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderStore {
    private static final String INPUT_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 입력해야 합니다. 다시 입력해 주세요.";
    private static final String MENU_EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final List<String> menuStore = new ArrayList<>();

    public void createMenuOrder(String inputMenu) {
        validateMenuForm(inputMenu);
        String[] menuOrders = inputMenu.split(",");
        for (String menuOrder : menuOrders) {
            String[] menuDetails = menuOrder.split("-");
            validateMenu(menuDetails);
        }
    }

    private void validateMenuForm(String inputMenu) {
        validateInputBlank(inputMenu);
        validateMenuFormat(inputMenu);
    }

    private void validateMenu(String[] menuDetails) {
        for (int i = 0; i < menuDetails.length; i += 2) {
            validateMenuExist(menuDetails[i]);
            menuStore.add(menuDetails[i]);
        }
    }

    private void validateInputBlank(String inputMenu) {
        if (inputMenu.contains(" ") || inputMenu.equals(""))
            throw new IllegalArgumentException(INPUT_BLANK_EXCEPTION_MESSAGE);
    }

    private static void validateMenuFormat(String inputMenu) {
        if (!inputMenu.contains("-"))
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private void validateMenuExist(String inputMenu) {
        if (!isMenuExist(inputMenu))
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private boolean isMenuExist(String inputMenu) {
        return Arrays.stream(Order.values())
                .anyMatch(order -> order.getName().equals(inputMenu));
    }

    public List<String> getMenuStore() {
        return menuStore;
    }
}
