package org.monese.uitest.core;

import org.openqa.selenium.*;

import java.util.stream.Collectors;

import static org.monese.shared.AwaitUtils.await;

public class Element {
    private final WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public Element requireText(String value) {
        await(() -> webElement.getText().equals(value));

        return this;
    }

    public void click() {
        webElement.click();
    }

    public void submit() {
        webElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

    public String getTagName() {
        return webElement.getTagName();
    }

    public String getDomProperty(String name) {
        return webElement.getDomProperty(name);
    }

    public String getDomAttribute(String name) {
        return webElement.getDomAttribute(name);
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    public String getAriaRole() {
        return webElement.getAriaRole();
    }

    public String getAccessibleName() {
        return webElement.getAccessibleName();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public ElementList findElements(By by) {
        return new ElementList(webElement.findElements(by).stream().map(Element::new).collect(Collectors.toList()));
    }

    public Element findElement(By by) {
        return new Element(webElement.findElement(by));
    }

    public SearchContext getShadowRoot() {
        return webElement.getShadowRoot();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        return webElement.getLocation();
    }

    public Dimension getSize() {
        return webElement.getSize();
    }

    public Rectangle getRect() {
        return webElement.getRect();
    }

    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }
}
