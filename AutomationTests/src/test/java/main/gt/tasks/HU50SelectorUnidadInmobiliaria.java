package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU50SelectorUnidadInmobiliaria {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://selfcarecvgt-stg-gt.tigocloud.net/")));

    }

    @And("^Inicia sesión con un usuario con una unidad$")
    public void iniciarSesionUnaUnidad() {
        actor.attemptsTo(new EnterTextAction("jbarbosam").Execute(new GeneralParams(
                "Usuario ingresa texto en el campo usuario",
                "Campo usuario",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(new EnterTextAction("TigoTest123#").Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));

    }
}
