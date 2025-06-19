package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Tasks.LoginTask;
import com.nttdata.testing.Tasks.EditarCuentaTask;
import com.nttdata.testing.Pages.AccountEditPage;

import io.cucumber.java.en.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class EditarCuentaStepDefinition {

    @Given("el usuario ha iniciado sesión con email {string} y contraseña {string}")
    public void elUsuarioHaIniciadoSesion(String email, String contrasenia) {
        theActorCalled("usuario").attemptsTo(
                LoginTask.withData(email, contrasenia)
        );
    }

    @When("edita su nombre a {string} y su apellido a {string}")
    public void editaSuNombreYApellido(String nuevoNombre, String nuevoApellido) {
        theActorInTheSpotlight().attemptsTo(
                EditarCuentaTask.conDatos(nuevoNombre, nuevoApellido)
        );
    }

    @Then("se muestra un mensaje de confirmación de edición")
    public void seMuestraMensajeConfirmacion() {
        theActorInTheSpotlight().should(
                seeThat("Mensaje de confirmación", WebElementQuestion.the(AccountEditPage.CONFIRMATION_MSG), isVisible())
        );
    }
}
