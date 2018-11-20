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

@Named(value = "managedBeanGraficaLinea")
@RequestScoped

public class ManagedBeanGraficaLinea {

    private LineChartModel lineChartModel;
    
    public ManagedBeanGraficaLinea () {
        createLineModel();
    }
    
    public void createLineModel() {
        lineChartModel = new LineChartModel();
        lineChartModel.setAspectRatio(AspectRatio.GOLDEN_SECTION);
        lineChartModel.addLabel("1");
        lineChartModel.addLabel("2");
        lineChartModel.addLabel("3");
        lineChartModel.addLabel("4");
        lineChartModel.addLabel("5");
        lineChartModel.addLabel("6");
        lineChartModel.addLabel("7");
        lineChartModel.addLabel("8");
        LineChartSeries lineChartSeries1 = new LineChartSeries();
        lineChartSeries1.setName("Series 1");
        lineChartSeries1.set(12);
        lineChartSeries1.set(21);
        lineChartSeries1.set(7);
        lineChartSeries1.set(15);
        lineChartSeries1.set(12);
        lineChartSeries1.set(21);
        lineChartSeries1.set(7);
        lineChartSeries1.set(15);
        LineChartSeries lineChartSeries2 = new LineChartSeries();
        lineChartSeries2.setName("Series 2");
        lineChartSeries2.set(14);
        lineChartSeries2.set(2);
        lineChartSeries2.set(8);
        lineChartSeries2.set(9);
        lineChartSeries2.set(14);
        lineChartSeries2.set(2);
        lineChartSeries2.set(8);
        lineChartSeries2.set(9);
        Axis xAxis = lineChartModel.getAxis(AxisType.X);
        lineChartModel.addSeries(lineChartSeries1);
        lineChartModel.addSeries(lineChartSeries2);
        lineChartModel.setAnimateAdvanced(true);
        lineChartModel.setShowTooltip(true);
        lineChartModel.setShowArea(true);
    }
    public void itemSelect(ItemSelectEvent event) {
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected", "Item Value: "+ 
                        ((ChartSeries) lineChartModel.getSeries().get(event.getSeriesIndex())).getData().get(event.getItemIndex())
                        + ", Series name:" +
                        ((ChartSeries) lineChartModel.getSeries().get(event.getSeriesIndex())).getName());
                        FacesContext.getCurrentInstance().addMessage(event.getComponent().getClientId(), msg);
    }
    public LineChartModel getLineModel() {
        return lineChartModel;
    }
    public void setLineModel(LineChartModel lineModel) {
        this.lineChartModel = lineModel;
    }
}
