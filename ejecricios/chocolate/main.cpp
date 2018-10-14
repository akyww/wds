#include <iostream>
using namespace std;

int main(){

    int filas, columnas,c;
  //  cin>>filas>>columnas;

    while(true){

        cin>>filas>>columnas;
        int sumf=0;
        int matriz [filas][columnas];
        for(int i = 0; i<filas;i++){
            for(int j = 0;j<columnas;j++){
                matriz[i][j] = 1;
                sumf += matriz[i][j];

            }
        }
        cout<<sumf-1;

    }
    return 0;
}
