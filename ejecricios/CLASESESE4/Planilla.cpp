/*
 * Planilla.cpp
 *
 *  Created on: 22 jun. 2017
 *      Author: christian
 */

#include "Planilla.h"
#include <iostream>
Planilla::Planilla() {
	// TODO Auto-generated constructor stub
	numProfesores=0;
	planilla= new Profesor*[10];
}

Planilla::~Planilla() {
	// TODO Auto-generated destructor stub
	if(planilla){
		delete[] planilla;
	}
}

void Planilla::addProfesor(Profesor* _profesor){
	if(numProfesores<10){
		planilla[numProfesores]=_profesor;
		numProfesores+=1;
	}
}

float Planilla::getMaxSueldo(){
	float maxSueldo=0;
	for(short iter=0;iter<numProfesores;iter++){
		if(planilla[iter]->getSalario()>maxSueldo){
			maxSueldo= planilla[iter]->getSalario();
		}
	}
	return maxSueldo;
}

Profesor* Planilla::getProfesorMaxSueldo(){
	float maxSueldo=0;
	int index=0;
	for(short iter=0;iter<numProfesores;iter++){
		if(planilla[iter]->getSalario()>maxSueldo){
			maxSueldo=planilla[iter]->getSalario();
			index=iter;
		}
	}
	return planilla[index];
}

Profesor* Planilla::getProfesorMinSueldo(){
	float minSueldo=99999.9;
	int index=0;
	for(short iter=0;iter<numProfesores;iter++){
		if(planilla[iter]->getSalario()<minSueldo){
			minSueldo=planilla[iter]->getSalario();
			index=iter;
		}
	}
	return planilla[index];
}



float Planilla::getMinSueldo(){
	return 0;
}

float Planilla::getPromSueldo(){
    float minSueldo=99999.9;
	int index=0;
	for(short iter=0;iter<numProfesores;iter++){
        int suma= planilla[iter]->getSalario();
		if(planilla[iter]->getSalario()<minSueldo){
			minSueldo=planilla[iter]->getSalario();
			index=iter;
		}
	}
	return planilla[index];
	return 0;
}

Profesor* Planilla::getProfesor(int index){
	return 0;
}

int Planilla::getNumProfesores(){
	return numProfesores;
}

void Planilla::showProfesor(Profesor* _profesor){
	std::cout<<"Nombre:"<<_profesor->getNombre()<<std::endl;
	std::cout<<"Edad:"<<_profesor->getEdad()<<std::endl;
	std::cout<<"Sexo:"<<_profesor->getSexo()<<std::endl;
	std::cout<<"Grado académico:"<<_profesor->getGrado()<<std::endl;
	std::cout<<"Salario"<<_profesor->getSalario()<<std::endl;
}
