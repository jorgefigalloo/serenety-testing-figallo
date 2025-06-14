package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.MenClothesPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchProductTask implements Task {

    private final String nombreProducto;

    public SearchProductTask(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Click.on(MenClothesPage.TXT_BUSCAR),
                Enter.theValue(nombreProducto).into(MenClothesPage.TXT_BUSCAR),
                Click.on(MenClothesPage.ICN_BUSCAR)
        );
    }

    public static Performable withData(String nombreProducto) {
        return new SearchProductTask(nombreProducto);
    }
}
