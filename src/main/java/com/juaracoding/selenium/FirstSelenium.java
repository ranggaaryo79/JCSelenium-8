package com.juaracoding.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://lms.juaracoding.com/mod/quiz/attempt.php?attempt=5361&cmid=5749&page=3";

        driver.get(url);
        System.out.println("get URL");
//        driver.close(); // hanya menutup 1 tab
        driver.manage().window().maximize();
        String title = driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/div[1]/div/a")).getText(); //scrapping
        System.out.println("Title Page =" + title);
        System.out.println("Maximize Browser");
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