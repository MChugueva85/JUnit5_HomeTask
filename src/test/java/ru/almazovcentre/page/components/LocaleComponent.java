package ru.almazovcentre.page.components;

import ru.almazovcentre.tests.Locale;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$$;

public class LocaleComponent {
    public void setLocale(Locale locale){
        $$("#qtranslateslug-2 option").
                find(value("http://www.almazovcentre.ru/?lang="
                        + locale.name())).click();
    }
}
