/*
 * Profesor.cpp
 *
 *  Created on: 20 jun. 2017
 *      Author: christian
 */

#include "Profesor.h"

Profesor::Profesor():Persona() {
	// TODO Auto-generated constructor stub
	grado = "";
	salario = 0.0f;
}

Profesor::~Profesor() {
	// TODO Auto-generated destructor stub
}

Profesor::Profesor(std::string nombre,std::string edad,
		char sexo,std::string grado, float salario):Persona(nombre,edad,sexo){
	this->grado=grado;
	this->salario=salario;
}

std::string Profesor::getGrado(){
	return this->grado;
}

float Profesor::getSalario(){
	return this->salario;
}

void Profesor::setGrado(std::string grado){
	this->grado=grado;
}

void Profesor::setSalario(float salario){
	this->salario=salario;
}
