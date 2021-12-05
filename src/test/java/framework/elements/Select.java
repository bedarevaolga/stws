package framework.elements;

import org.openqa.selenium.By;

public class Select extends BaseElement{

    public Select(final By locator, final String name) {
        super(locator, name);
    }


    public Select(By locator) {
        super(locator);
    }

    public Select(String strLocator,  String name) {

        super(By.xpath(String.format(strLocator, name)));
    }

}
