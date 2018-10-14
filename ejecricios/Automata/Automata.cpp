/*
 * Automata.cpp
 *
 *  Created on: 11 set. 2017
 *      Author: aapa9
 */

#include "Automata.h"
#include <functional>

using namespace std;

using namespace uls::AnalisisLexico;

Automata::Automata()
{
	estadoActual = 0;

	delta = new int*[18];
	for(int fila=0; fila<18 ;fila++)
	{
		delta[fila] = new int[256];
		for(int columna=0; columna<256 ;columna++)
			delta[fila][columna] = -1;
	}

	function<void(int,int,int,int)> llenarFilaRango = [=] (int fila,int inferior,int superior,int estado) -> void
	{
		for(int columna=inferior; columna<superior ;columna++)
			delta[fila][columna] = estado;
	};

	function<void(int,string,int)> llenarFilaPorCaracteres = [=](int fila,string caracteres, int estado) -> void
	{
		for( char c : caracteres )
			delta[fila][c] = estado;
	};

	function<void(int,string,int)> llenarFilaPorTodoExcepto = [=](int fila,string caracteres, int estado) -> void
	{
		for( int columna=0; columna<256 ;columna++ )
			delta[fila][columna] = estado;

		for( char c : caracteres )
			delta[fila][c] = -1;
	};

	llenarFilaRango(0,'a','z',1);
	llenarFilaRango(0,'A','Z',1);
	llenarFilaRango(0,'0','9',2);
	llenarFilaRango(1,'a','z',1);
	llenarFilaRango(2,'0','9',2);
	llenarFilaRango(12,'0','9',13);
	llenarFilaRango(13,'0','9',13);

	llenarFilaPorCaracteres(0,"+-*/%",3);
	llenarFilaPorCaracteres(0,"[](){}¿?,;",4);
	llenarFilaPorCaracteres(0,"!",6);
	llenarFilaPorCaracteres(0,"><=",8);
	llenarFilaPorCaracteres(0,"@",10);
	llenarFilaPorCaracteres(0,"_$",1);
	llenarFilaPorCaracteres(1,"_$",1);
	llenarFilaPorCaracteres(2,".",12);
	llenarFilaPorCaracteres(6,"=",7);
	llenarFilaPorCaracteres(8,"=",9);
	llenarFilaPorCaracteres(10,"*",11);

	llenarFilaPorTodoExcepto(11,"*",11);
	llenarFilaPorCaracteres(11,"*",14);

	llenarFilaPorCaracteres(14,"@",15);
	llenarFilaPorCaracteres(10,"@",16);
	llenarFilaPorTodoExcepto(16,"\n",16);
	llenarFilaPorCaracteres(16,"\n",17);
}

Automata::~Automata()
{
	for(int fila=0; fila<18 ;fila++)
		delete[] delta[fila];

	delete[] delta;
}

bool Automata::mover(char c)
{
	if( c>=0 && c<256 )
	{
		int nuevoEstado = delta[estadoActual][c];
		if(nuevoEstado == -1)
			return false;
		estadoActual = nuevoEstado;
		return true;
	}
	return false;
}

void Automata::reiniciar()
{
	estadoActual = 0;
}

int	 Automata::obtenerEstado()
{
	return estadoActual;
}



