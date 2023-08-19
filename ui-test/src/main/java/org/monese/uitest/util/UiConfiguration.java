package org.monese.uitest.util;

import org.monese.shared.Configuration;

public class UiConfiguration {
    public static final String APPIUM_IP;
    public static final int APPIUM_PORT;
    public static final String APK_FILE;

    static {
        Configuration configuration = new Configuration(UiConfiguration.class.getClassLoader().getResourceAsStream("ui-test.properties"));
        APPIUM_IP = configuration.getString("appiumIp");
        APPIUM_PORT = configuration.getInteger("appiumPort");
        APK_FILE = configuration.getString("apkFile");
    }
}
