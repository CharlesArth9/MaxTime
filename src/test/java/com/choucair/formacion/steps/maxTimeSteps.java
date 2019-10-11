package com.choucair.formacion.steps;
import com.choucair.formacion.pageobjects.maxTimePage;
import net.thucydides.core.annotations.Step;

import java.awt.*;

public class maxTimeSteps {
    maxTimePage maxTimePage;

    @Step
    public void entrarMaxtime()  {
        maxTimePage.open();
    }
    public void realizarReporte() throws AWTException, InterruptedException {
      /* maxTimePage.login();
       maxTimePage.seleccionardia();
       maxTimePage.realizarNuevoReporte();*/
       maxTimePage.seleccionarCategoria();
    }
    public void ValidarCierreDia()  {

    }


}
