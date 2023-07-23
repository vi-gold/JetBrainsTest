package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;

//page_url = https://www.jetbrains.com/datagrip/
public class DataGripPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy(xpath = "//a[contains(@class,'wt-button wt-button_mode_contrast')]")
    private WebElement downloadDataGripButton;

    @FindBy(xpath = "//button[text()='Take a tour']")
    private WebElement clickTakeATourButton;

    @FindBy(xpath = "//button[normalize-space()='.exe']")
    private WebElement downloadListResult;

    @FindBy(xpath = "(//li[@class='_wrapper_1v6h6tr_8'])")
    private List <WebElement> resultsComboBox;

    @FindBy(xpath = "//button[@data-test='youtube-player-button']")
    private WebElement clickVideo;

    @FindBy(xpath = "//button[@data-test='close-button']")
    private WebElement closeVideoButton;

    public List<WebElement> getComboBoxes() {
        downloadListResult.click();
        List<WebElement> comboBoxes = resultsComboBox;
        for (WebElement comboBox : comboBoxes) {
            LOG.infoWithScreenshot("ComboBox DataGrip button download: " + comboBox.getText());
        }
        return comboBoxes;
    }

    public void clickButtonDataGripDownload(){
        downloadDataGripButton.click();
        LOG.infoWithScreenshot("Клик кнопки загрузки DataGripPage");
    }

    public void clickButtonTakeATour(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");
        clickTakeATourButton.click();
        LOG.info("Клик кнопки TakeATour");
    }

    public boolean checkTakeATourButton(){
        LOG.infoWithScreenshot("Проверка активности кнопки");
        return clickTakeATourButton.isEnabled();
    }

    public void clickPlayAndStopPlayer(){
        clickVideo.click();
        LOG.info("Воспроизведение видео");
        waitSleep();
    }

    public boolean isPlayerClosed(){
        LOG.info("Закрытие плеера");
        return !closeVideoButton.isEnabled();
    }

    public void waitSleep(){WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));}

    public DataGripPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

}