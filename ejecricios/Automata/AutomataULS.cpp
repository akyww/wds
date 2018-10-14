//============================================================================
// Name        : AutomataULS.cpp
// Author      : JVC
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "Automata.h"
using namespace std;

int main() {
	uls::AnalisisLexico::Automata objeto;

	string prueba = "121.s";

	for( auto c : prueba )
		objeto.mover(c);

	cout<<objeto.obtenerEstado();

	return 0;
}
