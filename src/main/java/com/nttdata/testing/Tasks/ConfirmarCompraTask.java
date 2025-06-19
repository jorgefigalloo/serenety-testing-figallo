package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil; // Importa WaitUntil

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable; // Importa isClickable
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible; // Importa isNotVisible

public class ConfirmarCompraTask implements Task {

    public static ConfirmarCompraTask confirmar() {
        return Tasks.instrumented(ConfirmarCompraTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar a que cualquier spinner de carga desaparezca antes de buscar el botón "Place Order"
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds(),
                // Esperar que el botón 'Place Order' sea clicable, con un tiempo de espera más generoso
                WaitUntil.the(CheckoutPage.BTN_PLACE_ORDER, isClickable()).forNoMoreThan(30).seconds(), // Aumentado a 30 segundos
                Click.on(CheckoutPage.BTN_PLACE_ORDER)
        );
    }
}