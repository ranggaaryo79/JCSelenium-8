package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select color = new Select(selectColor);
        color.selectByValue("4");
        color.selectByIndex(1);
        color.selectByVisibleText("Black");
        System.out.println("purple");

        WebElement multiSelectColor = driver.findElement(By.name("cars"));
        Select merk = new Select(multiSelectColor);
        merk.selectByIndex(2);
        merk.selectByVisibleText("Volvo");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Delay 3 sec");


        driver.quit(); // menutup all tab
        System.out.println("Quit Browser");
    }
}
