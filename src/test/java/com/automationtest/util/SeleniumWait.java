package com.automationtest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumWait {


    /**
     * @param driver
     * @param l      seconds
     * @param x      WebElement want to check
     */
    public static void waitVisibility(WebDriver driver, long l, WebElement x) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, l);
        webDriverWait.until(ExpectedConditions.visibilityOf(x));

    }

    /**
     * @param driver
     * @param l      seconds
     * @param x      WebElement want to check
     */
    public static void waitClickable(WebDriver driver, long l, WebElement x) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, l);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(x));

    }


    /**
     * @param driver
     * @param l      seconds
     * @param url      Url want to check
     */
    public static void waitUntil(WebDriver driver, long l, String url){

        WebDriverWait wait = new WebDriverWait(driver, l);
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
