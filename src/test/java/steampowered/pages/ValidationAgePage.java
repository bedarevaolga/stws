package steampowered.pages;

import framework.BaseSteamPage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.Select;
import org.openqa.selenium.By;

import static steampowered.tests.ChoosingOfTheGameWithMaxDiscountTest.localLoader;

public class ValidationAgePage extends BaseSteamPage {
    public ValidationAgePage() {
        super( By.xpath("//select[@name='ageYear']"));
    }

    private Label lblAgeValidation = new Label(By.xpath("//div[@class='agegate_birthday_desc']"));
    private Select sltAgeYear = new Select(By.xpath("//select[@name='ageYear']"));
    private Button btnOpenPage = new Button( "//span[text()='%s']/..", localLoader.getProperty("openPage"));

    public void ageChek(String year){
        if (lblAgeValidation.isPresent()) {
            sltAgeYear.select(year);
            btnOpenPage.clickAndWait();
        }
    }

}
