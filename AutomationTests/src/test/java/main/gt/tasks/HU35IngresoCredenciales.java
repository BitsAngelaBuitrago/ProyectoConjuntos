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
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU35IngresoCredenciales {
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

    @When("^Ingresa información de usuario de (.*)$")
    public void ingresarUsuario(String usuario){
        actor.attemptsTo(new EnterTextAction(usuario).Execute(new GeneralParams(
                "Usuario ingresa texto en un campo usuario",
                "Campo usuario",
                "//input[@id='idUsuario']"
        )));
    }
    @And("^Ingresa la información de contrasena (.*)$")
    public void ingresarContrasena(String contrasena) {
        actor.attemptsTo(new EnterTextAction(contrasena).Execute(new GeneralParams(
                "Usuario ingresa texto en un campo contrasena",
                "Campo contrasena",
                "//input[@id='idContrasena']"
        )));
    }
    @Then("El sistema (.*) presenta habilitado el botón de ingresar")
    public void botonHabilitado() {

        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }
    @And("^Da clic sobre el botón Ingresar$")
    public void ingresar(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Ingresar",
                "Boton Ingresar",
                "//button[@name='action']"
        )));
    }


    @Then("^El sistema presenta la página después del ingreso con la (.*)$")
    public void ingresoExitoso(){
        actor.should(new QuestionValidate("Página de inicio").Execute(
                new GeneralParams(
                        "Usuario valida que ingreso a la pagina principal",
                        "Pagina Principal",
                        "//p[contains(text(),'Inicio')] "
                )
        ));
    }
    @When("Ingresa 5 veces información de usuario y de contrasena errada")
    public void ingresoCredencialesErradas(){
        for(int i=0;i<5;i++) {
            actor.attemptsTo(new EnterTextAction("usuarioerrado").Execute(new GeneralParams(
                    "Usuario ingresa texto errado en campo usuario",
                    "Campo usuario",
                    "//input[@id='idUsuario']"
            )));
            actor.attemptsTo(new EnterTextAction("3434444").Execute(new GeneralParams(
                    "Usuario ingresa contrasena errada en el campo contrasena",
                    "Campo contrasena",
                    "//input[@id='idPassword']"
            )));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en Ingresar",
                    "Boton Ingresar",
                    "//button[@name='action']"
            )));
        }
    }
    @Then("El sistema presenta el mensaje de Usuario bloqueado")
    public void usuarioBloqueado() {
        actor.should(new QuestionValidate("Usuario Bloqueado").Execute(
                new GeneralParams(
                        "Después de 5 intentos se bloquea el usuario",
                        "Usuario Bloqueado",
                        "//p[contains(text(),'Usuario Bloqueado')] "
                )
        ));
    }


}
