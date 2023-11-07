package EcommerceTestCases;

import MobileAutomation.MobileTestingAppium.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Set;

public class TestCase05SwitchToWebBrowserFromNativeApp extends BaseTest {

    @Test
    public void SwitchToWebBrowserFromNativeApp() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amala Maria");
        driver.hideKeyboard();
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
        Set<String> contextNames= driver.getContextHandles();
        for(String contextName:contextNames)
        {
            System.out.println(contextName);
        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//        driver.findElement(By.name("q")).sendKeys("W3schools");
    }
}
