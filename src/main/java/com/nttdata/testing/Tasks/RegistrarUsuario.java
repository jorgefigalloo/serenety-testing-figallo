package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.RegisterPage;
import com.nttdata.testing.interactions.ScrollToBottom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;


public class RegistrarUsuario implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String contrasenia;

    public RegistrarUsuario(String firstName, String lastName, String email, String contrasenia) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Click.on(HomePage.BTN_SIGN_UP),
                Enter.theValue(firstName).into(RegisterPage.TXT_FIRST_NAME),
                Enter.theValue(lastName).into(RegisterPage.TXT_LAST_NAME),
                Enter.theValue(email).into(RegisterPage.TXT_EMAIL),
                Enter.theValue(contrasenia).into(RegisterPage.TXT_PASSWORD),
                Enter.theValue(contrasenia).into(RegisterPage.TXT_PASSWORD_CONFIRMATION),
                ScrollToBottom.now()
                //Click.on(RegisterPage.BTN_CREATE)
        );
    }

    public static Performable withData(String firstName, String lastName, String email, String contrasenia) {
        return new RegistrarUsuario(firstName, lastName, email, contrasenia);
    }
}
