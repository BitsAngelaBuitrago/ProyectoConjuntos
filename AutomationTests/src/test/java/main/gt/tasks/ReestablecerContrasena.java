package main.gt.tasks;

import core.actions.OpenUrlAction;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ReestablecerContrasena {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Given("^Un usuario en la página de reestablecer contrasena$")
    public void ingresarAPaginaReestablecer() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://selfcarecvgt-stg-gt.tigocloud.net/")));
    }
    @When("^Da clic en el campo requerido (.*)$")
    public void campoRequerido(String Campo){
        if (Campo.equals( "Nueva contrasena")) {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en el campo",
                "Campo nueva contrasena",
                "//button[@name='action']"
        )));}
        else if (Campo.equals("Confirmacion contrasena")){
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en el campo",
                    "Campo confirmar contrasena",
                    "//button[@name='action']"
            )));
        }

    }
    @And("^Da clic por fuera del campo$")
    public void clicFueraCampo(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic fuera del campo",
                "Fuera del Campo confirmar contrasena",
                "//button[@name='action']"
        )));
    }
    @Then("^El sistema presenta un mensaje indicando que el campo es requerido$")
    public void mensajeCampoRequerido(){
        actor.should(new QuestionValidate("Campo Requerido").Execute(new GeneralParams(
                "Pagina principal",
                "//p[contains(text(),'Campo Requerido')]")));
    }
    @When("^Ingresa la (.*) en el campo nueva contrasena$")
    public void ingresaNuevaContrasena(String nuevaContrasena){
        actor.attemptsTo(new EnterTextAction(nuevaContrasena).Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nueva contrasena",
                "Campo Nueva contrasena",
                "//input[@id='idContrasena']"
        )));
    }
    @Then("^El sistema informa que la nueva contraseña ingresada cumple con las reglas$")
    public void cumpleReglas(){
        actor.should(seeThat(the("//button[@name='action']"),isVisible()));
    }

    @When("^Ingresa la confirmación de la (.*)$")
    public void ingresaConfirmacionContrasena(String confirmacionContrasena){
        actor.attemptsTo(new EnterTextAction(confirmacionContrasena).Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Confirmacion contrasena",
                "Campo Confirmacion contrasena",
                "//input[@id='idContrasena']"
        )));
    }
    @Then("^El sistema informa que la confirmación de la contraseña ingresada cumple con las reglas$")
    public void cumpleReglasConfirmacion(){

        actor.should(seeThat(the("//button[@name='action']"),isVisible()));
    }
    @When("Coloca el cursor encima del icono de check o x")
    public void clicIcono(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en el icono",
                "clic en el icono",
                "//button[@name='action']"
        )));
    }
    @Then("^El sistema muestra el mensaje (.*)$")
    public void mensajeIcono(String mensaje){
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "Pagina principal",
                "//p[contains(text(),'Campo Requerido')]")));
    }
    @When("^Da clic en el botón reestablecer$")
    public void clicBotonReestablecer(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en reestablecer",
                "clic en reestablecer",
                "//button[@name='action']"
        )));
    }
    @And("^Da clic en el botón Ingresar$")
    public void clicBotonIngresar(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en ingresar",
                "clic en ingresar",
                "//button[@name='action']"
        )));
    }
}
