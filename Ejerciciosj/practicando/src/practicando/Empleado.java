/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicando;

/**
 *
 * @author joel
 */
public class Empleado extends Persona{
   private int codigo;
   private float sueldo;
   private String cargo;
   public Empleado(String nombre, int edad, char sexo,int codigo, float sueldo, String cargo){
       super(nombre,edad, sexo);
       this.codigo = codigo;
       this.sueldo = sueldo;
       this.cargo = cargo;
   }
   
   public int getCodigo(){
       return codigo;
   }
   public float getSueldo(){
       return sueldo;
   }
   public String getCargo(){
       return cargo;
   }
   
}

