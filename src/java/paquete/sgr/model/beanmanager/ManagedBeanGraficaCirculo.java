/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.ManagedBeanGraficaCirculo
 */
package paquete.sgr.model.beanmanager;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.chartistjsf.model.chart.*;
import org.primefaces.event.ItemSelectEvent;

/**
 *
 * @author César
 */

@Named(value = "managedBeanGraficaCirculo")
@RequestScoped

public class ManagedBeanGraficaCirculo {
    
    private PieChartModel pieChartModel;
    
    public ManagedBeanGraficaCirculo() {
        createPieChart();
    }
    
    public void createPieChart() {
        pieChartModel = new PieChartModel();
        pieChartModel.addLabel("Area 1");
        pieChartModel.addLabel("Area 2");
        pieChartModel.addLabel("Area 3");
        pieChartModel.set(20);
        pieChartModel.set(25);
        pieChartModel.set(15);
        pieChartModel.setShowTooltip(true);
        pieChartModel.setDonut(true);
        pieChartModel.isAnimateAdvanced();
    }
    public void pieItemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "
                            + pieChartModel.getData().get(event.getItemIndex()));
        FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
    }
    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }
    public void setPieChartModel(PieChartModel pieChartModel) {
        this.pieChartModel = pieChartModel;
    }
}