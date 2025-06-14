package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AccountPage extends PageObject {

    public static final Target LBL_MY_ACCOUNT = Target.the("Boton crear usuario")
            .located(By.xpath("//span[text()='My Account']"));


}
