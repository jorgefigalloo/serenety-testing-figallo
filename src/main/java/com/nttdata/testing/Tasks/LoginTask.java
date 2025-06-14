package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Pages.LoginPage;
import com.nttdata.testing.Pages.MenClothesPage;
import com.nttdata.testing.questions.RegisterQuestion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                NavigateTo.theHomePage(),
                Click.on(HomePage.BTN_SIGN_IN),
                Enter.theValue(email).into(LoginPage.TXT_EMAIL),
                Enter.theValue(contrasenia).into(LoginPage.TXT_PASSWORD),
                Click.on(LoginPage.BTN_SIGN_IN)
        );

        actor.should(
                seeThat("El producto buscado", RegisterQuestion.visibleEn(MenClothesPage.ITM_SHIRT)));

        WaitUntil.the(MenClothesPage.ITM_SHIRT, isVisible()).forNoMoreThan(15).seconds();
    }

    public static Performable withData(String email, String contrasenia) {
        return new LoginTask(email, contrasenia);
    }
}
