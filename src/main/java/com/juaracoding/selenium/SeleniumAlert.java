package com.juaracoding.selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/alerts";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");


        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("TITLE :" + title);
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("Alert Ok");
        driver.findElement(By.id("timerAlertButton")).click();
        System.out.println("Delay 5 sec");
        try {
            Thread.sleep(5000);
        driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("rangga");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();

        System.out.println("Delay 3 sec");


        driver.quit(); // menutup all tab
        System.out.println("Quit Browser");

    }
}
