#include <iostream>
using namespace std;


int main(){


    int num , conti, contj, I,J;



    while(true){
    cin>>num;
    int filas[num];
    int columnas[num];
    int mat[num][num];
    for(int i=0; i<num; i++){
        for(int j = 0; j<num; j++){
            cin>>mat[i][j];
            filas[i]+=mat[i][j];
            columnas[j]+=mat[i][j];
        }
    }

    conti=0;
    contj=0;
    for(int i=0;i<num;i++){
        if(filas[i]%2==1){
            conti++;
            I=i;
        }
        if(columnas[i]%2==1){
            contj++;
            J=i;
        }
        if(conti+contj>2) break;
        }
        if(conti+contj==0) cout<<"OK"<<endl;
        else if(conti==1 && contj==1) cout<<"Change bit ("<<I+1<<","<<J+1<<")"<<endl;
        else if(conti+contj>0) cout<<"Corrupt"<<endl;
    }
    return 0;
}
