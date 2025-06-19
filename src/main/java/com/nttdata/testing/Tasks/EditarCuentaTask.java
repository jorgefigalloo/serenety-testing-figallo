package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.AccountEditPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarCuentaTask implements Task {

    private final String nuevoNombre;
    private final String nuevoApellido;

    public EditarCuentaTask(String nuevoNombre, String nuevoApellido) {
        this.nuevoNombre = nuevoNombre;
        this.nuevoApellido = nuevoApellido;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Clic en botón "Change"
                Click.on(AccountEditPage.BTN_CHANGE),

                // 2. Espera a que el enlace 'My Account' esté visible
                WaitUntil.the(AccountEditPage.LINK_MY_ACCOUNT, isVisible()).forNoMoreThan(10).seconds(),

                // 3. Clic en "My Account"
                Click.on(AccountEditPage.LINK_MY_ACCOUNT),

                // 4. Cierra el menú si queda abierto
                CerrarMenuCuentaTask.cerrar(),

                // 5. Espera y clic en Editar
                WaitUntil.the(AccountEditPage.BTN_EDIT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AccountEditPage.BTN_EDIT),

                // 6. Edita los campos
                Clear.field(AccountEditPage.INPUT_FIRSTNAME),
                Enter.theValue(nuevoNombre).into(AccountEditPage.INPUT_FIRSTNAME),
                Clear.field(AccountEditPage.INPUT_LASTNAME),
                Enter.theValue(nuevoApellido).into(AccountEditPage.INPUT_LASTNAME),

                // 7. Guarda cambios
                Click.on(AccountEditPage.BTN_SAVE)
        );
    }

    public static Performable conDatos(String nombre, String apellido) {
        return new EditarCuentaTask(nombre, apellido);
    }
}
