package com.juaracoding.selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

//https://devhints.io/xpath //cheatseet xpath

public class SeleniumFrame {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/frames";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");


        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page :" + title);

        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);

        String frameTitle = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Frame :" + frameTitle);


        //keluar dari frame
        driver.switchTo().defaultContent();

        String txtDescPage = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText();
        System.out.println("Desc :" + txtDescPage);

        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//div[contains(@class,'element-list collapse show')]//li[@id='item-4']")).click();
        System.out.println("modal click");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        String buttonSmall = driver.findElement(By.xpath("//*[@id=\"showSmallModal\"]")).getText();
        System.out.println(buttonSmall);
        String buttonLarge = driver.findElement(By.xpath("//*[@id=\"showLargeModal\"]")).getText();
        System.out.println(buttonLarge);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");

    }
}
