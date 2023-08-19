package org.monese.uitest.screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LanguageSelectionScreen extends AbstractScreen {
    static String LANGUAGES = "android.widget.TextView";

    public LanguageSelectionScreen(AndroidDriver driver) {
        super(driver);
    }

    public LanguageSelectionScreen selectLanguage(String language) {
        findElements(AppiumBy.cssSelector(LANGUAGES))
                .singleElementBy(e -> e.getText().equals(language))
                .click();

        return this;
    }
}
