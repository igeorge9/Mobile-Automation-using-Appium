package MobileAutomation.MobileTestingAppium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressAction extends BaseTest {

    @Test
    public void LongPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        LongPressAction(peopleNames);//       Long press method
        String sampleMenuText = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();

        //        To check if the Sample menu text is displayed

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
        Assert.assertEquals(sampleMenuText, "Sample menu", "Text is not matching");
    }
}
