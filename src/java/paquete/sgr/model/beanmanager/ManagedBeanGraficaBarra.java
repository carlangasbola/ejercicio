/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

@Named(value = "managedBeanGraficaBarra")
@RequestScoped

public class ManagedBeanGraficaBarra {
    private BarChartModel barChartModel;
    
    public ManagedBeanGraficaBarra() {
        createBarModel();
    }
    
    public void createBarModel() {
        barChartModel = new BarChartModel();
        
        barChartModel.addLabel("Explosivos");
        barChartModel.addLabel("Gases, liquidos y solidos inflamables");
        barChartModel.addLabel("Gases a presion");
        barChartModel.addLabel("Sustancias comburentes");
        barChartModel.addLabel("Sustancias perjudiciales para la salud");
        barChartModel.addLabel("Sustancias corrosivas");
        barChartModel.addLabel("Sustancias nosivas");
        barChartModel.addLabel("Sustancias toxicas");
        barChartModel.addLabel("Sustancias peligrosas para el medio ambiente");
        barChartModel.setWidth("100%");
        barChartModel.setHeight("500px");
        
        BarChartSeries series1 = new BarChartSeries();
        series1.setName("First Series");
        series1.set(12);
        
        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setShowGrid(false);
        
        barChartModel.addSeries(series1);
        barChartModel.setShowTooltip(true);
        barChartModel.setSeriesBarDistance(15);
        barChartModel.setAnimateAdvanced(true);
        barChartModel.setShowTooltip(true);
    }
    
    public BarChartModel getBarChartModel() {
        return barChartModel;
    }
    
    public void setBarChartModel(BarChartModel barChartModel) {
        this.barChartModel = barChartModel;
    }
    
    public void barItemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "
                            + ((ChartSeries) barChartModel.getSeries().get(event.getSeriesIndex())).getData().get(
                            event.getItemIndex()) + ", Series name:"
                            + ((ChartSeries) barChartModel.getSeries().get(event.getSeriesIndex())).getName());
                            FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
    }
}