package com.nttdata.testing.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NavbarPage {

    public static final Target MEN = Target.the("Men option").locatedBy("//span[text()='Men']");
    public static final Target TOPS = Target.the("Tops option").locatedBy("//a[text()='Tops']");
    public static final Target JACKETS = Target.the("Jackets option").locatedBy("//a[text()='Jackets']");

    public static final Target MSG_AGREGADO_CARRITO = Target.the("Mensaje de producto agregado al carrito")
            .located(By.cssSelector("div.message-success.success.message"));
}
