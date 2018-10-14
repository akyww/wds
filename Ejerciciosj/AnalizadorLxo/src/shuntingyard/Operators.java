/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuntingyard;

/**
 *
 * @author joel
 */
public enum Operators {
    SUMA("+",1),
    RESTA("-",1),
    MULTIPLICACION("*",2),
    DIVISION("/",2),
    MODULO("%",2);
    
    private String simbol;
    private int value;
    
    private Operators(String simbol, int value)
    {
        this.simbol = simbol;
        this.value = value;
    }
    
    public String getSimbol()
    {
        return simbol;
    }
    
    public int getValue()
    {
        return value;
    }
    
}
