package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.GoLangPage;
import com.example.jetbrainstest.pages.IntellijIdeaPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class GoLangTest extends BaseTest {
    private GoLangPage GoLangPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/go/");
        GoLangPage = new GoLangPage(getDriver());
    }

    @Test
    @DisplayName("Проверка активности кнопки скачивания")
    public void downloadButtonCheck() {
        assertTrue(GoLangPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка текста Free 30-day trial")
    public void checkTextFreeDays() {
        assertEquals("Free 30-day trial", GoLangPage.checkTextFreeDays(),
                "Надписи Free 30-day tria нет");
    }

    @Test
    @DisplayName("Проверка доступности кнопок подписки")
    public void followLinksCheck() {
        assertTrue(GoLangPage.checkFollowLinksIsClickable(), "Кнопка или кнопки подписки не активны");
    }

}
