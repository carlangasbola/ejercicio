/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.beans;

import org.neuroph.core.NeuralNetwork;

/**
 *
 * @author César
 */
public class ConexionNeurona {
        
        //Cargar red neuronal
        NeuralNetwork neuralNetwork = NeuralNetwork.createFromFile("C:\\semaforo.nnet");
        public int ent1;
        public int ent2;
        public int ent3;
        public double[] networkOutput;
        
        public void variables(int e1,int e2,int e3){
            
            ent1=e1;
            ent2=e2;
            ent3=e3;
            
        }
        public void RedNeuronal(){
            //Entradas de la red neuronal
            neuralNetwork.setInput(ent1,ent2,ent3);    
        
            //Calcular semaforo
            neuralNetwork.calculate();
        
            //Salida del semaforo
            networkOutput = neuralNetwork.getOutput();
        
            System.out.println("Salida Importante: "+networkOutput[0]);
        }
}

