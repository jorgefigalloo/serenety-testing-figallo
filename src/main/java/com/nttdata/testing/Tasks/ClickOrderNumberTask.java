package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class ClickOrderNumberTask implements Task {

    public static ClickOrderNumberTask clickTheOrderNumber() {
        return Tasks.instrumented(ClickOrderNumberTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar a que el spinner desaparezca, por si la página de confirmación tiene uno
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds(),
                // Esperar a que el enlace del número de orden sea visible y clicable
                WaitUntil.the(CheckoutPage.ORDER_NUMBER_LINK, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.ORDER_NUMBER_LINK),
                // Opcional: Después de hacer clic, esperar a que el spinner desaparezca nuevamente,
                // ya que la nueva página (vista de la orden) podría tener su propio spinner de carga.
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds()
                // Si la nueva página tiene un elemento único (ej. título "Order #...", id="order-info-block"),
                // podrías añadir una espera WaitUntil.the(TARGET_EN_NUEVA_PAGINA, isVisible()).forNoMoreThan(X).seconds() aquí.
        );
    }
}