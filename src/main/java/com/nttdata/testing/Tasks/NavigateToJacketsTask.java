package com.nttdata.testing.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToJacketsTask implements Task {

    private static final Target MENU_MEN = Target.the("Men menu")
            .locatedBy("//span[text()='Men']");

    private static final Target MENU_TOPS = Target.the("Tops submenu")
            .locatedBy("//a[@id='ui-id-17']//span[text()='Tops']");

    private static final Target MENU_JACKETS = Target.the("Jackets submenu")
            .locatedBy("//a[@id='ui-id-19' and span[text()='Jackets']]");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(MENU_MEN),
                WaitUntil.the(MENU_TOPS, isVisible()).forNoMoreThan(10).seconds(),
                MoveMouse.to(MENU_TOPS),
                WaitUntil.the(MENU_JACKETS, isVisible()).forNoMoreThan(10).seconds(),
                MoveMouse.to(MENU_JACKETS), // Esto asegura que esté visible
                Click.on(MENU_JACKETS)
        );
    }

    public static NavigateToJacketsTask navigate() {
        return instrumented(NavigateToJacketsTask.class);
    }
}
