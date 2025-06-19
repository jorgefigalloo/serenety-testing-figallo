package com.nttdata.testing.Pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AccountEditPage {

    public static final Target BTN_CHANGE = Target.the("Botón del menú de cuenta")
            .locatedBy("//button[@data-action='customer-menu-toggle']");

    public static final Target LINK_MY_ACCOUNT = Target.the("Enlace My Account")
            .locatedBy("//a[contains(text(), 'My Account')]");

    public static final Target BTN_EDIT = Target.the("Botón Edit")
            .locatedBy("//span[text()='Edit']");

    public static final Target INPUT_FIRSTNAME = Target.the("Campo First Name")
            .locatedBy("//input[@id='firstname']");

    public static final Target INPUT_LASTNAME = Target.the("Campo Last Name")
            .locatedBy("//input[@id='lastname']");

    public static final Target BTN_SAVE = Target.the("Botón Save")
            .locatedBy("//button[@title='Save']");

    public static final Target CONFIRMATION_MSG = Target.the("Mensaje de confirmación")
            .locatedBy("//div[contains(@data-bind, 'message') and contains(@class, 'message-success')]");
}
