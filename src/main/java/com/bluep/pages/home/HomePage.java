package com.bluep.pages.home;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    String url = "https://www.tobania.be/en-gb/";

    SelenideElement denyCookiesBtn = $("#CybotCookiebotDialogBodyButtonDecline");
    SelenideElement searchIcon = $("#hs_cos_wrapper_Global_search_header_ > svg");
    SelenideElement searchField = $("input[name='term']");

    public void navigate() {
        open(url);
        assertEquals(url, WebDriverRunner.url());
    }
    
    public void denyCookies() {
        denyCookiesBtn.click();
    }

    public void fillInInput(String searchText) {
        Selenide.executeJavaScript("arguments[0].style.width = '500px';", searchField);
        searchField.sendKeys(searchText);
    }
    
    public void clickSearchIcon() {
        searchIcon.click();
    }
    
    public void pressEnter() {
        searchField.sendKeys(Keys.ENTER);
    }
}
