package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:14102/");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            // TO-DO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void pruebaUno(){
        driver.findElement(By.name("username")).sendKeys("user");
        driver.findElement(By.name("password")).sendKeys("user");
        driver.findElement(By.xpath("/html/body/div[2]/form/div/div/button")).click();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            // TO-DO Auto-generated block
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/form/div/div/p/span")).getText().contains("Wrong username or password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
