package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU38CrearRolYPermisos {
    Actor actor;

    @And("^Da clic en Configuracion$")
    public void daClicEnConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en el menú de configuración",
                "menú configuración",
                "/button[@name='action']"
        )));
    }

    @And("^Da clic en Roles$")
    public void daClicEnRoles() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Roles",
                "clic en Roles",
                "/button[@name='action']"
        )));
    }

    @And("^Da clic en el boton Crear Rol$")
    public void daClicEnElBotonCrearRol() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Crear Rol",
                "clic en Crear Rol",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta una ventana con la informacion de crear rol$")
    public void elSistemaPresentaUnaVentanaConLaInformacionDeCrearRol() {
        // Etiqueta Crear Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Campo Nombre Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Sección Permisos
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Guardar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Cancelar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
    }

    @When("^Ingresa información en el campo nombre de rol$")
    public void ingresaInformacionEnElCampoNombreDeRol() {
        actor.attemptsTo(new EnterTextAction("Admin2").Execute(new GeneralParams(
                "Ingresa información en campo nombre de rol",
                "Campo nombre de rol",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta habilitado el boton de guardar$")
    public void elSistemaPresentaHabilitadoElBotonDeGuardar() {
        actor.should(seeThat(the("/button[@name='action']"),isEnabled()));
    }

    @When("^Ingresa un (.*) en el campo nombre de rol$")
    public void ingresaUnNombreEnElCampoNombreDeRol(String nombre) {
        actor.attemptsTo(new EnterTextAction(nombre).Execute(new GeneralParams(
                "Ingresa información en campo nombre de rol",
                "Campo nombre de rol",
                "/button[@name='action']"
        )));
    }

    @Then("^Se muestra el resultado esperado (.*)$")
    public void seMuestraElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado Nombre rol",
                "Campo Nombre rol",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^El sistema presente el mensaje <mensaje>$")
    public void elSistemaPresenteElMensajeMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "Mensaje de resultado de creación",
                "Mensaje",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Se da clic en Configuracion$")
    public void seDaClicEnConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Configuración",
                "Clic configuración",
                "//input[@id='idEmail']"
        )));
    }

    @And("^Se da clic en Unidades Inmobiliarias$")
    public void seDaClicEnUnidadesInmobiliarias() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Unidades Inmobiliarias",
                "Clic Unidades Inmobiliarias",
                "//input[@id='idEmail']"
        )));
    }

    @And("^Se da clic en Crear$")
    public void seDaClicEnCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Crear",
                "Clic crear",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se visualizan seleccionados cada check$")
    public void seVisualizanSeleccionadosCadaCheck() {
        //Check en Configuración
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Crear
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @Then("^Se visualizan todos los hijos y acciones seleccionados$")
    public void seVisualizanTodosLosHijosYAccionesSeleccionados() {
        //Check en Configuración
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Crear
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en COnsultar
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Modificar
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));

    }

    @Given("^Ingresa el nombre en el campo nombre de rol$")
    public void ingresaElNombreEnElCampoNombreDeRol() {
        actor.attemptsTo(new EnterTextAction("nombreRol").Execute(new GeneralParams(
                "Ingresa información en campo nombre de rol",
                "Campo nombre de rol",
                "/button[@name='action']"
        )));
    }

    @And("^Que se encuentra seleccionado configuracion$")
    public void queSeEncuentraSeleccionadoConfiguracion() {
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @Then("^Se visualizan todos los hijos desmarcados$")
    public void seVisualizanTodosLosHijosDesmarcados() {
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
        //Check en Crear
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
        //Check en COnsultar
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
        //Check en Modificar
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
    }

    @When("^se desmarcan los hijos$")
    public void seDesmarcanLosHijos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se mantiene seleccionado configuracion$")
    public void seMantieneSeleccionadoConfiguracion() {
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @And("^se encuentran marcados los hijos$")
    public void seEncuentranMarcadosLosHijos() {
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));

        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @When("^se desmarcan todas las acciones$")
    public void seDesmarcanTodasLasAcciones() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
    }


    @When("^se desmarca la accion de Editar$")
    public void seDesmarcaLaAccionDeEditar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^se mantienen seleccionados las demas acciones$")
    public void seMantienenSeleccionadosLasDemasAcciones() {
        //Check en Consultar
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en crear
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @And("^Que se encuentra desmarcada configuracion$")
    public void queSeEncuentraDesmarcadaConfiguracion() {
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
    }

    @When("^se selecciona la accion de Editar$")
    public void seSeleccionaLaAccionDeEditar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en HIjo",
                "Clic Hijo",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^se muestra seleccionado el padre y el hijo$")
    public void seMuestraSeleccionadoElPadreYElHijo() {
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));

        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }

    @And("^Se selecciona configuracion$")
    public void seSeleccionaConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en padre",
                "Clic padre",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Se da clic en guardar$")
    public void seDaClicEnGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en guardar",
                "Clic guardar",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se muestra el mensaje de creacion$")
    public void seMuestraElMensajeDeCreacion() {
        actor.should(new QuestionValidate("Creación del rol exitosa").Execute(new GeneralParams(
                "Mensaje creación de rol",
                "Creación rol",
                "//input[@id='idEmail']"
        )));
    }

    @And("^redirige al usuario a la página de Administrar Roles$")
    public void redirigeAlUsuarioALaPaginaDeAdministrarRoles() {
        actor.should(new QuestionValidate("Administración de Roles").Execute(new GeneralParams(
                "Página de Administración de Roles",
                "Administración de Roles",
                "//p[contains(text()] "
        )));
    }
}
