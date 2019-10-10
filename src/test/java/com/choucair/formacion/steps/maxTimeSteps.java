package com.choucair.formacion.steps;
import com.choucair.formacion.pageobjects.maxTimePage;
import net.thucydides.core.annotations.Step;

import java.awt.*;

public class maxTimeSteps {
    maxTimePage maxTimePage;

    @Step
    public void entrarMaxtime()  {
        maxTimePage.open();
    //    maxTimePage.login();
    }
    public void realizarReporte() throws AWTException {
    //    maxTimePage.seleccionardia();
    //    maxTimePage.realizarNuevoReporte();
        maxTimePage.seleccionarCategoria();
     //  maxTimePage.hacerClick();
     //  maxTimePage.otra();
    }
    public void ValidarCierreDia()  {

    }


}
