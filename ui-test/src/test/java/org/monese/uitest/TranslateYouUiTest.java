package org.monese.uitest;

import org.monese.uitest.screen.MainScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TranslateYouUiTest extends AbstractUiTest {
    private MainScreen mainScreen;

    @BeforeMethod
    public void beforeMethod() {
        mainScreen = new MainScreen(driver());
    }

    @Test
    public void translateFromEnglishToGerman() {
        final String languageFrom = "English";
        final String languageTo = "German";

        final String sourceString = "Hello! Good morning.";
        final String outputString = "Hallo! Guten Morgen.";

        mainScreen.clickLanguageFromButton().selectLanguage(languageFrom);
        mainScreen.clickLanguageToButton().selectLanguage(languageTo);
        mainScreen.getLanguageFromButton().requireText(languageFrom);
        mainScreen.getLanguageToButton().requireText(languageTo);

        mainScreen.getInputTextField().sendKeys(sourceString);
        mainScreen.getOutputTextField().requireText(outputString);
    }

    @Test
    public void verifyDeepLDoesNotWorkWithoutApiKey() {
        mainScreen.clickExpandMenuButton()
                .clickSettingsButton()
                .getServiceProviders()
                .singleElementBy(e -> e.getText().equals("DeepL"))
                .click();

        driver().navigate().back();
        mainScreen.getPopupMessage().requireText("Error in communicating with the server.");
    }

    @Test
    public void translateFromEnglishToEstonian() {
        final String languageFrom = "English";
        final String languageTo = "Estonian";

        final String sourceString = "Hello! Good morning.";
        final String outputString = "Tere! Tere hommikust.";

        mainScreen.clickLanguageFromButton().selectLanguage(languageFrom);
        mainScreen.clickLanguageToButton().selectLanguage(languageTo);
        mainScreen.getLanguageFromButton().requireText(languageFrom);
        mainScreen.getLanguageToButton().requireText(languageTo);

        mainScreen.getInputTextField().sendKeys(sourceString);
        mainScreen.getOutputTextField().requireText(outputString);
    }
}
