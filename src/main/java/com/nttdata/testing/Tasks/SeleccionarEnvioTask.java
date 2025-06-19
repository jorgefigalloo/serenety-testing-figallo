package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarEnvioTask implements Task {

    public static SeleccionarEnvioTask defaultOption() {
        return Tasks.instrumented(SeleccionarEnvioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera hasta que el método de envío esté visible (máx. 10 segundos)
                WaitUntil.the(CheckoutPage.SHIPPING_METHOD, isVisible()).forNoMoreThan(10).seconds(),

                Click.on(CheckoutPage.SHIPPING_METHOD),
                Click.on(CheckoutPage.BTN_NEXT_SHIPPING)
        );
    }
}
