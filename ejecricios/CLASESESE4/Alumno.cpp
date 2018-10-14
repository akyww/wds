/*
 * Alumno.cpp
 *
 *  Created on: 13 jun. 2017
 *      Author: christian
 */

#include "Alumno.h"

Alumno::Alumno():Persona() {
	// TODO Auto-generated constructor stub
	this->codigo="0000000";
}

Alumno::Alumno(std::string nombre, std::string edad,
		char sexo, std::string codigo):Persona(nombre,edad,sexo){
	this->codigo=codigo;
}

Alumno::~Alumno() {
	// TODO Auto-generated destructor stub
}

void Alumno::setCodigo(std::string codigo){
	this->codigo=codigo;
}

std::string Alumno::getCodigo(){
	return codigo;
}

void Alumno::addCurso(Curso* _curso){


}

Curso** Alumno::getCursos(){
	return 0;
}

Curso* Alumno::getCurso(int index){
	return 0;
}

Curso* Alumno::getCursoMejorNota(){
	return 0;
}

Curso* Alumno::getCursoMenorNota(){
	return 0;
}

void Alumno::showCurso(Curso* _curso){

}
