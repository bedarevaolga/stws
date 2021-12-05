package steampowered.pages;

import framework.BaseSteamPage;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.*;

import static steampowered.tests.ChoosingOfTheGameWithMaxDiscountTest.localLoader;

public class GamePage extends BaseSteamPage {
    public GamePage() {
        super(By.xpath("//img[@class='game_header_image_full']"));
    }


    private Label lblGameName = new Label(By.xpath("//div[@id='appHubAppName']"));


    public void clickInstallSteam(String btn) {
        new Button(BUTTON, localLoader.getProperty(btn)).clickAndWait();
    }


    public String getGameName(String year) {
        return lblGameName.getText();
    }


}
