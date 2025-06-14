package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.MenClothesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseProductTask implements Task {

    private final String talla;
    private final String color;

    public ChooseProductTask(String talla, String color) {
        this.talla = talla;
        this.color = color;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MenClothesPage.ITM_TALLA, isVisible()).forNoMoreThan(8).seconds(),
                Click.on(MenClothesPage.ITM_TALLA),
                WaitUntil.the(MenClothesPage.ITM_COLOR_PRENDA, isVisible()).forNoMoreThan(8).seconds(),
                Click.on(MenClothesPage.ITM_COLOR_PRENDA),
                Click.on(MenClothesPage.BTN_AGREGAR_CARRITO)
        );
    }

    public static Performable withData(String talla, String color) {
        return new ChooseProductTask(talla, color);
    }
}
