package main.Conjuntos.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class ColsultarUsuario {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }
    //Escenario 1

    @When("^Selecciona el boton de consulta de Usuario$")
    public void Bottonusu () {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona el boton de consulta",
                "hace clilc en consulta",
                "Elemento")));
    }

    @Then("El sistema presenta un formulario ya diligenciado “Consulta de Usuario” sin opción de edicion")
    public void opciondeedicion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta el formulario diligenciado son opcion de edicion",
                "visualiza formulario",
                "Elemento")));
    }

    // escenario 2


    @Given("^Un usuario en la pagina de Consultar Usuario$")
    public void consultapaginadeusuario( ) {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "ingresa a la pagina de administracion de usuarios",
                "hace clic en el campo",
                "//input[@placeholder='Buscar']")));
    }

    @When("^Selecciona una de las (.*)para salir de formulario de Consultar Usuario$")
    public void formularioconsulta() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona el boton de consulta",
                "hace clilc en consulta",
                "Elemento")));
    }

    @Then("^El sistema envia al usuario a la (.*)$")
    public void paginadireccionada() {
        actor.attemptsTo(new EnterTextAction("Elemento").Execute(new GeneralParams(
                "El sistema presenta el formulario diligenciado son opcion de edicion",
                "visualiza formulario",
                "Elemento")));
    }
}

