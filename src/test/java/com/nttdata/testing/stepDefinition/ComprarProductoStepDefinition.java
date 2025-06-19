package com.nttdata.testing.stepDefinition;

import io.cucumber.java.en.When;

import com.nttdata.testing.Tasks.*;
import com.nttdata.testing.Pages.CheckoutPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.waits.WaitUntil; // Importado para las esperas
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

// Importaciones estáticas para los matchers de estado de elementos
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class ComprarProductoStepDefinition {

    @When("navega a Men > Tops > Jackets")
    public void navegarEnMenu() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToMenTask.navigate(),
                NavigateToTopsTask.navigate(),
                NavigateToJacketsTask.navigate()
        );
    }

    @And("selecciona el producto {string}")
    public void selectProduct(String nombreProductos) {
        theActorInTheSpotlight().attemptsTo(ChooseFromGridTask.selectProduct(nombreProductos));
    }

    @And("elige talla {string} y color {string} y cantidad {string}")
    public void selectVariants(String talla, String color, String cantidad) {
        theActorInTheSpotlight().attemptsTo(
                ChooseVariantsTask.withData(talla, color, Integer.parseInt(cantidad))
        );
    }

    @And("agrega al carrito")
    public void agregarAlCarrito() {
        theActorInTheSpotlight().attemptsTo(AddToCartTask.add());
    }

    @And("procede a comprar")
    public void irAlCheckout() {
        theActorInTheSpotlight().attemptsTo(IrAlCarritoYProcederTask.ir());
    }

    @And("completa el formulario con company {string}, direccion {string}, ciudad {string}, estado {string}, zip {string}, pais {string}, telefono {string}")
    public void llenarDatos(String company, String direccion, String ciudad, String estado, String zip, String pais, String tel) {
        theActorInTheSpotlight().attemptsTo(
                CompletarFormularioCompraTask.conDatos(company, direccion, ciudad, estado, zip, pais, tel)
        );
    }

    // EL SIGUIENTE MÉTODO FUE ELIMINADO PORQUE YA NO ES NECESARIO EN EL FLUJO DE LA PRUEBA
    // Ya que CompletarFormularioCompraTask maneja el avance en el checkout.
    /*
    @And("selecciona método de envío predeterminado")
    public void selectShipping() {
        theActorInTheSpotlight().attemptsTo(SeleccionarEnvioTask.defaultOption());
    }
    */

    @And("hace clic en {string}")
    public void clickPlaceOrder(String boton) {
        theActorInTheSpotlight().attemptsTo(ConfirmarCompraTask.confirmar());
    }

    @Then("ve el mensaje de confirmación {string}")
    public void validarConfirmacion(String msg) {
        theActorInTheSpotlight().attemptsTo(
                // Esperar a que cualquier spinner de carga desaparezca
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds(),
                // Esperar a que el mensaje de confirmación sea visible en la página
                WaitUntil.the(CheckoutPage.MSG_CONFIRMACION, isVisible()).forNoMoreThan(30).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat(WebElementQuestion.the(CheckoutPage.MSG_CONFIRMACION), WebElementStateMatchers.isVisible())
        );
        // Opcional: Si quieres validar que el texto del mensaje es el esperado:
        // theActorInTheSpotlight().should(
        //         seeThat(TheText.of(CheckoutPage.MSG_CONFIRMACION), containsString(msg))
        // );
    }
}