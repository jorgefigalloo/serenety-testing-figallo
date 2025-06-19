package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductGridPage {

    public static final Target ITEM_MONTANA_WIND_JACKET = Target.the("Producto Montana Wind Jacket")
            .located(By.xpath("//a[@href='https://magento.softwaretestingboard.com/montana-wind-jacket.html']"));

}
