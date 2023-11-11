package christmas.domain;

import christmas.menu.Order;

import java.util.*;
import java.util.regex.Pattern;

public class OrderStore {
    private static final String INPUT_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 입력해야 합니다. 다시 입력해 주세요.";
    private static final String MENU_EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int MINIMUM_MENU_COUNT = 1;
    private static final Pattern NUMBER_MATCH = Pattern.compile("^[0-9]*$");
    private final List<String> menuStore = new ArrayList<>();
    private final List<Integer> menuCountStore = new ArrayList<>();

    public void createMenuOrder(String inputMenu) {
        resetMenuStore();
        validateMenuForm(inputMenu);
        String[] menuOrders = inputMenu.split(",");
        for (String menuOrder : menuOrders) {
            String[] menuDetails = menuOrder.split("-");
            validateMenu(menuDetails);
            validateMenuCount(menuDetails);
        }
        validateMenuDuplicate(menuStore);
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

    private void validateMenuCount(String[] menuDetails) {
        for (int i = 1; i < menuDetails.length; i += 2) {
            validateMenuCountType(menuDetails[i]);
            validateMenuCount(toInt(menuDetails[i]));
            menuCountStore.add(toInt(menuDetails[i]));
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

    private void validateMenuCountType(String inputMenu) {
        if (!NUMBER_MATCH.matcher(inputMenu).matches())
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private void validateMenuCount(int menuCount) {
        if (!(menuCount >= MINIMUM_MENU_COUNT))
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private void validateMenuExist(String inputMenu) {
        if (!isMenuExist(inputMenu))
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private void validateMenuDuplicate(List<String> orderMenu) {
        if (new HashSet<>(orderMenu).size() != orderMenu.size())
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE);
    }

    private boolean isMenuExist(String inputMenu) {
        return Arrays.stream(Order.values())
                .anyMatch(order -> order.getName().equals(inputMenu));
    }

    private void resetMenuStore() {
        menuStore.clear();
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> getMenuStore() {
        return menuStore;
    }

    public List<Integer> getMenuCountStore() {
        return menuCountStore;
    }
}
