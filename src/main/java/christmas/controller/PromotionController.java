package christmas.controller;

import christmas.service.PromotionService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionService service;

    public PromotionController(InputView inputView, OutputView outputView, PromotionService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void play() {
        customerInput();
        settingEventPreview();
        settingOrderMenu();
        settingBeforeTotalMoney();
    }

    private void customerInput() {
        outputView.printHelloRestaurantOpen();
        inputVisitDate();
        inputMenuOrder();
    }

    private void inputVisitDate() {
        try {
            String readDate = inputView.readDate();
            service.createVisitDate(readDate);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            inputVisitDate();
        }
    }

    private void inputMenuOrder() {
        try {
            String readMenuOrder = inputView.readMenuOrder();
            service.createMenuOrder(readMenuOrder);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            inputMenuOrder();
        }
    }

    private void settingEventPreview() {
        outputView.printEventPreview(service.getVisitDate());
    }

    private void settingOrderMenu() {
        outputView.printOrderMenu();
        for (int i = 0; i < service.getMenuStore().size(); i++) {
            outputView.printOrderMenuDetails(service.getMenuStore().get(i), service.getMenuCountStore().get(i));
        }
    }

    private void settingBeforeTotalMoney() {
        outputView.printBeforeDiscount(service.createBeforeTotalMoney());
    }
}
