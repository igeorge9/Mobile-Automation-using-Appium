package MobileAutomation.MobileTestingAppium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class ScrollGestureAction extends BaseTest {

    @Test
    public void ScrollToAnElement() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

//        WebElement ScrollIntoTextValue=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WebView\"]"));
//      boolean canScrollMore;
//        do {
//            canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//                    "left",50,"top",50,"width",50,"height",50,
//                    "direction", "down",
//                    "percent", 50,
//                    "strategy", "accessibility id",
//                    "selector", "WebdriverIO logo",
//                    "percentage", 50,
//                    "direction", "down",
//                    "maxCount", 3));
//                    ));
//        }while(canScrollMore);
    }
}