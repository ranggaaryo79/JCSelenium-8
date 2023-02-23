package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class SeleniumLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //locator

        String title = driver.findElement(By.className("main-header")).getText(); //scrapping
        System.out.println("Title Page =" + title);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("Juaracoding@mail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.id("submit")).click();
        System.out.println("Data berhasil disimpan");

        //verify
        System.out.println("result case : ");
        if (title.equals("Text Box")) {
            System.out.println("Passed");
        } else {
            System.out.println("fail");
        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        System.out.println("button");

        driver.get("https://www.google.co.id/");
        driver.findElement(By.linkText("Gmail")).click();


        System.out.println("Delay 3 sec");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit(); // menutup all tab
        System.out.println("Quit Browser");
    }
}
