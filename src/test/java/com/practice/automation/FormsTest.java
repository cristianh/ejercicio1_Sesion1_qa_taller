package com.practice.automation;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    public  Select cbQuestionLikeAuto;

    @BeforeMethod
    public void init(){
        WebElement  selectInput =driver.findElement(By.id("automation"));
        cbQuestionLikeAuto = new Select(selectInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectInput);
    }

    @Test(priority = 2)
    public void testSelectByValue(){
        cbQuestionLikeAuto.selectByValue("yes");
    }

    @Test(priority = 1)
    public void testSelectByIndex(){;
        cbQuestionLikeAuto.selectByIndex(3);
    }

    @Test(priority = 2)
    public void testSelectByValueText(){
        cbQuestionLikeAuto.selectByVisibleText("Undecided");
    }
}
