/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.beans;

import java.util.Random;

/**
 *
 * @author César
 */
public class Neurona {
    
        double peso1;
        double peso2;
        double peso3;
        double umbral;

    public void Procesoneurona(){
                
//Tabla de la verdad (X1,X2,Y1)
        int[][] tv = {{1,-1,-1,-1},{-1,1,-1,-1},{-1,-1,1,-1},{1,1,-1,1},{1,-1,1,-1},{1,1,1,1},{-1,1,1,1}};
        
        System.out.println("\nInicializar pesos:\n");
        double w1=new Random().nextDouble()/2.5; //Valores proximos a 0
        double w2 = new Random().nextDouble()/2.5;
        double w3 = new Random().nextDouble()/2.5;
        double θ = -0.4;
        
        double y=0;
        final double E=0.6;//Factor de aprendizaje
        
        System.out.println("w1: " + w1);
        System.out.println("w2: " + w2);
        System.out.println("w3: " + w3);
        System.out.println("θ: " + θ);
        
        System.out.println("\nIniciando fase de aprendizaje Matriz de compatibilidad...\n");
        int i=0;
        int cont=1;
        while (i<tv.length && cont <1000){
            y= Math.tanh((tv[i][0]*w1)+(tv[i][1]*w2)+(tv[i][2]*w3)+(-1*θ));
            y=(y>=0) ? 1 : -1;
            System.out.println("Entrada[" + tv[i][0] + "," + tv[i][1] + "," + tv[i][2] + "] Salida [" + (int) y + "]");
            if(y==tv[i][3]){
                i++;
            } else{
                System.out.println("Valor esperado difiere de la salida. Hay que reajustar pesos...");
                //Ajuste de pesos
                w1=w1+2*E*tv[i][3]*tv[i][0];
                w2=w2+2*E*tv[i][3]*tv[i][1];
                w2=w2+2*E*tv[i][3]*tv[i][2];
                θ=θ+2*E*tv[i][3]*(-1);
                
                System.out.println("\nAjuste de pesos(" +  cont + "):");
                System.out.println("w1: " + w1);
                System.out.println("w2: " + w2);
                System.out.println("w3: " + w3);
                System.out.println("θ: " + θ + "\n");
                cont++;
                i=0;
            }
        }
        
        if(cont <=100){
            System.out.println("\nFase de aprendizaje termiando con exito ");
            System.out.println("\nResultados:");
            System.out.println("w1: " + w1);
            System.out.println("w2: " + w2);
            System.out.println("w3: " + w3);
            System.out.println("θ: " +θ);
            System.out.println("\nIniciando la fase de testeo...");
            peso1=w1;
            peso2=w2;
            peso3=w3;
            umbral=θ;
        }
        else{
            System.out.println("\nFase de aprendizaje ha fallado");
        }
    }
    
    public double peso1(){
        return peso1;     
    }
    public double peso2(){
        return peso2;
    }
    public double peso3(){
        return peso3;
    }
    public double θ(){
        return umbral;
    }
}
