package com.digitalaptech.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * ============================================================================
 * Class Name : MainTest
 * Description:
 *
 * @author Saikat Das
 * @version 1.0
 * @since 9/17/2026
 * ============================================================================
 */
public class MainTest {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("https://digitalaptech.com/");
    }

    @Test(priority=1)
    public void findAllTheSubPagesUnderIndustries(){
        WebElement industriesDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Industries']")));
        industriesDropDown.click();
        List<WebElement> listOfSubMenu = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Industries']//following-sibling::ul//li//ul//li//ul//li//a")));
        for(WebElement subMenuElement : listOfSubMenu){
            System.out.println(subMenuElement.getText());
        }
    }

    @Test(priority=2)
    public void FillTheFormForThePageOfHospitalityAndTourism(){

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
