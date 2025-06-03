package com.grupo5.bankboston;

import com.grupo5.bankboston.cuentas.Cuenta;
import java.util.List;
import java.util.Scanner;


public class Utils {

    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor > 0) return valor;
                else System.out.println("Debe ingresar un número positivo.");
            } else {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= 0) return valor;
                else System.out.println("No puede ser negativo.");
            } else {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static int leerEnteroEnRango(Scanner scanner, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= min && valor <= max) return valor;
                else System.out.println("Debe ingresar un número entre " + min + " y " + max + ".");
            } else {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine();
            }
        }
    }

    public static String leerTelefono(Scanner scanner, String mensaje) {
        String telefono;
        while (true) {
            System.out.print(mensaje);
            telefono = scanner.nextLine();
            if (telefono.matches("\\d+")) return telefono;
            else System.out.println("Debe ingresar solo números para el teléfono.");
        }
    }

    public static String leerStringNoVacio(Scanner scanner, String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    public static Cliente buscarCliente(List<Cliente> clientes, String rut) {
        for (Cliente c : clientes) {
            if (c.getRut().equals(rut)) {
                return c;
            }
        }
        return null;
    }

    public static Cuenta seleccionarCuenta(Cliente cliente, Scanner scanner) {
        List<Cuenta> cuentas = cliente.getCuentas();
        if (cuentas.isEmpty()) {
            System.out.println("El cliente no tiene cuentas registradas.");
            return null;
        }
        System.out.println("Seleccione la cuenta:");
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).toString());
        }
        int seleccion = leerEnteroEnRango(scanner, "Ingrese el número de la cuenta: ", 1, cuentas.size());
        return cuentas.get(seleccion - 1);
    }
}