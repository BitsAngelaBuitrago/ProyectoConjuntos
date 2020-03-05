package main.Conjuntos.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class ModificarUsuario {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }
//Escenario 1

    @Given("^Un usuario en la pagina de Administración de Usuarios$")
    public void AdministracioModificar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^hace clic en boton de Modificar de Usuario$")
    public void fica() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en modificar usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario Modificación de Usuario$")
    public void PresentaFormularioDeModificacion() {
        actor.attemptsTo(new EnterTextAction("Elemento").Execute(new GeneralParams(
                "El sistema presenta formulario para modificar usuario",
                "visualiza formulario",
                "Elemento")));
    }
    @And("^El boton de guardar bloqueado en modificar$")
    public void arioDeModificacion() {
        actor.attemptsTo(new EnterTextAction("Elemento").Execute(new GeneralParams(
                "El sistema presenta formulario para modificar usuario",
                "visualiza formulario",
                "Elemento")));
    }
}


