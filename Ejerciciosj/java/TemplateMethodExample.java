import java.util.*;
import java.util.Scanner;
import java.io.*;

interface IFuenteDatos
{
    void abrir();
    void cerrar();
    boolean vacia();
    String leer();
}

interface ISalidaDatos
{
    void abrir();
    void cerrar();
    void escribir(String tmp);    
}

//Interfaz Funcional
interface IProcesarRegistro
{
    String procesar( String registro );
}

//////////////////////////////////////////////////////////////////////////

class FuenteDatosConsola implements IFuenteDatos
{
    private Scanner scanner;
    
    private String tmp;
    
    public void abrir()
    {
        scanner = new Scanner( System.in );
    }
    
    public void cerrar()
    {
        
    }
    
    public boolean vacia()
    {
        try 
        {
            tmp = scanner.nextLine();
        } 
        catch(Exception e)
        {
            //System.out.println(e.getMessage());    
            tmp = null;
        } 
        finally 
        {
            
        }
        return tmp == null;
    }
    
    public String leer()
    {
        return tmp;
    }
}

class SalidaDatosConsola implements ISalidaDatos
{
    public void abrir()
    {
        
    }
    
    public void cerrar()
    {
        
    }
    
    public void escribir(String tmp)
    {
        System.out.println(tmp);
    }
}

class Procesador
{
    private IFuenteDatos fuente;
    private ISalidaDatos salida;
    
    public Procesador(IFuenteDatos fuente,ISalidaDatos salida)
    {
        this.fuente = fuente;
        this.salida = salida;
    }
    
    /*Funcion plantilla */
    public void procesar( IProcesarRegistro lambda )
    {
        fuente.abrir();
        salida.abrir();
        while( !fuente.vacia() )
        {
            String registro = fuente.leer();
            String registroProcesado = lambda.procesar(registro);
            salida.escribir(registroProcesado);
        }
        fuente.cerrar();
        salida.cerrar();
    }
    
}


class Codechef
{
	public static void main (String[] args)
	{
		IFuenteDatos fuente = new FuenteDatosConsola();
		ISalidaDatos salida = new SalidaDatosConsola();
		Procesador procesador = new Procesador( fuente, salida );
		procesador.procesar( registro ->  registro.toLowerCase()  );
	}
}