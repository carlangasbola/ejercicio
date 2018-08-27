/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author sonri
 */

/* Librerias para el Neuroph*/
import org.neuroph.core.NeuralNetwork;
import org.neuroph.*;

public class ConexionRedNeuronal {
    
    //Cargar Red Neuronal
    
    NeuralNetwork neuralNetwork = NeuralNetwork.createFromFile("C:\\Users\\sonri\\Documents\\NetBeansProjects\\salida3\\Neural Networks\\Semaforo.nnet");
    int[] networkInput;
    double[] networkOutput;
    
    public void variables(int e1, int e2, int e3){
        
        networkInput[0]=e1;
        networkInput[1]=e2;
        networkInput[2]=e3;
    }
    
    public void RedNeuronal(){
        
        //Entradas de la red neuronal
        neuralNetwork.setInput(networkInput[0],networkInput[1],networkInput[2]);
        
        //Calcular semaforo
        neuralNetwork.calculate();
        
        //Salida del semaforo
        networkOutput = neuralNetwork.getOutput();
       
    }
}
