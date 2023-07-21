package ru.almazovcentre.page.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationSystemComponent {
    public void selectSection(String name){
        $$("#nav a").find(text("О центре")).hover();
        $$(".sub-menu a").find(text(name)).click();
    }
}
