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
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Modificar_Parqueadero {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

//Escenario 1

    @Given("^Un usuario en la pagina de Administracion de Usuarios$")
    public void administracion() {
        actor.attemptsTo((Performable) new QuestionValidate("Pagina de inico").Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "Elemento")));
    }

    @When("^Selecciona el (.*)$")
    public void crearUsua() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clilc en el boton crear",
                "Clic en el boton",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario “Creación de Usuario”$")
    public void Formulario() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El boton de guardar bloqueado$")
    public void resultadoSeleccion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario debera visualizar el boton guardar bloqueado ",
                "boton guardar bloqueado",
                "Elemento")));
    }

}

