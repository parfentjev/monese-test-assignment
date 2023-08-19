package org.monese.uitest.screen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.monese.uitest.core.Element;
import org.monese.uitest.core.ElementList;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MainMenu extends AbstractScreen {
    static String MENU_ITEMS = "/hierarchy/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.widget.TextView";

    public MainMenu(AndroidDriver driver) {
        super(driver);
    }

    private ElementList getItems() {
        return findElements(AppiumBy.xpath(MENU_ITEMS));
    }

    public Element getSettingsButton() {
        return getItems().singleElementBy(e -> e.getText().equals("Settings"));
    }

    public SettingsScreen clickSettingsButton() {
        getSettingsButton().click();

        return new SettingsScreen(driver());
    }
}
