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
public class CrearAgrupadorUnidadIndependiente {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }
//Escenario 1

    @Given("^Un usuario en la pagina de Unidades inmobiliarias$")
    public void unidadesin() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de unidades indepoendientes",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @When("^Sselecciona el botón de Crear$")
    public void sscrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Selecciona el botoncrearr",
                "botoncrear",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario “Crear Agrupador”$")
    public void Agrupador() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));

    }

    @And("^El boton de guardar bloqueadoo$")
    public void Botonbloquea() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clic en filtro",
                "Elemento")));
    }

//Escenario 2


    @Given("^Un usuario en la pagina de Crear Agrupador$")
    public void crearagru() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @When("^Selecciona una de las (.*) para salir de formulario de crear agrupador$")
    public void ssalirformulario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "hace clic en una de las opciones del formulario",
                "Opciones formulario",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) junto con los botones Si y no$")
    public void SioNo() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));

    }

    @And("^La (.*) cerrar mensaje$")
    public void OpcionC() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en la opcion cerrar mensaje",
                "hace clic en cerrar",
                "Elemento")));

    }

////ESCENARIO 3


    @Given("^Un usuario en la pagina de Crear agrupadores$")
    public void paginaagru() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @And("^Sellecciona una de las (.*) para salir del formulario$")
    public void Salirformula() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Sellecciona una de las (.*) para cerrar el mensaje$")
    public void cerrarmensajee() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "hace clic en una de las opciones del formulario",
                "Opciones formulario",
                "Elemento")));
    }

    @Then("^El sistema debe realizar un <acciones> dependiendo de la opción seleccionada$")
    public void deberealizaracciones() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));


    }
////ESCENARIO 4


    @Given("^Un usuario en la pagina de Crearr Agrupador$")
    public void paginaagr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Da clicc en el <campo_requerido>$")
    public void MensajeOpciones() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "hace clic en una de las opciones del formulario",
                "Opciones formulario",
                "Elemento")));
    }

    @And("^da clic por fuera del campo$")
    public void fueradelcampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @Then("^El siistema presenta un (.*) indicando que el campo es requerido$")
    public void RealizarAcciones() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }

    @And("^El sistema debera indicar a nivel visual que el campo es obligatorio$")
    public void SelleccionaAgru() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }

////ESCENARIO 5

    @Given("^Un usuario en la pagina de Crear Agrupadorr$")
    public void seencuentraenlapagi() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Realizar una (.*) sobre los campos$")
    public void aaccioncampos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "hace clic en una de las opciones del formulario",
                "Opciones formulario",
                "Elemento")));
    }

    @Then("^sistema presenta sí o no (.*) el boton de guardar$")
    public void habilitado() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }

////ESCENARIO 6

    @Given("^Un usuario en la pagina de Crearr Agrupadorr$")
    public void seencuent() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupacion",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Ingresa un (.*) de (.*) con unas (.*) definidas para el (.*)$")
    public void ingresapalabrascl() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El uaurio ingresa un tipo de valor",
                "Ingresa valor",
                "Elemento")));
    }

    @Then("^Ell sistema realiza si o no unas (.*)$")
    public void habilitadosno() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }
////ESCENARIO 7

    @Given("^Un usuario en la página de Crear Agrupador$")
    public void AgrupadorC() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupacion",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @And("^el usuario Da clic en el campo Nombre Agrupador$")
    public void NombreCampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @When("^Ingressa un (.*) de (.*) con unas (.*) definidas para el (.*)$")
    public void Ingresapalabrass() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El uaurio ingresa un tipo de valor",
                "Ingresa valor",
                "Elemento")));
    }

    @Then("^El sistema realiza unas (.*)$")
    public void Validacionescm() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }

/// Escenario 8

    @Given("^Un usuario en la página de Crear Agrupadores$")
    public void agrupp() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupacion",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Realiza una (.*) sobre un (.*)$")
    public void seleccionarna() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El uaurio ingresa un tipo de valor",
                "Ingresa valor",
                "Elemento")));
    }

    @Then("^El sistema presenta si o no (.*) el botón de guardar$")
    public void Cliii() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }
/// Escenario 9


    @Given("^Un usuario en la página de Crear Agrrupador$")
    public void Unagrrupador() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupacion",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @And("^Ingresa la información en cada uno de los campos requeridos de forma correcta$")
    public void CamposRequeridoss() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));

    }

    @When("^Da cliic en el botón Guardar$")
    public void Guardoo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El uaurio ingresa un tipo de valor",
                "Ingresa valor",
                "Elemento")));
    }

    @Then("^El siistema realiza unas (.*) en los (.*) enviados$")
    public void realizacamposEnviadooo() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }

/// Escenario 10

    @Given("^Se envía un (.*) para un (.*) de (.*)$")
    public void TipoVal() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupacion",
                "pagina de administracion de usuarios",
                "elemento")));
    }

    @When("^Se envía la petición al servicio web$")
    public void Wenpeticion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El uaurio ingresa un tipo de valor",
                "Ingresa valor",
                "Elemento")));
    }

    @Then("^El sistema realiza uunas (.*) en los campos enviados$")
    public void Validacelemento() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presente un mensaje de confirmacion",
                "visualiza mensaje de confirmacion",
                "Elemento")));
    }

    @And("^El sistema presenta un <resultado>$")
    public void PresentaRes() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "elemento")));
    }



 ///Escenario 11

     @Given("^Se enviía un (.*) para un (.*) de (.*)$")
        public void Envia() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El usuario ingresa a la pagina de crear agrupacion",
                    "pagina de administracion de usuarios",
                    "elemento")));
        }

     @When("^See envía la petición al servicio web$")
        public void Webservices() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El uaurio ingresa un tipo de valor",
                    "Ingresa valor",
                    "Elemento")));
        }

     @Then("^El siistema realiza unas (.*) en los campos enviiados$")
        public void EnviadosSistema() {
            actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                    "El sistema presente un mensaje de confirmacion",
                    "visualiza mensaje de confirmacion",
                    "Elemento")));
        }

     @And("^El siistema presenta un (.*)$")
        public void Siistema() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El usuario ingresa a la pagina de crear agrupadores",
                    "pagina de administracion de usuarios",
                    "Elemento")));

        }


///Escenario 12

     @Given("^Un usuario en la págiina de Crear Agrupador$")
            public void pagiinaccreara() {
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario ingresa a la pagina de crear agrupacion",
                        "pagina de administracion de usuarios",
                        "elemento")));
            }

     @And("^Ingresa la información en cada uno de los campos requeriidos de forma correcta$")
            public void CamposForma() {
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario ingresa a la pagina de crear agrupadores",
                        "pagina de administracion de usuarios",
                        "elemento")));

            }

     @When("^Da clic en ell botón Guardar$")
           public void EllGuardar() {
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El uaurio ingresa un tipo de valor",
                        "Ingresa valor",
                        "Elemento")));
            }
     @Then("^El sistema intenta guardar la información$")
            public void InforSave() {
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "El sistema presente un mensaje de confirmacion",
                        "visualiza mensaje de confirmacion",
                        "Elemento")));
            }
     @And("^Se presenta un error de (.*)$")
            public void TipoError() {
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario ingresa a la pagina de crear agrupadores",
                        "pagina de administracion de usuarios",
                        "elemento")));
            }

     @And("^El sistema presenta un (.*)$")
            public void pantallapresent() {
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "El usuario ingresa a la pagina de crear agrupadores",
                        "pagina de administracion de usuarios",
                        "elemento")));

            }
      @And("^El sistema no debe borrar a información de los campos del formulario$")
                public void BorraInformacioncampos() {
          actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                  "El usuario ingresa a la pagina de crear agrupadores",
                  "pagina de administracion de usuarios",
                  "elemento")));

      }


      ///Escenario 13

          @Given("^Un usuario en la página de Unidades inmobiliarias$")
          public void unidadinmobiliaria() {
              actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                      "El usuario ingresa a la pagina de crear agrupacion",
                      "pagina de administracion de usuarios",
                      "elemento")));
          }

         @And("^Seleccionaa el botón de Crearr$")
         public void Bbotoncrear() {
             actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                     "El usuario ingresa a la pagina de crear agrupadores",
                     "pagina de administracion de usuarios",
                     "elemento")));
         }

          @And("^Ingresa lla información en cada uno de los campos requeridos de forma correcta$")
          public void Cadaunodeloscamposrequeridos() {
              actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                      "El usuario ingresa a la pagina de crear agrupadores",
                      "pagina de administracion de usuarios",
                      "elemento")));
          }

          @When("^Da cliic en el botón Guardarr$")
          public void GuardarCClic() {
              actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                      "El uaurio ingresa un tipo de valor",
                      "Ingresa valor",
                      "Elemento")));
          }

          @Then("^El sistema iintenta guardar la información$")
          public void IIntentaguardarlainfo() {
              actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                      "El sistema presente un mensaje de confirmacion",
                      "visualiza mensaje de confirmacion",
                      "Elemento")));
          }

          @And("^Se prresenta un error de tiipo 400$")
          public void Tipo400() {
              actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                      "El usuario ingresa a la pagina de crear agrupadores",
                      "pagina de administracion de usuarios",
                      "Elemento")));
          }

          @And("^El sistema redirecciona a una página en la cual se debe información el error$")
          public void DebeInformacionError() {
              actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear agrupadores",
                "pagina de administracion de usuarios",
                "Elemento")));

         }
}