package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.MenClothesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

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
                MoveMouse.to(MenClothesPage.ITM_SHIRT),
                Click.on(MenClothesPage.ITM_SHIRT),
                Click.on(MenClothesPage.ITM_TALLA),
                Click.on(MenClothesPage.ITM_COLOR_PRENDA)
        );
    }

    public static Performable withData(String talla, String color) {
        return new ChooseProductTask(talla, color);
    }
}
