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

public class HU39ConsultarRolYPermisos {
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

    @And("^Inicia sesión$")
    public void iniciarSesion() {
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

    @When("^Da clic en Consultar el rol de Administrador$")
    public void daClicEnConsultarElRolDeAdministrador() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Consultar Rol",
                "clic en Consultar Rol",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta la informacion como consulta en los campos$")
    public void elSistemaPresentaLaInformacionComoConsultaEnLosCampos() {
        // Etiqueta Consultar Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        actor.should(new QuestionValidate(
                "Consultar Rol").Execute(new GeneralParams(
                "label consultar",
                "//p[contains(text(),'Campo Requerido')]")));
        //Campo Nombre Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        actor.should(new QuestionValidate(
                "Super admin").Execute(new GeneralParams(
                "Nombre rol",
                "//p[contains(text(),'Campo Requerido')]")));
        //Sección Permisos
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        actor.should(new QuestionValidate(
                "Configuración").Execute(new GeneralParams(
                "Permiso configuración",
                "//p[contains(text(),'Campo Requerido')]")));
        //Botón Guardar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Cancelar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
    }

    @And("^Da clic en el boton regresar$")
    public void daClicEnElBotonRegresar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Regresar",
                "clic en Regresar",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema debe presentar la página de Administrar roles$")
    public void elSistemaDebePresentarLaPaginaDeAdministrarRoles() {
        actor.should(new QuestionValidate("Administrar Roles").Execute(new GeneralParams(
                "Página Administrar Roles",
                "Administrar Roles",
                "//input[@id='idEmail']"
        )));
    }
}
