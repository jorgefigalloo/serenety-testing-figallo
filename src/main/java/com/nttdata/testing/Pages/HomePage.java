package com.nttdata.testing.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com/")
public class HomePage extends PageObject {

    //  SIGN UP

    public static final Target BTN_SIGN_UP = Target.the("Boton para hacer el registro")
            .located(By.xpath("//a[text()='Create an Account']"));

    public static final Target BTN_SIGN_IN = Target.the("Boton para hacer el inicio se sesion")
            .located(By.xpath("//a[normalize-space(text())='Sign In']"));


//    public static final Target REGISTER_MODAL = Target.the("Modal de registro")
//            .located(By.id("signInModalLabel"));
//
//    public static final Target INP_USERNAME = Target.the("Nombre de usuario")
//            .located(By.id("sign-username"));
//
//    public static final Target INP_PASSWORD = Target.the("Contraseña")
//            .located(By.id("sign-password"));
//
//    public static final Target BTN_REGISTRAR = Target.the("Boton Registrar")
//            .located(By.xpath("//button[text()='Sign up']"));
//
//    //  LOG IN
//
//    public static final Target BTN_LOGIN = Target.the("Boton para iniciar sesion")
//            .located(By.id("login2"));
}
