package com.bluep.pages.search;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPage {
    SelenideElement banner = $("div.banner-content-text");
    SelenideElement resultElement = $("#hsresults > div.result-item:first-child");

    public SelenideElement getBanner() {
        return banner;
    }
    
    public void clickFirstResult() {
        resultElement.click();
    }
}
