/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones.matematicas;

/**
 *
 * @author joel
 */
public class FuncionesMatematicas {

    public static final double pi=3.1416;
	public double distanciaEuclideana(float x1, float x2, float y1, float y2)
	{
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	public static double distanciaEuclideanaStatica(float x1, float x2, float y1, float y2)
	{
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
        
        
	public static double areaCirculo(double r)
	{
		return pi*(Math.pow(r,2));
	}
	
	public static double circunferencia(double r)
	{
		return 2*pi*r;
	}
	
	public static double suma(double a, double b)
	{
		return a+b;
	}
	
        public static double resta(double a, double b)
	{
		return a-b;
	}
        
        public static double multiplicacion(double a, double b)
	{
		return a*b;
	}
        
        public static double division(double a, double b)
        {
                return a/b;
        }
        
        public static double potencia(double a,double n)
        {
            return Math.pow(a,n);
        }
        
        public static double raizCuadrada(double a)
        {
            return Math.sqrt(a);
        }
        
        
        
	public static double areaTriangulo(double a,double b, double c)
	{
		double semiperimetro=(a+b+c)/2;
		return Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
	}
	
	public static double areaElipce(double a, double b)
	{
		return pi*a*b;
	}
	
	public static double sumatoria(double[] arreglo)
	{
		double suma=0;
		for(int i=0;i<arreglo.length;i++)
		{
			suma+=arreglo[i];
		}
		return suma;
	}
	
	public static double promedio(double[] arreglo)
	{
		double suma=0;
		
		for(int i=0;i<arreglo.length;i++)
		{
			suma+=arreglo[i];
		}
		return suma/arreglo.length;
	}
	
	public static double productoPunto(double[] a, double[] b)
	{
            double suma = 0;
            
                for(int i=0;i<a.length;i++)
                {
                    suma+= a[i] * b[i];
                }
		
		return suma;
	}
        
        public static double teoremaPitagoras(double cateto1, double cateto2){
            
            double hipotenusa = Math.sqrt(Math.pow(cateto1, 2)+(Math.pow(cateto2, 2)));            
            return hipotenusa;
        }
    
        public static double tangente(double angulo)
        {
            double tangente= Math.tan(angulo);
            return tangente;
        }
        
        public static double a_Radianes(double angulo)
        {
            return (angulo*pi)/180;
        }
}
