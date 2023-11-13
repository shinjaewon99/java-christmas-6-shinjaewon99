package christmas;

import christmas.controller.PromotionController;
import christmas.service.PromotionService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PromotionController promotionController
                = new PromotionController(new InputView(), new OutputView(), new PromotionService());

        promotionController.play();
    }
}
