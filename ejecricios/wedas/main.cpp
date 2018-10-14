#include <iostream>
using namespace std;

void primeraVocal(){
    string palabra;
    cin>>palabra;
    for(int i=0; i < palabra.size();i++){
            if(palabra[i] == 'a' || palabra[i] == 'e' || palabra[i] == 'o'||
               palabra[i] == 'i' || palabra[i] == 'u'){
            cout<<"La primera vocal es "<<palabra[i]<<endl;
            return;
            }
}
}

void listaNotas(){
    int n= 0;
    int nota1,nota2,nota3;
    while(n<100){
        cout<<"Ingrese notas: "<<endl;
        cin>>nota1>>nota2>>nota3;
        if(((nota1+nota2+nota3)/3) < 4){
            cout<<"Desaprobado"<<endl;
        }else{
            cout<<(nota1+nota2+nota3)/3<<endl;
        }
    n++;
    }
}

int main(){
   // primeraVocal();
    listaNotas();
    return 0;
}
