package main.Conjuntos.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Background {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Given("^Un usuario ingresa a la url de la aplicación$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "https://outlook.office.com/")));

        actor.attemptsTo(
                new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da click en ingresar con email",
                        "Boton Ingresar con email",
                        "//input[@id='i0116']"
        )));
        actor.attemptsTo(new EnterTextAction("angela.buitrago@bitsamericas.com").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo email",
                "Campo email",
                "//input[@id='i0116']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en continuar",
                "Boton continuar",
                "//input[@id='idSIButton9']"
        )));
        actor.attemptsTo(
                new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da click en ingresar contraseña",
                        "Boton Ingresar contraseña",
                        "//input[@id='i0118']"
        )));
        actor.attemptsTo(new EnterTextAction("luli101112*").Execute(new GeneralParams(
                "Usuario ingresa contraseña",
                "Campo email",
                "//input[@id='i0118']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en iniciar sesion",
                "Boton inisiar sesion",
                "//input[@id='idSIButton9']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en No",
                "Boton No",
                "//input[@id='idBtn_Back']"
        )));
    }
}
