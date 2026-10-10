package main;

import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

public class Main {
    public static void main(String[] args) {
        RegistroPrototipos registro = new RegistroPrototipos();

                                                                
        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Poción de vida");
        registro.registrarPrototipo("Guerrero", new Personaje("Guerrero", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Baculo");
        invMago.agregarItem("Poción de maná");
        registro.registrarPrototipo("Mago", new Personaje("Mago", "Mago", invMago));

        System.out.println("=== Prototipos registrados ===");
        System.out.println(registro.verPrototipo("Guerrero"));
        System.out.println(registro.verPrototipo("Mago"));
        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        System.out.println();
        System.out.println("=== Copias recién clonadas ===");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        guerreroCopia.getInventario().agregarItem("Escudo");
        magoCopia.getInventario().agregarItem("Libro de hechizos");

        System.out.println();
        System.out.println("=== Después de modificar las copias ===");
        System.out.println(guerreroCopia);
        System.out.println(magoCopia);

        System.out.println();
        System.out.println("=== Los prototipos originales no cambiaron ===");
        System.out.println(registro.verPrototipo("Guerrero"));
        System.out.println(registro.verPrototipo("Mago"));

        System.out.println();
        System.out.println("¿Comparten inventario Guerrero y Guerrero-Copia? "
                + (registro.verPrototipo("Guerrero").getInventario() == guerreroCopia.getInventario()));

        // Si el prototipo no existe no se intenta clonar
        System.out.println();
        System.out.println("=== Prototipo inexistente ===");
        Personaje arquero = registro.obtenerCopia("Arquero");
        if (arquero == null) {
            System.out.println("No existe el prototipo 'Arquero'; no se clonó nada.");
        }
    }
}
