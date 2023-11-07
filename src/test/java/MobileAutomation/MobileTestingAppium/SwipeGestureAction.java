package MobileAutomation.MobileTestingAppium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeGestureAction extends BaseTest {

    @Test
    public void SwipeOnTheScreen() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true"); // The focusable value of first image will be true
//      Swipe and move the focus to next image

        swipeAction(firstImage, "left");
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");  // The focus moves to second image and focusable value of first image will be false

    }
}
