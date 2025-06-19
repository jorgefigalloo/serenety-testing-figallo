package com.nttdata.testing.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target ICON_CART = Target.the("Icono del carrito")
            .located(By.cssSelector("a.showcart"));

    public static final Target DROPDOWN_CART = Target.the("Dropdown del carrito")
            .located(By.cssSelector("div.minicart-wrapper"));

    // 🔁 ACTUALIZADO: Usamos el botón correcto "Proceed to Checkout"
    public static final Target BTN_PROCEED = Target.the("Proceed to Checkout button")
            .located(By.id("top-cart-btn-checkout"));
}
