package com.amazon.selenium.test.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class PageUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Threed sleeping error", e);
        }
    }

    public static WebElement findByContainsText(List<WebElement> items, String text) {
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                return item;
            }
        }
        throw new RuntimeException("Text not found in web elements");
    }
}
