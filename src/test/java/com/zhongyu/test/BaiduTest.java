package com.zhongyu.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaiduTest {

    private static Logger logger = LoggerFactory.getLogger(BaiduTest.class);
    private RemoteWebDriver driver;
    //Selenium grid
    private static final String hostHub = "https://localhost/wd/hub";

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.toLowerCase());
        driver = new RemoteWebDriver(new URL(hostHub), capabilities);
        driver.manage().window().setSize(new Dimension(2048, 1080));
        driver.manage().window().setPosition(new Point(2048, 1080));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest() throws IOException {
        driver.get("https://www.baidu.com");
        logger.info("Baidu title：" + driver.getTitle());
        File screen = driver.getScreenshotAs(OutputType.FILE);
        String browserName = driver.getCapabilities().getBrowserName();
        FileUtils.copyFile(screen, new File(browserName + "_screenshot.png"));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
