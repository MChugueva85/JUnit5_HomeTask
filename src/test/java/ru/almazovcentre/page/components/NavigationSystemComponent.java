package ru.almazovcentre.page.components;

import ru.almazovcentre.tests.Locale;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationSystemComponent {
    public void selectSection(String name){
        $$("#nav a").find(text("О центре")).hover();
        $$(".sub-menu a").find(text(name)).click();
    }

    public void setLocale(Locale locale){
        $$("#qtranslateslug-2 option").
                find(value("http://www.almazovcentre.ru/?lang="
                        + locale.name())).click();
    }

    public void checkLanguage(List<String> expectedButtons){
        $$("#nav a").filter(visible).should(texts(expectedButtons));
    }
}
