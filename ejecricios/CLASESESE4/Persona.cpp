/*
 * Persona.cpp
 *
 *  Created on: 13 jun. 2017
 *      Author: christian
 */

#include "Persona.h"

Persona::Persona() {
	// TODO Auto-generated constructor stub
	nombre="";
	edad="9999";
	sexo='D';
}

Persona::Persona(std::string nombre,std::string edad,char sexo){
	this->nombre=nombre;
	this->edad=edad;
	this->sexo=sexo;

}

Persona::~Persona() {
	// TODO Auto-generated destructor stub
}

std::string Persona::getEdad() {
	return edad;
}

std::string Persona::getNombre(){
		return nombre;
}

char Persona::getSexo(){
	return sexo;
}
void Persona::setNombre(std::string nombre) {
	this->nombre=nombre;
}

void Persona::setEdad(std::string edad) {
	this->edad=edad;
}

void Persona::setSexo(char sexo) {
	this->sexo=sexo;
}
