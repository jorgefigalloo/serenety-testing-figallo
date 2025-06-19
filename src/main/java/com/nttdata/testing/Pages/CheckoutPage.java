package com.nttdata.testing.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Botón para agregar nueva dirección
    public static final Target BTN_NEW_ADDRESS = Target.the("botón nueva dirección")
            .located(By.xpath("//span[contains(text(),'New Address')]/ancestor::button"));

    // Campos del formulario
    public static final Target COMPANY = Target.the("campo compañía")
            .located(By.name("company"));

    public static final Target STREET = Target.the("campo dirección")
            .located(By.name("street[0]"));

    public static final Target CITY = Target.the("campo ciudad")
            .located(By.name("city"));

    public static final Target COUNTRY = Target.the("selector país")
            .located(By.name("country_id"));

    public static final Target REGION_SELECT = Target.the("selector región (combo)")
            .located(By.name("region_id"));

    public static final Target REGION_INPUT = Target.the("campo región (texto)")
            .located(By.name("region"));

    public static final Target POSTCODE = Target.the("campo código postal")
            .located(By.name("postcode"));

    public static final Target TELEPHONE = Target.the("campo teléfono")
            .located(By.name("telephone"));

    public static final Target SAVE_IN_ADDRESS_BOOK_CHECKBOX = Target.the("checkbox guardar dirección")
            .located(By.id("shipping-save-in-address-book"));

    // Botón para continuar después de llenar dirección (Ship Here)
    public static final Target BTN_SHIP_HERE = Target.the("botón Ship Here")
            .located(By.xpath("//span[contains(text(),'Ship here')]/ancestor::button"));

    // Contenedor del paso de método de envío
    public static final Target SHIPPING_STEP_CONTAINER = Target.the("contenedor del paso de método de envío")
            .located(By.id("checkout-step-shipping_method")); // Asegúrate que este ID es correcto

    // Método de envío (radio button)
    public static final Target SHIPPING_METHOD = Target.the("opción método de envío")
            .located(By.id("s_method_flatrate_flatrate")); // Verifica este ID en el HTML real

    // Botón continuar después de elegir el envío
    public static final Target BTN_NEXT_SHIPPING = Target.the("botón continuar después de envío")
            .located(By.xpath("//button[@data-role='opc-continue']"));

    // Botón para realizar el pedido
    public static final Target BTN_PLACE_ORDER = Target.the("botón Place Order")
            .located(By.xpath("//button[@title='Place Order']"));

    // Mensaje de confirmación de compra
    public static final Target MSG_CONFIRMACION = Target.the("mensaje de confirmación de compra")
            .located(By.cssSelector(".checkout-success"));

    // Spinner de carga que aparece durante los cambios
    public static final Target LOADING_SPINNER = Target.the("ícono de carga")
            .located(By.cssSelector("div.loading-mask"));
}
