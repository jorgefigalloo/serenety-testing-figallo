package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailPage {

    public static final Target SIZE_M = Target.the("Talla M")
            .located(By.xpath("//div[@option-label='M']"));

    public static final Target COLOR_BLACK = Target.the("Color negro")
            .located(By.xpath("//div[@option-label='Black']"));

    public static final Target INPUT_QUANTITY = Target.the("Campo de cantidad")
            .located(By.id("qty"));

    public static final Target BUTTON_ADD_TO_CART = Target.the("Botón Agregar al carrito")
            .located(By.xpath("//button[@title='Add to Cart']"));

    public static final Target CART_ITEM_COUNT = Target.the("Número de productos en carrito")
            .located(By.xpath("//span[@class='counter-number']"));
}
