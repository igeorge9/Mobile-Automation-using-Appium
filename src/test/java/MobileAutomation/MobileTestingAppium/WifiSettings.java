package MobileAutomation.MobileTestingAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.internal.ConfigurationMethod;

public class WifiSettings extends BaseTest {

    @Test
    public void WifiSettingsMethod() throws MalformedURLException, URISyntaxException {

        // AppiumBy is exclusively for mobile apps whereas By is for finding locators in web and mobile apps.

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Irene Wifi");
//		driver.findElement(By.id("android:id/button2")).click();
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
