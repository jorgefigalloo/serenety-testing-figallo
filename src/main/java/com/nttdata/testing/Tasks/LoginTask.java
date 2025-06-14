package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginTask implements Task {

    private final String email;
    private final String contrasenia;

    public LoginTask(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPage.TXT_EMAIL),
                Enter.theValue(contrasenia).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_SIGN_IN)
        );
    }

    public static Performable withData(String email, String contrasenia) {
        return new LoginTask(email, contrasenia);
    }
}
