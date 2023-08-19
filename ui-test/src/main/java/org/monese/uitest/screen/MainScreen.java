package org.monese.uitest.screen;

import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.monese.uitest.core.Element;

import static org.openqa.selenium.By.xpath;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MainScreen extends AbstractScreen {
    static String LANGUAGE_FROM_BUTTON = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView";
    static String LANGUAGE_TO_BUTTON = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView";
    static String INPUT_TEXT_FIELD = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.widget.EditText[1]";
    static String OUTPUT_TEXT_FIELD = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[1]/android.widget.ScrollView/android.widget.EditText[2]";
    static String EXPAND_MENU_BUTTON = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[4]/android.widget.Button[3]";

    public MainScreen(AndroidDriver driver) {
        super(driver);
    }

    public Element getLanguageFromButton() {
        return findElement(xpath(LANGUAGE_FROM_BUTTON));
    }

    public LanguageSelectionScreen clickLanguageFromButton() {
        getLanguageFromButton().click();

        return new LanguageSelectionScreen(driver());
    }

    public Element getLanguageToButton() {
        return findElement(xpath(LANGUAGE_TO_BUTTON));
    }

    public LanguageSelectionScreen clickLanguageToButton() {
        getLanguageToButton().click();

        return new LanguageSelectionScreen(driver());
    }

    public Element getInputTextField() {
        return findElement(xpath(INPUT_TEXT_FIELD));
    }

    public Element getOutputTextField() {
        return findElement(xpath(OUTPUT_TEXT_FIELD));
    }

    public Element getExpandMenuButton() {
        return findElement(xpath(EXPAND_MENU_BUTTON));
    }

    public MainMenu clickExpandMenuButton() {
        getExpandMenuButton().click();

        return new MainMenu(driver());
    }
}
