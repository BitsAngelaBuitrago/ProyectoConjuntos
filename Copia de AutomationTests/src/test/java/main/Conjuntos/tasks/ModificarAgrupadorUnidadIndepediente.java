package main.Conjuntos.tasks;


import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class ModificarAgrupadorUnidadIndepediente {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    //Escenario 1

    @Given("^Un usuario en la página de Unidades inmobiliarias$")
    public void modificarUnisades() {
        actor.should(new QuestionValidate(
                "El usuario se encuentra en la pagina de unidades inmobiliarias ").Execute(new GeneralParams(
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @When("^Selecciona el botón de Modificar $")
    public void inmobiliariasModificar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "el usuario da clilc en el boton de modificar",
                "botoncrear",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario “Modificar Agrupador$")
    public void agrupadorModificar() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));

    }

    @And("^El botón de guardar bloqueado$")
    public void visualizarboton() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clic en filtro",
                "Elemento")));

    }
}
