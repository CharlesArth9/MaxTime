package com.choucair.formacion.definition;
import com.choucair.formacion.steps.maxTimeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class maxTimeDefinitions {
    @Steps
    maxTimeSteps maxTimeSteps;

    @Given("^ingreso a MaxTime$")
    public void ingreso_a_MaxTime() {
        maxTimeSteps.entrarMaxtime();
    }

    @When("^realizo el reporte del dia$")
    public void realizo_el_reporte_del_dia() throws AWTException {
        maxTimeSteps.realizarReporte();
    }

    @Then("^verifico el cierre del dia de manera correcta$")
    public void verifico_el_cierre_del_dia_de_manera_correcta() {
        maxTimeSteps.ValidarCierreDia();
    }

}
