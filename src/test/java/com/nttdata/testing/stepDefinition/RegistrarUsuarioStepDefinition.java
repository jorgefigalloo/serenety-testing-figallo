package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.AccountPage;
import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Pages.RegisterPage;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.Tasks.RegistrarUsuario;
import com.nttdata.testing.questions.RegisterQuestion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegistrarUsuarioStepDefinition {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("ingresa nombre {string} apellido {string} email {string} y contrasenia {string}")
    public void ingresaNombreApellidoEmailYContrasenia(String nombre, String apellido, String email, String contrasenia) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.withData(nombre, apellido, email, contrasenia));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(RegisterPage.BTN_CREATE));
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("exitoso");
        try {
            //Assert.assertEquals();
            //theActorInTheSpotlight().should(seeThat(AccountPage.LBL_MY_ACCOUNT, isVisible()));
            theActorInTheSpotlight().should(seeThat("El mensaje de registro correcto", RegisterQuestion.visibleEn(AccountPage.LBL_MY_ACCOUNT), equalTo("My Account")));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("no se realiza el registro de manera exitosa")
    public void noSeRealizaElRegistroDeManeraExitosa() {
        theActorInTheSpotlight().should(seeThat("Error al crear usuario existente", RegisterQuestion.visibleEn(RegisterPage.LBL_ERROR_MESSAGE)));
    }
}
