package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestForm {
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void testUrl() {
        delay(1);
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("get URL" + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String title = driver.getTitle(); //scrapping
        System.out.println("Title Page =" + title);

        //step verify
        Assert.assertEquals(title, "DEMOQA");
    }

    @Test(priority = 2)
    public void testFormIdentity() {
        delay(1);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("Juaracoding@mail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
        System.out.println("Data berhasil disimpan");

        String txtName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assert.assertTrue(txtName.contains("JuaraCoding"));
        String txtEmail = driver.findElement(By.xpath("//p[@id='email']")).getText();
        Assert.assertTrue(txtEmail.contains("Juaracoding@mail.com"));

    }

    @AfterClass
    public void quitBrowser() {
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik) {
        System.out.println("Delay 3 sec");
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
