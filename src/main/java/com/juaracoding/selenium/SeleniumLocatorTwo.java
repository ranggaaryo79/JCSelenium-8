package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocatorTwo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/checkbox";
        driver.get(url);
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //locator

        String title = driver.findElement(By.className("main-header")).getText(); //scrapping
        System.out.println("Title Page =" + title);
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]")).click();
        String txtDownload = driver.findElement(By.xpath("*[@id='result']/span[2]")).getText();
        System.out.println(txtDownload);
        js.executeScript("windows.scrollBy(0,00)");

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
