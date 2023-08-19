package org.monese.uitest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.monese.uitest.util.UiConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

public abstract class AbstractUiTest {
    private AppiumDriverLocalService service;
    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() {
        service = new AppiumServiceBuilder()
                .withIPAddress(UiConfiguration.APPIUM_IP)
                .usingPort(UiConfiguration.APPIUM_PORT)
                .build();

        driver = new AndroidDriver(service.getUrl(), new UiAutomator2Options()
                .setApp(ClassLoader.getSystemResource(UiConfiguration.APK_FILE).getPath())
                .eventTimings());
    }

    @AfterMethod
    public void tearDown() {
        Optional.ofNullable(driver).ifPresent(AndroidDriver::quit);
        Optional.ofNullable(service).ifPresent(AppiumDriverLocalService::stop);
    }

    protected AndroidDriver driver() {
        return driver;
    }
}
