package ru.omen.app;

import junit.framework.Assert;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by OmeN on 13.05.2016.
 */
public class FirstTest {

    @Test
    public void testBegin() throws IOException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://google.ru");
        System.out.println(driver.getTitle());

        By elementLocation = By.id("lst-ib");
        WebElement element = driver.findElement(elementLocation);
        element.sendKeys("hltv.org");

        WebElement elementBtn = driver.findElement(By.name("btnG"));
        String text = elementBtn.getText();
        System.out.println("Element = " + new String(text.getBytes("ISO-8859-1"), "UTF-8"));
        elementBtn.click();
        System.out.println("Title = " + driver.getTitle());
        Thread.sleep(1000);
        System.out.println("Title = " + new String(driver.getTitle().getBytes("ISO-8859-1"), "UTF-8"));
        Assert.assertTrue("Проверка title на hltv.org", driver.getTitle().contains("hltv.org"));
        driver.quit();
    }
}
