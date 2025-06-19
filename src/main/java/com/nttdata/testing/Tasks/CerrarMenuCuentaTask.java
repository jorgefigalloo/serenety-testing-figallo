package com.nttdata.testing.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class CerrarMenuCuentaTask implements Task {

    private static final Target BTN_MENU = Target.the("Botón del menú de cuenta")
            .locatedBy("//button[@data-action='customer-menu-toggle']");

    private static final Target MENU_OVERLAY = Target.the("Overlay del menú de cuenta")
            .locatedBy("//div[@data-block='customer.menu']");

    public static CerrarMenuCuentaTask cerrar() {
        return Tasks.instrumented(CerrarMenuCuentaTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU),
                WaitUntil.the(MENU_OVERLAY, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
