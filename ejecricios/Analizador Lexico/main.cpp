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
