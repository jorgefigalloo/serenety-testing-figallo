package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CartPage;
import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible; // Import this

public class IrAlCarritoYProcederTask implements Task {

    public static IrAlCarritoYProcederTask ir() {
        return Tasks.instrumented(IrAlCarritoYProcederTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(CartPage.ICON_CART),
                    WaitUntil.the(CartPage.DROPDOWN_CART, isVisible()).forNoMoreThan(40).seconds(),
                    WaitUntil.the(CartPage.BTN_PROCEED, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(CartPage.BTN_PROCEED, isClickable()).forNoMoreThan(40).seconds(),
                    Click.on(CartPage.BTN_PROCEED),

                    // ** ✅ MEJORA CLAVE: Esperar a que el spinner desaparezca primero al llegar al checkout. **
                    // Esto asegura que la página ha terminado de cargar su contenido dinámico
                    WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds(),

                    // ✅ Esperar al contenedor principal del paso de envío para confirmar que la página está lista.
                    // Esto es más genérico que esperar un botón específico como 'New Address'
                    // porque el botón 'New Address' podría no ser necesario si ya hay una dirección.
                    WaitUntil.the(CheckoutPage.SHIPPING_STEP_CONTAINER, isVisible()).forNoMoreThan(20).seconds()
            );
        } catch (Exception e) {
            throw new AssertionError("No se pudo interactuar con el carrito o el checkout inicial: " + e.getMessage(), e); // Añadir 'e' para la pila de llamadas
        }
    }
}