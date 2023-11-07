package EcommerceTestCases;

import MobileAutomation.MobileTestingAppium.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01FillFormAnd02ToastMessages extends BaseTest {

    @Test
    public void fillForm() throws InterruptedException {

//        Steps to perform
//            1. Click on the dropdown and select some country other than listed in first view(eg.India)
//               a) Click on dropdown
//               b) Scroll to required country name
//               c) Click on the country name
//            2. Enter the name in the text box
//            3. Hide the keyboard
//            4. Click on the submit button

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amala Maria");
        driver.hideKeyboard();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.className("android.widget.Button")).click();
    }

    @Test
    public void toastMessageCheck()
    {
//        Submit without changing any values and keeping Name field empty and check the toast message is appearing as expected
//        Toast messages will have a tag name android.widget.Toast
//        Every toast message will have an attribute called 'name' where the actual toast message text is present

        driver.findElement(By.className("android.widget.Button")).click();
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}