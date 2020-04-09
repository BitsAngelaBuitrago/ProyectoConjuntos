package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class IngresoCredenciales {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^Ingresa información de usuario de (.*)$")
    public void ingresarUsuario(String usuario){
        actor.attemptsTo(
                Enter.keyValues(usuario).into("//input[@id='userName']")
        );
        //actor.attemptsTo(new EnterTextAction(usuario).Execute(new GeneralParams(
        //        "Usuario ingresa texto en el campo usuario",
         //       "Campo usuario",
         //       "//input[@id='userName']"
        //)));
    }
    @And("^Ingresa la información de contrasena (.*)$")
    public void ingresarContrasena(String contrasena) {

        actor.attemptsTo(
                Enter.keyValues(contrasena).into("//input[@id='password']")
        );
        //actor.attemptsTo(new EnterTextAction(contrasena).Execute(
         //       new GeneralParams(
          //              "Usuario ingresa texto en un campo clave",
          //             "Campo clave",
           //             "//input[@id='password']"
          //      )
        //));
    }
    @Then("El sistema (.*) presenta habilitado el botón de ingresar")
    public void botonHabilitado() {

        actor.should(seeThat(the("//a[contains(text(),'Ingresar')]"), isEnabled()));
    }
    @And("^Da clic sobre el botón Ingresar$")
    public void ingresar(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Ingresar",
                "Boton Ingresar",
                "//a[contains(text(),'Ingresar')]"
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


    @Then("^El sistema un mensaje de error (.*)$")
    public void elSistemaUnMensajeDeErrorMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(
                new GeneralParams(
                        "Error de autenticación",
                        "Mensaje de error de ingreso",
                        "//p[contains(text(),)] "
                )
        ));
    }

    @Then("^El sistema presenta la página Administracion de roles$")
    public void elSistemaPresentaLaPaginaAdministracionDeRoles() {
        actor.should(new QuestionValidate("Administración de Roles").Execute(
                new GeneralParams(
                        "Después de 5 intentos se bloquea el usuario",
                        "Usuario Bloqueado",
                        "//p[contains(text(),'Administración de Roles')]"
                )
        ));
    }
}
