/*
 * Alumno.h
 *
 *  Created on: 13 jun. 2017
 *      Author: christian
 */

#ifndef ALUMNO_H_
#define ALUMNO_H_

#include "Persona.h"
#include "Curso.h"
class Alumno : public Persona { // sub class
public:
	Alumno(std::string nombre, std::string edad, char sexo, std::string codigo);
	Alumno();
	~Alumno();
	void setCodigo(std::string codigo);
	std::string getCodigo();
	void addCurso(Curso*);
	Curso** getCursos();
	Curso* getCurso(int index);
	Curso* getCursoMejorNota();
	Curso* getCursoMenorNota();
	void showCurso(Curso*);
private:
	int numCursos; //max 3
	std::string codigo;
	Curso** cursos;
};

#endif /* ALUMNO_H_ */
