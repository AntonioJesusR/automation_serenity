package com.pol.bss.pol_bss_automationtest.engine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.Managed;

public class UiSteps{

	@Managed
	WebDriver driver;

	protected WebElement find(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	protected void implicitWait(Integer seconds) {
        seconds = 5;
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	protected Boolean exists(String xpath) {
		return driver.findElements(By.xpath(xpath))
				.size() > 0;
	}

	protected WebDriver driver() {
		return driver;
	}
}
