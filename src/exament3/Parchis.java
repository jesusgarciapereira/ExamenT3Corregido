package exament3;

import java.util.Random;

/**
 * Clase que determina el funcionamiento del juego del parchis
 */
public class Parchis {
	/**
	 * Cosntante que indica el tamannio del tablero
	 */
	public static final int TAM_TABLERO = 10;

	/**
	 * Valores del primer dado en cada tirada
	 */
	static int dado1;
	/**
	 * Valores del segundo dado en cada tirada
	 */
	static int dado2;

	/**
	 * Posiciones de la ficha del Jugador 1, inicialmente en la casilla 0
	 */
	int fichaJ1 = 0; 
	
	/**
	 * Posiciones de la ficha del Jugador 2, inicialmente en la casilla 0
	 */
	int fichaJ2 = 0;

	/**
	 * Nombre del Jugador 1, inicialmente vacio
	 */
	String nomJ1 = "";
	/**
	 * Nombre del Jugador 2, inicialmente vacio
	 */
	String nomJ2 = "";

	/**
	 * Construcctor sin parámetros
	 */
	public Parchis() {
		super();
	}

	/**
	 * Constructor con ambos nombres como parametros
	 * 
	 * @param nomJ1 Nombre del Jugador 1
	 * @param nomJ2 Nombre del Jugador 2
	 */
	public Parchis(String nomJ1, String nomJ2) {
		super();
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	/**
	 * Funcion que representa la tirada de los dados. Asigna aleatoriamente a cada
	 * dado un valor entre 1 y 6
	 */
	public static void tiraDados() {
		Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	/**
	 * Funcion para pintar el tablero de juego y las fichas en su correspondiente
	 * posicion. Con la letra I como la casilla 0 y con la Letra F para la casilla
	 * equivalente al tamannio del tablero. También apareceran los nombres de los
	 * juegadores
	 */
	public void pintaTablero() {
		System.out.print("\tI");
		for (int i = 1; i < TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("\tF");

		System.out.print(nomJ1 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ1) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}

		System.out.println("\tF");

		System.out.print(nomJ2 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ2) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}
		System.out.println("\tF\n");

	}

	/**
	 * Funcion que representa el avance de las fichas segun los valores asignados a
	 * los dados y la posicion en la que se encentre
	 * 
	 * @param jugador Jugador que tenga el turno
	 */
	public void avanzaPosiciones(int jugador) {
		int tirada = dado1 + dado2;

		if (jugador == 1) {
			fichaJ1 += tirada;

			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO - (fichaJ1 - TAM_TABLERO);
			}
		} else if (jugador == 2) {
			fichaJ2 += tirada;

			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}
	}

	/**
	 * Funcion que muestra el mensaje del estado de la carrera: quien va ganando o
	 * si van empatados
	 */
	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			System.out.println("Va ganando " + nomJ2);
		} else {
			System.out.println("Van empatados");
		}
		System.out.println();
	}

	/**
	 * Funcion que indica quien ha ganado la partida
	 * 
	 * @return Nombre del Jugador 1, nombre del Jugador 2 o campo vacio
	 */
	public String esGanador() {

		if (fichaJ1 == TAM_TABLERO) {
			return nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			return nomJ2;
		} else {
			return "";
		}

	}

}
