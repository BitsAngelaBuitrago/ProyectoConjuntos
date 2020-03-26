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
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
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

public class CrearAgrupadorUnidadIndependiente {

    Actor actor;
    @Managed
    WebDriver navegador;

    //Escenario 1

    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://selfcarecvgt-stg-gt.tigocloud.net/")));
    }

    @When("^Inicia sesión con un usuario$")
    public void iniciaSesiónConUnUsuario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en iniciar sesion",
                "Clic en iniciar sesion",
                "Elemento")));

        actor.attemptsTo(new EnterTextAction("angela").Execute(new GeneralParams(
                "El usuario hace clic en el campo",
                "Hace clic",
                "Elemento")));

        actor.attemptsTo(new EnterTextAction("Contraseña").Execute(new GeneralParams(
                "El usuario ingresa contraseña en el campo",
                "Ingresa contraseña",
                "Elemento")));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "EL usuario da clic en aceptar",
                "Clic en aceptar",
                "Elemento")));
    }

    @Then("^El sistema presenta la ventana emergente de Selector$")
    public void elSistemaPresentaLaVentanaEmergenteDeSelector() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre la Unidad Inmobiliaria deseada$")
    public void daClicSobreLaUnidadInmobiliariaDeseada() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en la unidad inmobiliaria",
                "Hace clic en unidad inmobiliaria",
                "Elemento")));
    }

    //Escenario 1

    @Given("^Un usuario en la pagina de Unidades inmobiliarias$")
    public void unUsuarioEnLaPaginaDeUnidadesInmobiliarias() {
        actor.should(new QuestionValidate("UnidadInmobiliaria").Execute(new GeneralParams(
                "El sistema valida que se encuentre en la pagina de unidad independiente",
                "El sistema valida",
                "Elemento")));
    }

    @When("^Usuario da clic en el boton crear$")
    public void usuarioDaClicEnElBotonCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el boton crear",
                "Clic en crear",
                "Elemento")));
    }

    @Then("^El sistema presenta formulario Crear Agrupador$")
    public void elSistemaPresentaFormularioCrearAgrupador() {
        actor.should(seeThat(the("Elemento del formulario"), isVisible()));
    }

    @And("^el usuario voisualiza la ruta de navegacion$")
    public void elUsuarioVoisualizaLaRutaDeNavegacion() {
        actor.should(seeThat(the("URLpagina"), isVisible()));
    }

    @And("^campo nombre agrupador$")
    public void campoNombreAgrupador() {
        actor.should(seeThat(the("Nombre de agrupador "), isVisible()));
    }

    @And("^campo numero de unidades independientes$")
    public void campoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the("Numero de unidades independientes"), isVisible()));
    }

    @And("^boton de guardar bloqueado$")
    public void botonDeGuardarBloqueado() {
        actor.should(seeThat(the("Boton crear"), isNotVisible()));
    }

    //Escenario 2

    @Given("^Un usuario en la pagina de Crear Agrupador$")
    public void unUsuarioEnLaPaginaDeCrearAgrupador() {
        actor.should(new QuestionValidate("Crear agrupador").Execute(new GeneralParams(
                "El sistema validar que se encuentre en la pagina de crear agrupador",
                "El sistema valida que sencuentre en la pagina crear agrupador",
                "Elemento")));
    }

    @When("^Selecciona una (.*) para salir de formulario$")
    public void seleccionaUnaOpcionParaSalirDeFormularioDeCrearAgrupador(String Opcion) {
        switch (Opcion) {
            case "Parqueaderos":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en la opcion parqueadero",
                        "Clic en crear parqueadero",
                        "Elemento")));
                break;
            case "Unidades independientes":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en la opcion unidades independientes",
                        "Clic en la opcion unidades inpedendientes ",
                        "Elemento")));
                break;
            case "Cerrar sesion":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en la opcion cerrar sesion",
                        "Clic en la opcion cerrar sesion",
                        "Elemento")));

                break;
        }
    }

    @Then("^El sistema presenta pop up de confirmacion de salida$")
    public void elSistemaPresentaPopUpDeConfirmacionDeSalida() {
        actor.should(seeThat(the("Elemento"), isVisible()));
    }

    @And("^El sistema presenta mensaje junto con los botones Si y no$")
    public void elSistemaPresentaMensajeJuntoConLosBotonesSiYNo() {
        actor.should(new QuestionValidate("Desea salir de la pagina").Execute(new GeneralParams(
                "El sistema deberia validar que se presente un mensaje de confirmacion",
                "El sistema presenta mensaje",
                "Elemento")));
        actor.should(seeThat(the("Si"), isVisible()));
        actor.should(seeThat(the("No"), isVisible()));
    }

    @And("^opcion cerrar mensaje$")
    public void opcionCerrarMensaje() {
        actor.should(seeThat(the("cerrar mensaje"), isVisible()));
    }


    @When("^Selecciona una (.*) para cerrar el mensaje$")
    public void seleccionaUnaOpciones_mensajeParaCerrarElMensaje(String Opciones_mensaje) {
        switch (Opciones_mensaje) {
            case "Si":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clilc en la opcion si",
                        "Hace clic en si",
                        "Elemento")));
                break;
            case "No":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clilc en la opcion no",
                        "Hace clic en no",
                        "Elemento")));
                break;
            case "Icono x":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en el icono x",
                        "Hace clic en icono x",
                        "Elemento")));

                break;
        }

    }

    @Then("^El sistema debe realiza (.*) dependiendo de la opción seleccionada$")
    public void elSistemaDebeRealizaAccionesDependiendoDeLaOpciónSeleccionada(String acciones) {
        switch (acciones) {
            case "Pagina de parqueaderos":
                actor.should(new QuestionValidate("PAgina de parqueaderos").Execute(new GeneralParams(
                        "El sistema debera direccionar al usuario a la pagina de parqueaderos",
                        "redirecciona pagina de inicio",
                        "Elemento")));
                break;
            case "unidades inmobiliarias":
                actor.should(new QuestionValidate("Pagina de unidades inmobiliarias").Execute(new GeneralParams(
                        "El sistema debera direccionar al usuario a la pagina de unidades inmobiliarias",
                        "redirecciona pagina de unidades",
                        "Elemento")));
                break;
            case "unidades Iconoo de cerar sesion":
                actor.should(new QuestionValidate("Pagina de  unidades inmobiliarias").Execute(new GeneralParams(
                        "El sistema debera direccionar al usuario a la pagina de unidades inmobiliarias",
                        "redirecciona pagina de unidades",
                        "Elemento")));
                break;
        }
    }

    @When("^Da clic en (.*)$")
    public void daClicEnCampo_requerido(String campo) {
       switch (campo){
            case"Nombre agrupador":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en el campo agrupador",
                        "Da clic",
                        "Elemento")));
                break;
            case "numero de Unidades Independientes":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario da clic en el campo numero de unidades independientes",
                        "Da clic",
                        "Elemento")));
                break;

        }
    }
    @And("^da clic por fuera del campo$")
    public void daClicPorFueraDelCampo() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El usuario hace clic por fuera del campo",
                    "Hace clic por fuera del campo",
                    "Elemento")));
            }

    @Then("^El sistema presenta mensaje indicando que el campo es requerido$")
    public void elSistemaPresentaMensajeIndicandoQueElCampoEsRequerido() {
            actor.should(new QuestionValidate("Este campo es requerido").Execute(new GeneralParams(
                    "El sistema debera direccionar al usuario a la pagina de unidades inmobiliarias",
                    "redirecciona pagina de unidades",
                    "Elemento")));
        }


    @And("^El sistema debera indicar a nivel visual que el campo es obligatorio$")
    public void elSistemaDeberaIndicarANivelVisualQueElCampoEsObligatorio() {
        actor.should(seeThat(the("El campo es requerido"), isVisible()));
    }

    //Escenario 5


    @When("^ingresa al campo (.*) agrupacion$")
    public void ingresaAlCampoNombreAgrupación(String nombre) {
        actor.attemptsTo(new EnterTextAction(nombre).Execute(new GeneralParams(
                "El usuario ingresa el nombre de la agrupación",
                "Ingresa nombre de agrupación",
                "Elemento")));
        }

    @And("^ingresa al campo (.*) de unidades$")
    public void ingresaAlCampoNumeroDeUnidades(String numero) {
        actor.attemptsTo(new EnterTextAction(numero).Execute(new GeneralParams(
                "El usuario ingresa el numero de unidad independiente",
                "Ingresa numero de unidad independiente",
                "Elemento")));

    }

    @Then("^sistema presenta (.*) el boton de guardar$")
    public void sistemaPresentaHabilitadoElBotonDeGuardar() {
        actor.should(seeThat(the("Habilitado boton"), isVisible()));
    }


    @When("^Ingresa un (.*) para el campo numero de unidades independientes$")
    public void ingresaUnValorParaElCampoNumeroDeUnidadesIndependientes(String valor) {
        actor.attemptsTo(new EnterTextAction(valor).Execute(new GeneralParams(
                "El usuario ingresa un valor en numero de unidad independiente",
                "Ingresa un valor en numero de unidad independiente",
                "Elemento")));

    }

    @Then("^El sistema muestra el (.*)$")
    public void elSistemaMuestraElResultado(String resultado) {
    actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
            "El sistema debera validar el resultado ingresado en el campo",
            "valida el resultado",
            "Elemento")));

    }

    @And("^muestra un mensaje en caso de que el usuario ingrese letras en el campo$")
    public void muestraUnMensajeEnCasoDeQueElUsuarioIngreseLetrasEnElCampo() {
        actor.should(seeThat(the("En este campo solo puede ingresar numeros"), isVisible()));
    }

    @And("^el usuario Da clic en el campo Nombre Agrupador$")
    public void elUsuarioDaClicEnElCampoNombreAgrupador() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el campo agrupador",
                "Clic en el campo agrupador",
                "Elemento")));

    }

    @When("^Ingresa un (.*) para el campo nombre de agrupador$")
    public void ingresaUnValorParaElCampoNombreDeAgrupador(String valor) {
        actor.attemptsTo(new EnterTextAction(valor).Execute(new GeneralParams(
                "El usuario ingresa un valor en el campo",
                "ingresa un valor",
                "Elemento")));
    }

    @Then("^El sistema muestra (.*)$")
    public void elSistemaMuestraResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "El sistema debera mostar el resultado del campo",
                "Muestra resultado",
                "Elemento")));
    }

    @When("^ingresa al campo (.*) agrupacion$")
    public void ingresaAlCampoNombreAgrupacion(String nombre) {
        actor.attemptsTo(new EnterTextAction(nombre).Execute(new GeneralParams(
                "El usuario ingresa nombre del agrupador",
                "Ingresa nombre",
                "Elemento")));

    }

    @And("^Ingresa (.*) para el campo nombre de agrupador$")
    public void ingresaNumeroParaElCampoNombreDeAgrupador(String numero) {
        actor.attemptsTo(new EnterTextAction(numero).Execute(new GeneralParams(
                "El usuario ingresa nombre del agrupador",
                "Ingresa nombre",
                "Elemento")));
    }

    @And("^da clic en boton guardar$")
    public void daClicEnBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa numero de unidades independientes",
                "Ingresa numero de unidades independientes",
                "Elemento")));
    }

    @Then("^sistema presenta el mensaje$")
    public void sistemaPresentaElMensaje() {
            actor.should(new QuestionValidate("Error").Execute(new GeneralParams(
                    "El sistema debera validar el tipo de error que presenta el sistema ",
                    "presena el sistema",
                    "Elemento")));

 }

    @Then("^El sistema presenta un (.*)$")
    public void elSistemaPresentaUnTipo_de_error(String tiopodeerror) {
        actor.should(new QuestionValidate(tiopodeerror).Execute(new GeneralParams(
                "El sistema debera validar el tipo de error que presenta el sistema ",
                "presena el sistema",
                "Elemento")));
    }

    @And("^presenta un (.*)$")
    public void presentaUnMensaje(String tipodeerror) {
            actor.should(new QuestionValidate(tipodeerror).Execute(new GeneralParams(
                    "El sistema debera validar el tipo de error que presenta el sistema ",
                    "presena el sistema",
                    "Elemento")));

    }

    @And("^El sistema no debe borrar la información de los campos del formulario$")
    public void elSistemaNoDebeBorrarLaInformaciónDeLosCamposDelFormulario() {
        actor.should(new QuestionValidate("").Execute(new GeneralParams(
                "El sistema no debera borrar la informacion ingresada",
                "no borra informacion ingresada",
                "Elemento")));
    }
}