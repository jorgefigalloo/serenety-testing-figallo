package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable; // Aunque no se usa aquí, es una buena práctica mantenerlo si se usa en otros matchers.


public class CompletarFormularioCompraTask implements Task {

    private final String company;
    private final String direccion;
    private final String ciudad;
    private final String estado;
    private final String zip;
    private final String pais;
    private final String telefono;

    public CompletarFormularioCompraTask(String company, String direccion, String ciudad, String estado, String zip, String pais, String telefono) {
        this.company = company;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.zip = zip;
        this.pais = pais;
        this.telefono = telefono;
    }

    public static CompletarFormularioCompraTask conDatos(String company, String direccion, String ciudad, String estado, String zip, String pais, String telefono) {
        return instrumented(CompletarFormularioCompraTask.class, company, direccion, ciudad, estado, zip, pais, telefono);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Esperar que cualquier spinner inicial desaparezca antes de decidir si clicar 'New Address'
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds()
        );

        // Lógica condicional para "New Address"
        if (WebElementQuestion.the(CheckoutPage.BTN_NEW_ADDRESS).answeredBy(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(CheckoutPage.BTN_NEW_ADDRESS),
                    // Después de clicar 'New Address', esperar a que el spinner desaparezca nuevamente si aparece
                    WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds()
            );
        }

        // Esperar por un campo del formulario (ej. COMPANY) para asegurar que el formulario está listo para ser llenado.
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.COMPANY, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(company).into(CheckoutPage.COMPANY),
                Enter.theValue(direccion).into(CheckoutPage.STREET),
                Enter.theValue(ciudad).into(CheckoutPage.CITY),
                SelectFromOptions.byVisibleText(pais).from(CheckoutPage.COUNTRY)
        );

        // Manejo más robusto del campo de REGION/ESTADO
        if (WebElementQuestion.the(CheckoutPage.REGION_SELECT).answeredBy(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.REGION_SELECT, isEnabled()).forNoMoreThan(10).seconds(),
                    SelectFromOptions.byVisibleText(estado).from(CheckoutPage.REGION_SELECT)
            );
        }
        else if (WebElementQuestion.the(CheckoutPage.REGION_INPUT).answeredBy(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.REGION_INPUT, isEnabled()).forNoMoreThan(10).seconds(),
                    Enter.theValue(estado).into(CheckoutPage.REGION_INPUT)
            );
        }

        actor.attemptsTo(
                Enter.theValue(zip).into(CheckoutPage.POSTCODE),
                Enter.theValue(telefono).into(CheckoutPage.TELEPHONE)
        );

        // Manejo condicional de SAVE_IN_ADDRESS_BOOK_CHECKBOX
        if (WebElementQuestion.the(CheckoutPage.SAVE_IN_ADDRESS_BOOK_CHECKBOX).answeredBy(actor).isVisible() &&
                WebElementQuestion.the(CheckoutPage.SAVE_IN_ADDRESS_BOOK_CHECKBOX).answeredBy(actor).isSelected()) {
            actor.attemptsTo(
                    Click.on(CheckoutPage.SAVE_IN_ADDRESS_BOOK_CHECKBOX)
            );
        }

        // Esperar que el botón 'Ship Here' esté habilitado antes de hacer clic
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.BTN_SHIP_HERE, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BTN_SHIP_HERE),
                // Esperar que el spinner desaparezca después de clicar 'Ship Here'
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds()
        );

        // Realizar un refresco de página para forzar la carga de los datos del método de envío
        // y luego avanzar directamente al botón "Next".
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.MoveMouse.to(CheckoutPage.SHIPPING_STEP_CONTAINER) // Opcional, puede ayudar a activar la sección
        );
        BrowseTheWeb.as(actor).getDriver().navigate().refresh(); // Realiza el refresco de la página

        // Después del refresco, es CRUCIAL volver a esperar a que la página se estabilice
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(CheckoutPage.SHIPPING_STEP_CONTAINER, isVisible()).forNoMoreThan(20).seconds()
        );

        // Después del refresco, esperamos a que el botón "Next" esté habilitado y lo clicamos.
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.BTN_NEXT_SHIPPING, isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(CheckoutPage.BTN_NEXT_SHIPPING),

                // Esperar que el spinner desaparezca después de clicar "Next" para pasar a la sección de pagos
                WaitUntil.the(CheckoutPage.LOADING_SPINNER, isNotVisible()).forNoMoreThan(30).seconds()
        );

        // *** FIN DE LA TAREA CompletarFormularioCompraTask ***
        // Las acciones de "Place Order" y "confirmación" se mueven a ConfirmarCompraTask.
    }
}