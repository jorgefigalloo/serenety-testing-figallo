package com.nttdata.testing.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.nttdata.testing.Pages.ClothesNoExistePage.MSG_NO_RESULTADOS;
import static com.nttdata.testing.Tasks.LoginTask.withData;
import static com.nttdata.testing.Tasks.SearchProductTask.withData;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class ProductNoExisteStepDefinition {

    @Managed
    WebDriver driver;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        Actor usuario = Actor.named("Usuario");
        usuario.can(BrowseTheWeb.with(driver));
        OnStage.theActorCalled("Usuario"); // Asegura que el actor esté en el escenario
    }

    @Given("el usuario inicia sesión con email {string} y contraseña {string}")
    public void elUsuarioIniciaSesionConEmailYContrasenia(String email, String contrasenia) {
        Actor usuario = OnStage.theActorCalled("Usuario");
        usuario.attemptsTo(
                withData(email, contrasenia)
        );
    }

    @When("busca un producto inexistente {string}")
    public void buscaUnProductoInexistente(String nombreProducto) {
        Actor usuario = OnStage.theActorCalled("Usuario");
        usuario.attemptsTo(
                withData(nombreProducto)
        );
    }

    @Then("se muestra el mensaje de que no se encontraron resultados")
    public void seMuestraElMensajeDeQueNoSeEncontraronResultados() {
        Actor usuario = OnStage.theActorCalled("Usuario");
        usuario.attemptsTo(
                WaitUntil.the(MSG_NO_RESULTADOS, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}