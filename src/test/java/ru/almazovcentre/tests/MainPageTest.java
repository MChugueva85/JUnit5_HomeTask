package ru.almazovcentre.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.almazovcentre.page.MainPage;
import ru.almazovcentre.page.components.HeaderComponent;
import ru.almazovcentre.page.components.NavigationSystemComponent;
import ru.almazovcentre.page.components.PostHeaderComponent;

import java.util.List;
import java.util.stream.Stream;

public class MainPageTest extends TestBase {

    PostHeaderComponent postHeaderComponent = new PostHeaderComponent();
    NavigationSystemComponent navigationSystemComponent = new NavigationSystemComponent();
    HeaderComponent headerComponent = new HeaderComponent();
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

    static Stream<Arguments> headerButtonsDataProvider() {
        return
                Stream.of(
                        Arguments.of(Locale.EN, List.of("Home", "About", "Science", "Education", "Clinic", "For patients", "News", "Partners")),
                        Arguments.of(Locale.RU, List.of("Главная", "О Центре", "Наука", "Образование", "Клиника", "Для пациента", "Новости", "Партнеры"))
                );
    }
    @MethodSource("headerButtonsDataProvider")
    @DisplayName("При изменении языка должны поменяться названия заголовков")
    @ParameterizedTest
    void LocaleTest(Locale locale, List<String> expectedButtons) {

        navigationSystemComponent.setLocale(locale);
        navigationSystemComponent.checkLanguage(expectedButtons);
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
        navigationSystemComponent.selectSection(name);
        postHeaderComponent.checkHeaderOfPage(name);
    }
    @CsvFileSource(resources = "/almazovCentreTest.csv")
    @DisplayName("Проверка ссылок в основном разделе главной страницы")
    @ParameterizedTest(name = "При нажатии на ссылку {0} осуществляется переход на страницу {1}")
    void significantSectionsOfMainPageTest(String name, String header){
        mainPage.selectPage(name);
        headerComponent.checkPageHeader(header);
    }
}
