package com.nttdata.testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RegisterQuestion implements Question<String> {

    private final Target label;

    public RegisterQuestion(Target label) {
        this.label = label;
    }

    public static RegisterQuestion visibleEn(Target label){
        return new RegisterQuestion((label));
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(label).answeredBy(actor);
    }
}
