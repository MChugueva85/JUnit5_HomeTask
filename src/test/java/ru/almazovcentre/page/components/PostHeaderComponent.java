package ru.almazovcentre.page.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class PostHeaderComponent {


    public void checkHeaderOfPage(String name){
        $$(".posttitle").should(texts(name));
    }

}
