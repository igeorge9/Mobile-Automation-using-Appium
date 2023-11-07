package EcommerceTestCases;

import MobileAutomation.MobileTestingAppium.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase03AddToCart extends BaseTest {

    @Test
    public void AddToCart() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amala Maria");
        driver.hideKeyboard();
        driver.findElement(By.className("android.widget.Button")).click();
//        Only name needs to be entered additionally
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"))"));
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println(productCount);
        for (int i=0;i<productCount;i++)
        {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("LeBron Soldier 12 "))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(1500);

//        Step to verify the product in the cart is same as what we added
//        Adding WebDriverWait or ExplicitWait for the title 'Cart' to appear in the final page of Added to Cart
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        String actualProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(actualProduct,"LeBron Soldier 12 ");
    }
}
