package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    //public String baseUrl ="https://practicetestautomation.com/practice-test-login/";
    public String baseUrl ="https://practice-automation.com/form-fields/";
    public int TIME_OUT = 10;


    @BeforeClass
    public void setup() {
        //Creamos la instancia del navegador
        driver = new FirefoxDriver();
        //Configuramos la instancia del navegador para abrir en modo maximizado
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        //Abrimos la url de practicas
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            //driver.close();
        }
    }
}
