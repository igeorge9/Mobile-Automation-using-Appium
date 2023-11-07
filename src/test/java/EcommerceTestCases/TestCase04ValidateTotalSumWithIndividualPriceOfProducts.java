package EcommerceTestCases;

import MobileAutomation.MobileTestingAppium.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestCase04ValidateTotalSumWithIndividualPriceOfProducts extends BaseTest {

    @Test
    public void AddToCartAndCompareSum ()
    {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Amala Maria");
        driver.hideKeyboard();
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

//        Grab the price of each product and compare with the total sum given in screen

        List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int productCount=productPrices.size();
        double totalSum = 0;
        for (WebElement productPrice : productPrices)
        {
            String priceString = productPrice.getText();
//            double price = Double.parseDouble(priceString.substring(1));
            Double price = convertStringToNumberAndFormat(priceString,1); // format string and convert String to number - reusable method
            totalSum = price + totalSum;
        }
        String systemCalculatedPriceString = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

//         Double calculatedPrice = Double.parseDouble(systemCalculatedPriceString.substring(2));
        Double calculatedPrice = convertStringToNumberAndFormat(systemCalculatedPriceString,2);
        Assert.assertEquals(calculatedPrice,totalSum);

//        Perform long press on the Terms and Conditions link to view the T&C dialog box.

        WebElement termsAndConditionsButton= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        LongPressAction(termsAndConditionsButton);
        driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }
}