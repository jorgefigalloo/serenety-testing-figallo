package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.NavbarPage;
import com.nttdata.testing.Pages.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCartTask implements Task {
    public static AddToCartTask add() {
        return Tasks.instrumented(AddToCartTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductDetailPage.BUTTON_ADD_TO_CART),
                WaitUntil.the(NavbarPage.MSG_AGREGADO_CARRITO, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
