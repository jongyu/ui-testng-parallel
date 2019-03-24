package com.zhongyu.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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

public class IOSTest {

    private static Logger logger = LoggerFactory.getLogger(IOSTest.class);
    private AndroidDriver<WebElement> driver;

    @Parameters({"host", "deviceName", "deviceVersion", "udid", "wdaLocalPort"})
    @BeforeTest
    public void senUp(String host, String deviceName, String deviceVersion, String udid, String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceVersion);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wdaLocalPort);
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "bundleId");
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
