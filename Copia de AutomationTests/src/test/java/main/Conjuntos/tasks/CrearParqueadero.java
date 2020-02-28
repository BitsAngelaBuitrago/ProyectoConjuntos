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
import cucumber.api.java.en_scouse.An;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class CrearParqueadero {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador

    }
//Escenario 1

    @Given("^Un usuario en la página de Administrar Unidaad Independiente$")
    public void UnidadIndependientep() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina administar unidad independiente",
                "pagina de administrar unidad independiente",
                "Elemento")));
    }

    @When("^Seleccionaa el botón de Crear Parqueadero$")
    public void botonParqueadero() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clilc en el boton crear parqueadero",
                "boton crear parqueadero",
                "Elemento")));
    }

    @Then("^El sistema presentaa un formulario “Crear Parqueadero”$")
    public void PresentaformularioParqueadero() {
        actor.should(new QuestionValidate(
                "El sistema presenta un formulario crear parqueadero").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El botón de guardaar bloqueado$")
    public void EEElbotonBloqueado() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en el boton guardar",
                "Da clic en filtro",
                "Elemento")));
    }

///Escenario 2


    @Given("^Un usuario en la página de Crear Parqueadero$")
    public void CrearUsuarioParqueadero() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Selecciona una de las (.*) para salir de formulario de crear Parqueadero$")
    public void SalirdeFormularioParque() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema presentaa un (.*) junto con los botones Si y No$")
    public void ELsistemabotonesSiYNo() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^La opción cerrar mensajee$")
    public void CCerrarMensajee() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
    ///Escenario 3


    @And("^Selecciona una de las (.*) para salir del formulario$")
    public void SalirDelFormulario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona una de las opciones del formulario",
                "Selecciona opciones",
                "Elemento")));
    }

    @When("^Seleccionaa una de las (.*) para cerrar el mensaje$")
    public void CerrarMensaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa una de las opciones",
                "Ingresa opciones",
                "Elemento")));
    }

    @Then("^El sistemaa debe realizar unas (.*) dependiendo de la opcion seleccionada$")
    public void DebeRealizarAccio() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 4

    @When("^Da clicc en el (.*)$")
    public void DaClicCampoReque() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el campo requerido",
                "Clic en campo",
                "Elemento")));
    }

    @And("^Da clic por fuera del caampo$")
    public void ClicFueraDelCampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc por fuera del campo",
                "clic en campo",
                "Elemento")));
    }

    @Then("^El sistema presentaa un (.*) indicando que el campo es requerido$")
    public void CamposRequeridos() {
        actor.should(new QuestionValidate(
                "El sistema indica el campo requerido").Execute(new GeneralParams(
                "Campo requerido",
                "Elemento")));
    }

    @And("^El sistema debe indicar a nivel visual que el campo es obligatorioo$")
    public void CampoEsObligatorioo() {
        actor.should(new QuestionValidate(
                "El usuario selecciona una de las opciones del formulario").Execute(new GeneralParams(
                "Selecciona opciones",
                "Elemento")));
    }
       ///Escenario 5

    @When("^Realiza una (.*) sobre los campos$")
    public void Realizaunaaccion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario realiza una accion sobre un campo",
                "Clic en campo",
                "Elemento")));
    }

    @Then("^El sistemaa presenta sí o no (.*) el botón de guardar$")
    public void BotonGuardarrr() {
        actor.should(new QuestionValidate(
                "El sistema presenta el boton guardar habilitado").Execute(new GeneralParams(
                "presenta campo",
                "Elemento")));
    }

    ///Escenario 6

    @And("^Daa clic en el <campo>$")
    public void CamposE() {
        actor.should(new QuestionValidate(
                "El usuario da clic en el campo").Execute(new GeneralParams(
                "Da clic",
                "Elemento")));
    }
    @When("^Seleccionaa del <listado> una <opción>$")
    public void ListadoSelecciona() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario seleccionalistado",
                "OpcionListado",
                "Elemento")));
    }
    @Then("^El sistema realiza las <validaciones> y la <acción> consecuente.$")
    public void RealizaValidaciones() {
        actor.should(new QuestionValidate(
                "El sistema presenta el boton guardar habilitado").Execute(new GeneralParams(
                "presenta campo",
                "Elemento")));
    }

///Escenario 7

    @And("^Daa clic en el campo alfanumérico Número de Parqueadero$")
    public void Numerodeparqueaderos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en campo alfa numerico",
                "campo alfa numerico",
                "Elemento")));

    }

    @When("^Ingresaa un <valor> el sistema valida las <reglas> definidas para el Campo Número de Parqueadero$")
    public void NumerodeParqueadero() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa el valor en el campo",
                "valor campo",
                "Elemento")));
    }

    @Then("^El sistemaa realiza sí o no unas <acciones>$")
    public void ElsistemaRealizaAcciones() {
        actor.should(new QuestionValidate(
                "El sistema presenta acciones").Execute(new GeneralParams(
                "presenta acciones",
                "Elemento")));
    }

    ///Escenario 8

    @When("^Realizaa una <acción> sobre un <campo>$")
    public void REalizaAccioon() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa una accion sobre un campo",
                "valor campo",
                "Elemento")));
    }

    @Then("^El sistemaa presenta sí o no <habilitado> el botón de guardarr$")
    public void BotonSiYnoPresentaSistema() {
        actor.should(new QuestionValidate(
                "El sistema presenta botones si o no ").Execute(new GeneralParams(
                "presenta acciones",
                "Elemento")));
    }

    ///Escenario 9

    @And("^Ingresaa la información en cada uno de los campos requeridos de forma correcta$")
    public void Informacioncadaunadecampos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));
    }

    @When("^Daa clic en el botón Guardar$")
    public void DDaaClicc() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa el valor en el campo",
                "valor campo",
                "Elemento")));
    }

    @Then("^El sistema realiza unaas <validaciones> en los <campos> enviados$")
    public void ElsistemaRealizaValidaciones() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "presenta acciones",
                "Elemento")));
    }

///Escenario 10


    @When("^Se envía la petición al servicioo web$")
    public void ServicioWeb() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa el valor en el campo",
                "valor campo",
                "Elemento")));
    }

    @Then("^El sistemaa realiza unas <validaciones> en los campos enviados$")
    public void CamposEnviados() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "presenta acciones",
                "Elemento")));
    }

    @And("^El sistemaa presenta un <resultado>$")
    public void PresentaResulltado() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));
    }

///Escenario 11

    @And("^Seleccionaa el botón de Crear$")
    public void BbotoonCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));
    }

    @And("^Ingresaa la información en cada uno de los campos requeridos de forma correcta$")
    public void PpresentaCampos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));
    }

    @When("^Daa clic en el botón Guardar$")
    public void BotonGuardar() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa el valor en el campo",
                "valor campo",
                "Elemento")));
    }

    @Then("^El sistemaa intenta guardar la información$")
    public void GuardarInformacion() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "presenta acciones",
                "Elemento")));
    }

    @And("^Se presentaa un error de tipo 400$")
    public void Tipo400() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));
    }

    @And("^El sistema redireccionaa a una página en la cual se debe información el error$")
    public void InformacionDelError() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en los campos requeridos",
                "campo alfa numerico",
                "Elemento")));

    }

}
