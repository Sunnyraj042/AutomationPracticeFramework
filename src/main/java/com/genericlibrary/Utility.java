package com.genericlibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

    public  void selectbyVisibleText(WebElement web, String input) {
        Select sel = new Select(web);
        sel.selectByVisibleText(input);
    }

    public void selectbyIndex(WebElement web, int input) {
        Select sel = new Select(web);
        sel.selectByIndex(input);
    }

    public  void selectbyValue(WebElement web, String input) {
        Select sel = new Select(web);
        sel.selectByValue(input);
    }

    public static void breaks(String a) {
        String[] dat = a.split("-");

        String date = dat[0];
        String month = dat[1];
        String year = dat[2];
    }
}
