package com.automationtest.engine;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;

public class SerenityStepLogger {

	public static void verfiy(boolean expression, String title, String content) {
		if (!expression) {
			Serenity.recordReportData().withTitle(title).andContents(content);
			assertTrue(expression);
		}
	}

	public static void log(String title, String content) {
		Serenity.recordReportData().withTitle(title).andContents(content);
	}
}
