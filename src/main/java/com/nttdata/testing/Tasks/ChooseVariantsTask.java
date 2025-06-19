package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.core.annotations.findby.By;

public class ChooseVariantsTask implements Task {

    private final String talla;
    private final String color;
    private final int cantidad;

    public ChooseVariantsTask(String talla, String color, int cantidad) {
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target tallaTarget = Target.the("Talla " + talla)
                .located(By.xpath("//div[@option-label='" + talla + "']"));
        Target colorTarget = Target.the("Color " + color)
                .located(By.xpath("//div[@option-label='" + color + "']"));

        actor.attemptsTo(
                Click.on(tallaTarget),
                Click.on(colorTarget),
                Clear.field(ProductDetailPage.INPUT_QUANTITY),
                Enter.theValue(String.valueOf(cantidad)).into(ProductDetailPage.INPUT_QUANTITY)
        );
    }

    public static ChooseVariantsTask withData(String talla, String color, int cantidad) {
        return instrumented(ChooseVariantsTask.class, talla, color, cantidad);
    }
}
