/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptar;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joel
 */
public class Encriptar {

    public String nombre;
    public String sitio;

    public Encriptar() {

    }

    public String encriptar() {
        String pass = "";
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String array = sc.nextLine();
        String arr = sc2.nextLine();
        Random rd = new Random();

        char caracter;
        for (int i = 0; i < 2; i++) {
            caracter = array.charAt(rd.nextInt(array.length()));
            if (caracter != ' ') {
                pass += caracter;
            }
        }

        for (int j = 0; j < 2; j++) {
            caracter = arr.charAt(rd.nextInt(arr.length()));
            if (caracter != ' ') {
                pass += caracter;
            }
        }

        pass = vocal(pass);

        String num = String.valueOf(arr.length());
        pass += num;

        if (arr.length() % 2 == 0) {
            pass += '$';
        } else {
            pass += '@';
        }

        pass = format(pass);
        pass = addKey(pass);
        pass = upper(pass);

        return pass;
    }

    private String addKey(String tmp) {
        int key = (int) (Math.random() * 1000) + 100;
        String keys = String.valueOf(key);
        tmp += keys;

        return tmp;
    }

    private boolean bolVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String vocal(String pass) {
        int flag = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (!bolVocal(pass.charAt(i))) {
                flag = 1;
            }
        }

        if (flag == 1) {
            pass = addVocal(pass);
        }

        return pass;
    }

    private String upper(String tmp) {
        String replace = "";
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '$' || tmp.charAt(i) == '@') {
                char up = Character.toUpperCase(tmp.charAt(i + 1));
                replace = tmp.replace(tmp.charAt(i + 1), up);
            }
        }
        return replace;
    }
    
    private String addDot(String tmp)
    {
        Random rd = new Random();
        int index = rd.nextInt(tmp.length());
        char car = '.';
        StringBuilder str= new StringBuilder(tmp);
        
        str.insert(index, car);
        
        String res = str.toString();
        return res;
    }

    
    private String format(String tmp) {
        char n1 = tmp.charAt(0);
        char n2 = tmp.charAt(tmp.length() - 3);
        int s1 = (int) n1 + 1;
        char char1 = (char) s1;
        int s2 = (int) n2 + 1;
        char char2 = (char) s2;
        tmp += char1;
        tmp += char2;

        return tmp;
    }

    private String addVocal(String tmp) {
        Random rd = new Random();
        int index = rd.nextInt(tmp.length());
        char car = 'a';
        StringBuilder str = new StringBuilder(tmp);

        str.insert(index, car);

        String res = str.toString();
        return res;
    }

    public static void main(String[] args) {
        Encriptar ob = new Encriptar();

        System.out.print(ob.encriptar());
    }

}
