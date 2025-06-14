package com.nttdata.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollToBottom implements Interaction {

    WebDriver webDriver;

    public static ScrollToBottom now(){
        return Tasks.instrumented(ScrollToBottom.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        webDriver = ThucydidesWebDriverSupport.getDriver();
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
