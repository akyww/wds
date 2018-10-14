#include <iostream>
#include <math.h>

using namespace std;

//                     A           B
int* sumMatrix(int*pmatrix1,int* pmatrix2,int size){
	int* resp= new int[size*size];
	int filas, columnas;
    for (int i=0;i<size;i++){
            for(int j=0; j)
    resp[i]=pmatrix1[i];
    cout << resp[i];
     }


    return resp;

}

/*
void showMatrix(){

for(int i=0;*pmatrix1[i]<9;i++){
    resp[i]=pmatrix1[i]+pmatrix2[i];
        cout<<resp[i]<<",";
}
}
*/

int main()
{
    int isize=3;
	int matrix2[]={-1,1,-1,0,1,1,2,3,4};
    cout<<"Calculating matrix addition (one row form):"<<endl;
//	int* resultado2=sumMatrix(matrix1,matrix2,isize);
//	showMatrix(resultado2,isize);
	int* sumMatrix(int*,int*,int);

}



//ME PIDE :: BUENO ESTO VA EN MAIN  PERO QUIERO HACERLO JUNTO
// QUE ME BOTE SUMA , RESTA ,MULTIPLICACION, Y LA TRASPUESTA
/*
int matrix1[]={1,2,3,5,1,4,5,6,8};
	int isize=3;
	int matrix2[]={-1,1,-1,0,1,1,2,3,4};
	int* resultado1=mulMatrix(matrix1,matrix2,isize);
	cout<<"The matrix are:"<<endl;
	cout<<"MATRIX 1:"<<endl;
	showMatrix(matrix1,3);
	cout<<"MATRIX 2:"<<endl;
	showMatrix(matrix2,3);
	cout<<"Calculating matrix multiplication (one row form):"<<endl;
	showMatrix(resultado1,isize);
	cout<<"Calculating matrix addition (one row form):"<<endl;
	int* resultado2=sumMatrix(matrix1,matrix2,isize);
	showMatrix(resultado2,isize);
	cout<<"Calculating matrix substraction (one row form):"<<endl;
	int* resultado3=restMatrix(matrix1,matrix2,isize);
	showMatrix(resultado3,isize);
	cout<<"Calculating matrix transposition (one row form):"<<endl;
	int* resultado4=transpose(matrix1,isize);
	showMatrix(resultado4,isize);
	time_t mytime;
	time(&mytime);
	struct tm * timeinfo;
	timeinfo= localtime(&mytime);
 	cout<<"Execution terminated on "<<asctime(timeinfo)<<endl;

	return 0;
}

*/
