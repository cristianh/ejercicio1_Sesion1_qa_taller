package com.store.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeFailPasswordTest {

    WebDriver driver;
    String baseUrl ="https://practicetestautomation.com/practice-test-login/";
    String titlePage = "Test Login | Practice Test Automation";
    String negativeMenssagePassword = "Your password is invalid!";


    @BeforeClass
    public void setup() {
        //Creamos la instancia del navegador
        driver = new FirefoxDriver();
        //Abrimos la url de practicas
        driver.get(baseUrl);
        //Configuramos la instancia del navegador para abrir en modo maximizado
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    public void verifyTitle(){
        assertEquals(driver.getTitle(),titlePage);
    }

    @Test(priority = 2)
    public void negativeLoginTest(){
        //Capturamos los elementos y enviamos los datos
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
        //Damos clic en el boton 'submit'
        driver.findElement(By.id("submit")).click();
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


    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.close();
        }
    }


}
