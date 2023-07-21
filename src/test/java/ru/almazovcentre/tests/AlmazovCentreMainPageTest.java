package ru.almazovcentre.tests;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.almazovcentre.page.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AlmazovCentreMainPageTest extends TestBase {

    static MainPage mainPage = new MainPage();
    @BeforeAll
    static void informationTableClose() {
        mainPage.openPage()
                .closeInfoMessage();
    }

    @BeforeEach
     void openPage() {
        mainPage.openPage();
    }

    static Stream<Arguments> almazovCentreLocaleTest() {
        return
                Stream.of(
                        Arguments.of(Locale.EN, List.of("Home", "About", "Science", "Education", "Clinic", "For patients", "News", "Partners")),
                        Arguments.of(Locale.RU, List.of("Главная", "О Центре", "Наука", "Образование", "Клиника", "Для пациента", "Новости", "Партнеры"))
                );
    }

    @MethodSource
    @DisplayName("При изменении языка должны поменяться названия заголовков")
    @ParameterizedTest
    void almazovCentreLocaleTest(Locale locale, List<String> expectedButtons) {

        $$("#qtranslateslug-2 option").find(value("http://www.almazovcentre.ru/?lang=" + locale.name())).click();
        $$("#nav a").filter(visible).should(texts(expectedButtons));
    }

    @ValueSource(strings = {"Администрация Центра", "Основатель Центра — Владимир Андреевич Алмазов",
            "История Центра", "История РНХИ им. проф. А. Л. Поленова", "Миссия, видение, ценности",
            "Попечительский совет Центра", "Международное сотрудничество", "Устойчивое развитие",
            "Строительство", "Вакансии", "Контактная информация", "Адреса и схема проезда",
            "Доступность объектов Центра Алмазова для маломобильных групп населения (МГН)",
            "Сведения о медицинской организации", "Проживание", "Издания", "Музей",
            "Противодействие коррупции"})
    @DisplayName("Проверка ссылок во вкладке 'О Центре' на главной странице 'http://www.almazovcentre.ru/'")
    @ParameterizedTest(name = "При нажатии на ссылку {0} осуществляется переход на страницу {0}")
    void navigationSystemSubMenuTest(String name) {
        $$("#nav a").find(text("О центре")).hover();
        $$(".sub-menu a").find(text(name)).click();
        $$(".posttitle").should(texts(name));
    }
    @CsvFileSource(resources = "/almazovCentreTest.csv")
    @DisplayName("Проверка ссылок в основном разделе главной страницы")
    @ParameterizedTest(name = "При нажатии на ссылку {0} осуществляется переход на страницу {1}")
    void significantSectionsOfMainPageTest(String name, String header){
        $$(".online-services").find(text(name)).click();
        $$(".posttitle").should(texts(header));

    }
}
