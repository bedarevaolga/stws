package steampowered.pages;

import framework.BaseSteamPage;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActionPage extends BaseSteamPage {

    public ActionPage() {
        super(By.xpath("//div[@class='carousel_container quadscreenshot_carousel']"));
    }

    private final By divDiscount = By.xpath("//div[@class='capsule header']/following-sibling::div/descendant::div[@class=\"discount_pct\"]");
    private  Label lblDiscount = new Label(By.xpath("//div[@class='capsule header']/following-sibling::div/descendant::div[@class=\"discount_pct\"]"));
    private static final String DIV_MAX_DISCOUNT = "//div[@class='capsule header']/following-sibling::div/descendant::div[@class=\"discount_pct\" and text()='%s']";
    private static String gameNameWithMaxDiscount = " ";
    private Label lblGameName = new Label(By.xpath("//h4[@class='hover_title']"));

    public int findMaxDiscounts() {


        List<WebElement> discounts = lblDiscount.getElements();


        //List<WebElement> discounts = baseElement.findElements(divDiscount);

        int maxDiscount = parseDiscounts(discounts.get(0).getText());

        for (WebElement element : discounts) {
            if (parseDiscounts(element.getText()) > maxDiscount) {
                maxDiscount = parseDiscounts(baseElement.getText(element));
            }
        }
        return maxDiscount;
    }

    public void choseGameWithMaxDiscount() {
        String nameDisc = "-" + findMaxDiscounts() + "%";

        List<WebElement> maxDiscountsList = baseElement.findElementsByName(DIV_MAX_DISCOUNT, nameDisc);
        if (maxDiscountsList.size() == 1) {
            baseElement.moveToElement(maxDiscountsList.get(0));
            gameNameWithMaxDiscount = lblGameName.getText();
            baseElement.clickAndWait(DIV_MAX_DISCOUNT,nameDisc);
        } else {
            int random = (int) (Math.random() * (maxDiscountsList.size()));
            baseElement.moveToElement(maxDiscountsList.get(random));
            gameNameWithMaxDiscount = lblGameName.getText();
            baseElement.clickAndWait(maxDiscountsList.get(random));
        }
    }

    public static String getGameNameWithMaxDiscount() {
        return gameNameWithMaxDiscount;
    }


    public int parseDiscounts(String text) {
        return Integer.parseInt(text.substring(1, text.indexOf("%")));
    }
}
