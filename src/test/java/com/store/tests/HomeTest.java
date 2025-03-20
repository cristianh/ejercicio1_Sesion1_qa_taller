package com.store.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest {

    WebDriver driver;
    String titlePage = "Test Login | Practice Test Automation";


    //@BeforeMethod
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1024,1024));

    }

    @Test(priority = 1)
    public void verifyTitle(){
        assertEquals(driver.getTitle(),titlePage);
    }

    @Test(priority = 2)
    public void verifyLogo(){
        boolean logo = driver.findElement(By.xpath("//img[@class='custom-logo']")).isDisplayed();
        assertTrue(logo);
    }

    @Test(priority = 3)
    public void PositiveLogInTest(){
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        //driver.findElement(By.id("submit")).submit();
        driver.findElement(By.id("submit")).click();
        WebElement title = driver.findElement(By.xpath("//*[@class='post-title']"));
        assertEquals(driver.getTitle(),title.getText());
    }

    //@AfterMethod
    @AfterClass
    public  void tearDown(){
        if(driver != null){
            driver.close(); // Cierra el navegador pero no elimina la sesion del driver
            //driver.quit(); //Elimina la sesion del driver
        }

    }
}
