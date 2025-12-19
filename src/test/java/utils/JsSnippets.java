package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {

    public static void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
