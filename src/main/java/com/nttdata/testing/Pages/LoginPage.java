package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target TXT_EMAIL = Target.the("Campo de texto email")
            .located(By.id("email"));

    public static final Target TXT_PASSWORD = Target.the("Campo de texto password")
            .located(By.id("pass"));

    public static final Target BTN_SIGN_IN = Target.the("Boton Iniciar Sesion")
            .located(By.xpath("//button[span[text()='Sign In']]"));
}
