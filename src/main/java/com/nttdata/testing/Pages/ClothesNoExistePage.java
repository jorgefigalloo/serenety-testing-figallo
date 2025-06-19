package com.nttdata.testing.Pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class ClothesNoExistePage extends PageObject {

    public static final Target MSG_NO_RESULTADOS = Target.the("Mensaje de no resultados")
            .located(By.xpath("//div[contains(text(), 'Your search returned no results')]"));
}
