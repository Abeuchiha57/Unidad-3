package tarea3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SorteoLigaDeFutbol {
	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese la etapa (octavos, cuartos, semifinales, final):");
        String etapa = teclado.nextLine().toLowerCase();

        int cantEquipos;
        switch (etapa) {
            case "octavos":
                cantEquipos = 16;
                break;
            case "cuartos":
                cantEquipos = 8;
                break;
            case "semifinales":
                cantEquipos = 4;
                break;
            case "final":
                cantEquipos = 2;
                break;
            default:
                System.out.println("Etapa no válida.");
                return;
        }

        List<String> equipos = new ArrayList<>();
        for (int i = 1; i <= cantEquipos; i++) {
            System.out.println("Ingrese el nombre del equipo " + i + ":");
            equipos.add(teclado.nextLine());
        }

        System.out.println("\nSorteo de la etapa de " + etapa + ":");
        sorteoRecursivo(equipos);
    }

    // Método recursivo para realizar el sorteo y mostrar los enfrentamientos
    public static void sorteoRecursivo(List<String> equipos) {
        // Caso base para la final
        if (equipos.size() == 2) {
            System.out.println("Final:");
            System.out.println("Partido: " + equipos.get(0) + " vs " + equipos.get(1));
            return;
        }

        // Sorteo de los equipos
        Collections.shuffle(equipos);

        // Emparejamiento de los equipos y mostrar los partidos
        System.out.println("Etapa con " + equipos.size() + " equipos:");
        List<String> ganadores = new ArrayList<>();
        for (int i = 0; i < equipos.size(); i += 2) {
            String equipo1 = equipos.get(i);
            String equipo2 = equipos.get(i + 1);
            System.out.println("Partido: " + equipo1 + " vs " + equipo2);

            // Simulación de ganadores para continuar a la siguiente etapa
            ganadores.add(equipo1); 
        }

        // Llamada recursiva con los ganadores
        sorteoRecursivo(ganadores);
    }
}