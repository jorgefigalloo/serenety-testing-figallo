package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.AccountPage;
import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Pages.MenClothesPage;
import com.nttdata.testing.Tasks.LoginTask;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.Tasks.SearchProductTask;
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

public class MenClothesStepDefinition {

    @Given("el {actor} inicia sesion con email {string} y contrasenia {string}")
    public void elUsuarioIniciaSesionConEmailYContrasenia(Actor actor, String email, String contrasenia) {
        actor.attemptsTo(NavigateTo.theHomePage());
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_IN));
        theActorInTheSpotlight().attemptsTo(LoginTask.withData(email, contrasenia));

        //theActorInTheSpotlight().should(seeThat("El mensaje de registro correcto", RegisterQuestion.visibleEn(AccountPage.LBL_MY_ACCOUNT), equalTo("My Account")));
    }


    @And("busca un producto {string}")
    public void buscaUnProducto(String nombreProducto) {
        theActorInTheSpotlight().attemptsTo(SearchProductTask.withData(nombreProducto));
        theActorInTheSpotlight().should(seeThat("El producto buscado", RegisterQuestion.visibleEn(MenClothesPage.ITM_SHIRT)));
    }

    @And("selecciona la talla {string} y color {string}")
    public void seleccionaLaTallaYColor(String talla, String string) {
        Click.on(MenClothesPage.ITM_SHIRT);
        Click.on(MenClothesPage.ITM_TALLA);
        Click.on(MenClothesPage.ITM_COLOR_PRENDA);
    }

    @When("agrega al carrito")
    public void agregaAlCarrito() {
        Click.on(MenClothesPage.BTN_AGREGAR_CARRITO);
    }

    @Then("se actualiza el item {int} del carrito de manera exitosa")
    public void seActualizaElItemDelCarritoDeManeraExitosa(Integer cantidad) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        theActorInTheSpotlight().should(seeThat("El mensaje de registro correcto", RegisterQuestion.visibleEn(MenClothesPage.ITM_CARRITO), equalTo(cantidad)));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
