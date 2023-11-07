package MobileAutomation.MobileTestingAppium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    public AppiumServiceBuilder builder;
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeTest
    public void configurationMethod() throws URISyntaxException, MalformedURLException {

        //    To start Appium server programmatically

        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4724);
        builder.withAppiumJS(new File("//usr//local//Cellar//node//21.1.0//lib//node_modules//appium//build//lib//main.js"));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
        service = AppiumDriverLocalService.buildService(builder);
        //start the Server with the builder
        service.start();

        //		AndroidDriver and iOSDriver exists
        //	    Appium code - talks to Appium Server and does those actions in the mobile devices
        //		Appium leveraged UiAutomator with its own wrapper and came up with UiAutomator2 driver to automate android apps.

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("IreneEmulator");
//        options.setApp("//Users//irenegeorge//Downloads//resources//ApiDemos-debug.apk");
        options.setApp("//Users//irenegeorge//Downloads//resources//General-Store.apk");
        options.setChromedriverExecutable("//Users//irenegeorge//Downloads//chromedriver_mac64");

        final String url = "http://127.0.0.1:4723";
        URL endpoint = new URI(url).toURL();
//        options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(endpoint, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void LongPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 0.75
        ));
    }

    public Double convertStringToNumberAndFormat(String originalValue, int startIndex) {
        return Double.parseDouble(originalValue.substring(startIndex));
    }

    @AfterTest
    public void tearDown() {
          driver.quit();
        service.stop();
    }
}
