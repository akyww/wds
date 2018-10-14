/*
 * main.cpp
 *
 *  Created on: 13 jun. 2017
 *      Author: christian
 */

#include "Persona.h"
#include "Alumno.h"
#include "Profesor.h"
#include "Planilla.h"
#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>
using namespace std;


void menu(){
	cout<<"*********MENU**********"<<endl;
	cout<<"1.- Ingrese un profesor"<<endl;
	cout<<"2.- Mostrar profesor con mayor sueldo"<<endl;
	cout<<"3.- Mostrar profesor con menor sueldo"<<endl;
	cout<<"4.- Mostrar el promedio de sueldos"<<endl;
	cout<<"5.- Obtener profesor por índice:"<<endl;
	cout<<"6.- Ingresar un estudiante"<<endl;
	cout<<"7.- Mostrar estudiante con mejor nota"<<endl;
	cout<<"8.- Mostrar estudiante con menor nota"<<endl;
	cout<<"9.- Mostrar el promedio de notas de estudiante en indice"<<endl;
	cout<<"10.- Mostrar los cursos de estudiante en indice"<<endl;
	cout<<"11.- Salir"<<endl;
	cout<<"Opción:";
}

Profesor* crearProfesor(){
	string nombre;
	string edad;
	char sexo;
	string grado;
	float salario;
	cout<<"Nombre:";
	cin>> nombre;
	cout<<"Sexo:";
	cin>>sexo;
	cout<<"Edad:";
	cin>>edad;
	cout<<"Grado académico:";
	cin>>grado;
	cout<<"Salario:";
	cin>>salario;
	return new Profesor(nombre,edad,sexo,grado,salario);
}

int main(){
	Planilla planilla;
	short opcion;
	menu();
	cin>>opcion;
	//system("clear");
	do{
	switch (opcion) {
		case 1:
			planilla.addProfesor(crearProfesor());
			break;
		case 2:
			planilla.showProfesor(planilla.getProfesorMaxSueldo());
			break;
		case 3:
		    planilla.showProfesor(planilla.getProfesorMinSueldo());
			break;
        case 4:

		default:
			break;
	}
	if(opcion!=11){
		menu();
		cin>>opcion;
	}
	}while(opcion!=11);

    Profesor Profesor1("Carlitos","30",
		'F',"cuarto", 800);
    crearProfesor();

  //  planilla.showProfesor(Profesor1);
	return 0;
}
