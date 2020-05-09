package com.objectrepsoitory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page {
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement Signin;

    @FindBy(id = "search_query_top")
    WebElement Search_EditBox;

    @FindBy(name = "submit_search")
    WebElement Search_Button;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
    WebElement Women;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    WebElement Dressess;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    WebElement T_shirts;

    @FindBy(xpath = "//*[@id='homepage-slider']/div/div[2]/div/a[1]")
    WebElement Image_Slide_Bacward;

    @FindBy(xpath = "//*[@id='homepage-slider']/div/div[2]/div/a[2]")
    WebElement Image_Slide_Forward;

    @FindBy(xpath = "//*[@id='home-page-tabs']/li[1]/a")
    WebElement Popular;

    @FindBy(xpath = "//*[@id='home-page-tabs']/li[2]/a")
    WebElement Best_Seller;

    public void clickOnSignIn()
    {
        Signin.click();
    }
}
