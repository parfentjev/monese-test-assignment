package org.monese.uitest.screen;

import io.appium.java_client.android.AndroidDriver;
import org.monese.uitest.core.Element;
import org.monese.uitest.core.ElementList;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

import static org.openqa.selenium.By.xpath;

public class AbstractScreen {
    private final AndroidDriver driver;

    private final String POPUP_MESSAGE = "/hierarchy/android.widget.Toast[1]";

    public AbstractScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    protected AndroidDriver driver() {
        return driver;
    }

    protected Element findElement(By locator) {
        return new Element(driver.findElement(locator));
    }

    protected ElementList findElements(By locator) {
        return new ElementList(driver.findElements(locator).stream().map(Element::new).collect(Collectors.toList()));
    }

    public Element getPopupMessage() {
        return findElement(xpath(POPUP_MESSAGE));
    }
}
