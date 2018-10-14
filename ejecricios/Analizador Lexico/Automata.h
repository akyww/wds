#ifndef AUTOMATA_H_INCLUDED
#define AUTOMATA_H_INCLUDED

namespace uls
{
	namespace AnalisisLexico
	{
		/////////////////////////////////////////////////////////
		// Esta clase representa a un automata de estado finito
		// determinista el cual se usará en nuestro analizador
		// lexico.
		/////////////////////////////////////////////////////////
		class Automata
		{
		private:
			/////////////////////////////////////////////////////
			//						Atributos
			/////////////////////////////////////////////////////
			int** 	delta; 			//Representa a la matriz de funciones de transicion del automata
			int		estadoActual;

		public:
			Automata();
			~Automata();

			bool mover(char c);		//Me indica si se acepto el caracter
			void reiniciar();		//Cambia el estadoActual a 0
			int	 obtenerEstado();
		};

	}
}
#endif // AUTOMATA_H_INCLUDED
