package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;



    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void Url() {
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        System.out.println("get URL " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }

    @Test(priority = 3)
    public void testValidLogin() {
        //step action
        delay(1);
        login("admin","admin123");
        String txtVerify = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();

        //step verify
        Assert.assertEquals(txtVerify, "Dashboard");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        delay(1);
        login("admin","admin");
        String txtVerifyAlert = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")).getText();
        System.out.println("Alert : " + txtVerifyAlert);
        //step verify
        Assert.assertEquals(txtVerifyAlert, "Invalid credentials");

    }

    @AfterClass
    public void quitBrowser() {
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik) {
        System.out.println("Delay");
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(String username, String password){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }


}
