package ru.almazovcentre.page.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SignificantSectionsComponent {
    public void selectPage(String name){
        $$(".online-services").find(text(name)).click();
    }
}
