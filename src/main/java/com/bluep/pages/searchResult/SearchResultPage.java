package com.bluep.pages.searchResult;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    SelenideElement breadcrumb = $("ul.hs-breadcrumb-menu");
    
    public SelenideElement getBreadcrumb() {
        return breadcrumb;
    }
    
}