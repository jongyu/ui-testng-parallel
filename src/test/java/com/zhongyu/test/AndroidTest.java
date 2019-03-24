package com.zhongyu.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {

    private static Logger logger = LoggerFactory.getLogger(AndroidTest.class);
    private AndroidDriver<WebElement> driver;

    @Parameters({"host", "deviceName", "deviceVersion", "udid", "systemPort"})
    @BeforeTest
    public void senUp(String host, String deviceName, String deviceVersion, String udid, String systemPort) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceVersion);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "app package");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "app activity");
        driver = new AndroidDriver<>(new URL(host), capabilities);
    }

    @Test
    public void test() {
        driver.getCapabilities();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
