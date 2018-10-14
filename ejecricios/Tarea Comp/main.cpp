#define INICIO 0
#define S1 1
#define S2 2
#define S3 3
#define S4 4
#define identificador 5
#define ERROR 6


#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

using namespace std;


 void mostrarFichero() {
     ifstream fichero;
     string texto;

     fichero.open("entrada.txt");
     if(fichero.is_open()){
        while(!fichero.eof()){
            getline(fichero, texto);
            cout<<texto<<endl;
        }
     fichero.close();
     }
}


bool Espacio(char n){
    if(n == ' ') return true;
    else return false;
}


void Conversion(){
    ifstream fichero;
    fichero.open("entrada.txt");
    char n;
    char caracter;
    if(fichero.is_open()){
        fichero.get(caracter);
        while(!fichero.eof()){
            if(isupper(caracter)){
                n=tolower(caracter);
            }else if(islower(caracter)){
                n=toupper(caracter);

            }else if(Espacio(caracter)){
                n = ' ';
            }else if('\n'){
                n='\n';
            }

            fichero.get(caracter);

            cout<<n;
        }

     fichero.close();
     }
}

void conversionFichero(){
    ifstream entrada;
    ofstream salida;
    entrada.open("entrada.txt");
    salida.open("salida.txt",ios::out);
    char n;
    char caracter;
    if(entrada.is_open()){
        entrada.get(caracter);
        while(!entrada.eof()){
            if(isupper(caracter)){
                n=tolower(caracter);
            }else if(islower(caracter)){
                n=toupper(caracter);

            }else if(Espacio(caracter)){
                n = ' ';
            }else if('\n'){
                n='\n';
            }

            entrada.get(caracter);

            salida<<n;
        }

     entrada.close();
     salida.close();
     }
}

/*
void automata(){

	int estado = INICIO;
	string cadena;
	cout<<"Ingrese la cadena"<<endl;
	cin>>cadena;
	char *sim = strdup(cadena.c_str());
	for(int i=0;i<cadena.length();i++){
		switch(estado){
			case INICIO:
				if(sim[0] >='a' and sim[0] <='z'){
					estado = identificador;
                }
                break;
			case S2:
				if(sim [i]== '.'){
					estado = S3;
				}else{
					estado = ERROR;
				}
			break;

			case S3:
                if(sim [i]>='0' and sim [i]<='9'){
                    cout<<"Es un flotante"<<endl;
					estado = S4;
				}else{
					estado = ERROR;
				}
			break;

			case ERROR:
				cout<<"cadena no permitida"<<endl;
				i =cadena.length() + 100;

            case identificador:
                cout<<"Es un identificador"<<endl;
                break;
		}
	}
}

*/


int main(){
//    automata();
//    conversionFichero();
//    Conversion();
//    mostrarFichero();



    return 0;

}
