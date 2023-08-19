package org.monese.uitest.screen;

import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.monese.uitest.core.ElementList;

import static org.openqa.selenium.By.xpath;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SettingsScreen extends AbstractScreen {
    static String SERVICE_PROVIDERS = "//androidx.compose.ui.platform.h1/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.TextView";

    public SettingsScreen(AndroidDriver driver) {
        super(driver);
    }

    public ElementList getServiceProviders() {
        return findElements(xpath(SERVICE_PROVIDERS));
    }
}
