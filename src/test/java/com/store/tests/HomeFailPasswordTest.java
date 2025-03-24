package com.store.tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeFailPasswordTest extends BaseTest {


    public String titlePage = "Test Login | Practice Test Automation";
    public String negativeMenssagePassword = "Your password is invalid!";

    public WebElement inputUsername;
    public WebElement inputPassword;
    public WebElement btnSubmit;


    @Test(priority = 1)
    public void verifyTitle(){
        assertEquals(driver.getTitle(),titlePage);
    }

    @Test(priority = 2)
    public void negativeLoginTest(){
        System.out.println("Cargamos los elementos");
        //Capturamos los elementos
        this.inputUsername = driver.findElement(By.id("username"));
        this.inputPassword =  driver.findElement(By.id("password"));
        this.btnSubmit = driver.findElement(By.id("submit"));
        //enviamos los datosdel formulario
        this.inputUsername.clear();
        this.inputPassword.clear();
        this.inputUsername.sendKeys("student");
        this.inputPassword.sendKeys("incorrectPassword");
        //Damos clic en el boton 'submit'
        this.btnSubmit.click();
    }

    @Test(priority = 3)
    public void validateVisibleMessage(){
        //Validamos que el mensaje este visible.
        boolean messageFailLogin = driver.findElement(By.xpath("//*[@class='show']")).isDisplayed();
        assertTrue(messageFailLogin);
    }

    @Test(priority = 4)
    public void validateMessage(){
        //Validamos que el mensaje sea en correcto para el caso
        WebElement message = driver.findElement(By.xpath("//*[@class='show']"));
        assertEquals(message.getText(),negativeMenssagePassword);
    }





}
