/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuntingyard;


import analizadorlx.Token;
import java.util.List;
import analizadorlx.TipoToken;

import java.util.Stack;
 
/**
 *
 * @author joel
 */
public class ShuntingYard {
    
    public ShuntingYard()
    {
    }
    
    public String shuntingYard(List<Token> array)
    {
        Stack<String> myStack = new Stack();
        StringBuilder result= new StringBuilder();
        int i=0;
        String temp2;
        while(i<array.size())
        {
            temp2 = array.get(i).obtenerLexema();

            if(array.get(i).obtenerTipoToken() == TipoToken.CONSTANTE_ENTERA)
            {
                result.append(temp2).append(' ');
            }
            if(array.get(i).obtenerTipoToken() == TipoToken.OPERADOR)
            {
                if(myStack.isEmpty())
                {
                    myStack.push(temp2);
                } else {
                    while( !myStack.isEmpty() &&  precedence(temp2) <= precedence(myStack.peek()) )
                    {
                        result.append(myStack.pop()).append(' ');
                    }
                    myStack.push(temp2);
                }
            }
            
            if(temp2.equals("("))
            {
                myStack.push(temp2);
            }
            
            if(temp2.equals(")"))
            {
                while(!myStack.peek().equals("("))
                {
                    result.append(myStack.pop()).append(' ');
                    if(myStack.isEmpty())
                    {
                        System.out.println("Hay parentesis derechos sin emparejar");
                    }
                }
                myStack.pop();
            }
            
            i++;
        }
        
        while(!myStack.isEmpty())
        {
            if(myStack.peek().equals("("))
            {
                System.out.println("Hay parentesis sin emparejar en la siguiente expresion");
                break;
            }
            result.append(myStack.pop()).append(' ');
            
        }
       
        return result.toString();
    }
    
    private int precedence(String a)
    {
        int value=0;
        Operators[] op = Operators.values();
        
        for(Operators index:op)
        {
            if(index.getSimbol().equals(a))
            {
                value = index.getValue();
            }
        }
        return value;
    }
    
}
