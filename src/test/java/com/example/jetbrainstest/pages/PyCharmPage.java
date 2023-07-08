package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PyCharmPage {

    private final Logger LOG = LoggerFactory.getLogger(PyCharmPage.class);

    WebDriver driver;
    @FindBy(css = ".menu-second-title-box__title.wt-h3")
    private WebElement pyCharmButton;

    @FindBy(css = ".overview-header__download")
    private WebElement downloadButton;
    @Step("Переходим по ссылке: https://www.jetbrains.com/pycharm/ и проверяем, что кнопка Download отображается")
    public boolean downloadButtonIsActive(){
        LOG.info("Проверка доступности кнопки 'Download'");
        driver.get("https://www.jetbrains.com/pycharm/");
        return downloadButton.isDisplayed();
    }

    @Step("Переходим по ссылке: https://www.jetbrains.com/pycharm/ и проверяем, что кнопка PyCharm отображается")
    public boolean pyCharmButtonIsActive(){
        LOG.info("Проверка доступности кнопки 'PyCharm'");
        driver.get("https://www.jetbrains.com/pycharm/");
        return pyCharmButton.isDisplayed();
    }
    @Step("Переходим по ссылке: https://www.jetbrains.com/pycharm/ и проверяем, нажимаем на кнопку PyCharm и проверяем УРЛ")
    public String clickPyCharmButtonAndCheckUrl(){
        LOG.info("Проверка URL страницы, на которую попадаем после нажатия кнопки 'PyCharm'");
        driver.get("https://www.jetbrains.com/pycharm/");
        pyCharmButton.click();
        return driver.getCurrentUrl();
    }


    public PyCharmPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
