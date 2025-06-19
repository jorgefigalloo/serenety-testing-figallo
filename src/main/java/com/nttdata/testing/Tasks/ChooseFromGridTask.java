package com.nttdata.testing.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.core.annotations.findby.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseFromGridTask implements Task {

    private final String nombreProducto;

    public ChooseFromGridTask(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target producto = Target.the("Producto " + nombreProducto)
                .located(By.xpath("//a[contains(text(),'" + nombreProducto + "')]"));
        actor.attemptsTo(
                Click.on(producto)
        );
    }

    public static ChooseFromGridTask selectProduct(String nombreProducto) {
        return instrumented(ChooseFromGridTask.class, nombreProducto);
    }
}
