package Assignment;

import MobileAutomation.MobileTestingAppium.BaseTest;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertDialogsActions extends BaseTest {

    @Test
    public void AlertDialogsTest()
    {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        String popupMessage = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popupMessage,"Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
        driver.findElement(By.id("android:id/button1")).click();
    }

    @Test
    public void AlertListBox()
    {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command three']")).click();
        Assert.assertEquals(driver.findElement(By.id("android:id/message")).getText(),"You selected: 2 , Command three");
    }

    @Test
    public void SingleChoiceList()
    {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        WebElement singleChoicelist=  driver.findElement(AppiumBy.accessibilityId("Single choice list"));
        singleChoicelist.click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
        driver.findElement(By.id("android:id/button1")).click();

//      Verify if Satellite radio button was clicked

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Single choice list']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).isEnabled());
    }

    @Test
    public void TextEntryDialog()
    {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Username");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Password");
        driver.findElement(By.id("android:id/button1")).click();
    }
}
