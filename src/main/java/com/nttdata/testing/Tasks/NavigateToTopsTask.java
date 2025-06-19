package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.NavbarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


public class NavigateToTopsTask implements Task {
    public static NavigateToTopsTask navigate() {
        return Tasks.instrumented(NavigateToTopsTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(NavbarPage.TOPS));
    }
}