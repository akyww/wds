/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones.matematicas;

import java.util.Arrays;

/**
 *
 * @author joel
 */
public class FuncionesMatematicasMain {
    public static void main(String[] args)
    {
       
        double radioDelCirculo = 15;    
        
        double a = 39;
        double b =90;
        double p = 3;
        
        System.out.println("La suma entre "+a+" y "+b+" es : "+ FuncionesMatematicas.suma(a,b));
              
        System.out.println("La resta entre "+a+" y "+b+" es : "+ FuncionesMatematicas.resta(a,b));
        System.out.println("La multiplicacion entre "+a+" y "+b+" es : "+ FuncionesMatematicas.multiplicacion(a,b));
                
        System.out.println("La division entre "+a+" y "+b+" es : "+ FuncionesMatematicas.division(a,b));
                
        System.out.println("La potencia de "+a+" elevado a "+p+" es : "+ FuncionesMatematicas.potencia(a,p)); 
        
        System.out.println("La raiz cuadara de  "+a+" es : "+ FuncionesMatematicas.raizCuadrada(a));
        
        System.out.println(FuncionesMatematicas.areaTriangulo(10, 10, 10));
     	
	System.out.println(FuncionesMatematicas.distanciaEuclideanaStatica(5, 6,7,8));
        
	System.out.println("El area de un circulo con un radio de "+radioDelCirculo+ "cm es : " + 
                FuncionesMatematicas.areaCirculo(radioDelCirculo)+ "cm2");
        
        System.out.println("La circunferencia de un circulo con un radio de " +radioDelCirculo+
                "es :"+FuncionesMatematicas.circunferencia(12)+"cm");
        
		
	
	double[] arr={2,3,4,5,6};
	System.out.println("La sumatoria de "+(Arrays.toString(arr))+"es "+FuncionesMatematicas.sumatoria(arr));
	System.out.println("El promedio de "+(Arrays.toString(arr))+"es "+FuncionesMatematicas.sumatoria(arr));
		
        double[] a1={7,-4,-1};
        double[] b2={3,-5,2};
	System.out.println("El producto punto entre los vectores: "+(Arrays.toString(a1))+" y "+
        (Arrays.toString(b2))+" es: "+FuncionesMatematicas.productoPunto(a1, b2));
        
        
        double cateto1 = 5;
        double cateto2 = 12;
        System.out.println("La hipotenusa para los catetos "+cateto1+" y " +cateto2+" es: "+
                FuncionesMatematicas.teoremaPitagoras(cateto1, cateto2));
        
        double angulo = 90;
        System.out.println("La tangente del angulo "+angulo+" es: "+
                FuncionesMatematicas.tangente(angulo));
        
        double gradoSexagecimal=220;
        System.out.println("El valor en radianes del angulo "+gradoSexagecimal+" es : "+
                FuncionesMatematicas.a_Radianes(gradoSexagecimal)+" rad");
		
    }
}
