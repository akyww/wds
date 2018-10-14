/*
 * Planilla.h
 *
 *  Created on: 22 jun. 2017
 *      Author: christian
 */

#ifndef PLANILLA_H_
#define PLANILLA_H_
#include "Profesor.h"
#include "Alumno.h"

class Planilla {
public:
	Planilla();
	~Planilla();
	void addProfesor(Profesor* _profesor);
	void addAlumno (Alumno* _alumno);
	Profesor* getProfesorMaxSueldo();
	Profesor* getProfesorMinSueldo();
	float getMaxSueldo();
	float getMinSueldo();
	float getPromSueldo();
	Profesor* getProfesor(int index);
	void showProfesor(Profesor*);
	int getNumProfesores();
	void showAlumnos(Alumno*);
private:
	int numProfesores;
	int numAlumnos;
	Alumno** lista;
	Profesor** planilla;
};

#endif /* PLANILLA_H_ */
