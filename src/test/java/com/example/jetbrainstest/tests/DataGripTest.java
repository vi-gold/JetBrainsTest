package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.DataGripPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MyExtension.class)
public class DataGripTest extends BaseTest {

    private DataGripPage dataGripPage;

    @BeforeEach
    @Override
    @Step("Переход в раздел Idea")
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/datagrip/");
        dataGripPage = new DataGripPage(getDriver());
    }

    @Test
    @DisplayName("Тест: checkPageDataGripAndDownloadButtonComboBox - Проверка перехода на страницу и работы чекбосов кнопки Download")
    public void checkPageDataGripAndDownloadButtonComboBox(){
        dataGripPage.clickButtonDataGripDownload();
        dataGripPage.waitSleep();
        assertEquals("https://www.jetbrains.com/datagrip/download/#section=windows",
                getDriver().getCurrentUrl(), "Не удалось перейти на ожидаемую страницу!");
        assertFalse(dataGripPage.getComboBoxes().isEmpty(),"Список комбобоксов пустой");
    }

    @Test
    @DisplayName("Тест: playVideoButtonTakeATour - Проверка открытие и закрытие видеоплеера")
    public void playVideoButtonTakeATour(){
        assertTrue(dataGripPage.checkTakeATourButton(),"Кнопка не активна");
        dataGripPage.clickButtonTakeATour();
        dataGripPage.clickPlayAndStopPlayer();
        assertFalse(dataGripPage.isPlayerClosed(), "Видеоплеер не закрылся");
    }
}
