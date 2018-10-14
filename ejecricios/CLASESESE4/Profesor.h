/*
 * Profesor.h
 *
 *  Created on: 20 jun. 2017
 *      Author: christian
 */

#ifndef PROFESOR_H_
#define PROFESOR_H_

#include "Persona.h"
#include <string>

class Profesor : public Persona {
public:
	Profesor();
	Profesor(std::string nombre,std::string edad,char sexo,std::string grado,float salario);
	~Profesor();

	std::string getGrado();
	float getSalario();
	void setGrado(std::string grado);
	void setSalario(float salario);

private:
	std::string grado;
	float salario;
};

#endif /* PROFESOR_H_ */
