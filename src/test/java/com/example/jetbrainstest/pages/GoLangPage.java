package com.example.jetbrainstest.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


// page_url = https://www.jetbrains.com/go/
public class GoLangPage {
    private final Logger LOG = LoggerFactory.getLogger(IntellijIdeaPage.class);

    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href ='/go/download/download-thanks.html']")
    private WebElement downloadButton;

    @FindBy(css = "div.wt-text-2")
    private WebElement freeDays;

    @FindBy(css = "a.follow__link")
    private List<WebElement> followLinks;

    @Step("Проверка активности кнопки загрузки")
    public Boolean checkIfDownloadButtonIsClickable(){
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    @Step("Проверка наличия текста")
    public String checkTextFreeDays() {
        LOG.info("Проверка наличия текста");
        String value = freeDays.getText();
        LOG.info("Получен текст: \"" + value + "\"");
        return value;
    }

    @Step("Проверка кликабельности кнопок подписки на иные ресурсы")
    public Boolean checkFollowLinksIsClickable(){
        LOG.info("Проверка кликабельности кнопок подписки на иные ресурсы");
        boolean enabled = false;
        for (WebElement links : followLinks)
            enabled = links.isEnabled() ? true : false;
        return enabled;
    }

    public GoLangPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
