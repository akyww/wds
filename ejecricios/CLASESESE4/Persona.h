/*
 * Persona.h
 *
 *  Created on: 13 jun. 2017
 *      Author: christian
 */

#ifndef PERSONA_H_
#define PERSONA_H_

#include <string>

class Persona{
public:
	Persona();
	Persona(std::string nombre,std::string edad,char sexo);
    ~Persona();
    std::string getNombre();
    std::string getEdad();
	char getSexo();
	void setNombre(std::string nombre);
	void setEdad(std::string edad);
	void setSexo(char sexo);

protected:

private:
	std::string nombre;
	std::string edad;
	char sexo;

protected:
};





#endif /* PERSONA_H_ */
