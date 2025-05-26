/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.grupo5.bankboston;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author grupo5
 */
public class BankBoston {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Debe ingresar un número válido para la opción.");
                scanner.nextLine();
                opcion = -1;
                System.out.println();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Rut: ");
                    String rut = scanner.nextLine();
                    if (rut.length() < 11 || rut.length() > 12) {
                        System.out.println("El Rut debe tener entre 11 y 12 caracteres.");
                        break;
                    }
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido paterno: ");
                    String apPat = scanner.nextLine();
                    System.out.print("Ingrese apellido materno: ");
                    String apMat = scanner.nextLine();
                    System.out.print("Ingrese domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Ingrese comuna: ");
                    String comuna = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingrese número de cuenta corriente: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Debe ingresar un número válido para la cuenta corriente.");
                        scanner.nextLine();
                        System.out.print("Ingrese número de cuenta corriente: ");
                    }
                    int numCuenta = scanner.nextInt();
                    scanner.nextLine();

                    Cuenta cuenta = new Cuenta(numCuenta, 0);
                    clientes.add(new Cliente(rut, nombre, apPat, apMat, domicilio, comuna, telefono, cuenta));
                    System.out.println("¡Cliente registrado exitosamente!");
                    break;
                case 2:
                    System.out.print("Ingrese Rut del cliente: ");
                    String rutDatos = scanner.nextLine();
                    Cliente clienteDatos = buscarCliente(clientes, rutDatos);
                    if (clienteDatos != null) {
                        System.out.println(clienteDatos);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese Rut del cliente: ");
                    String rutDep = scanner.nextLine();
                    Cliente clienteDep = buscarCliente(clientes, rutDep);
                    if (clienteDep != null) {
                        System.out.print("Ingrese un monto para depositar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Debe ingresar un monto válido.");
                            scanner.nextLine();
                            System.out.print("Ingrese un monto para depositar: ");
                        }
                        int monto = scanner.nextInt();
                        scanner.nextLine();
                        if (monto <= 0) {
                            System.out.println("No se permite el ingreso de montos menores o iguales a cero.");
                        } else {
                            int saldoActual = clienteDep.getCuenta().getSaldo();
                            clienteDep.getCuenta().setSaldo(saldoActual + monto);
                            System.out.println("¡Depósito realizado de manera exitosa!");
                            System.out.println("Usted tiene un saldo actual de " + clienteDep.getCuenta().getSaldo() + " pesos.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese Rut del cliente: ");
                    String rutGir = scanner.nextLine();
                    Cliente clienteGir = buscarCliente(clientes, rutGir);
                    if (clienteGir != null) {
                        int saldoActual = clienteGir.getCuenta().getSaldo();
                        if (saldoActual <= 0) {
                            System.out.println("No puede girar, saldo insuficiente.");
                            break;
                        }
                        System.out.print("Ingrese un monto para girar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Debe ingresar un monto válido.");
                            scanner.nextLine();
                            System.out.print("Ingrese un monto para girar: ");
                        }
                        int monto = scanner.nextInt();
                        scanner.nextLine();
                        if (monto <= 0) {
                            System.out.println("No se permite el ingreso de montos menores o iguales a cero.");
                        } else if (monto > saldoActual) {
                            System.out.println("No se puede girar un monto mayor al saldo de la cuenta.");
                        } else {
                            clienteGir.getCuenta().setSaldo(saldoActual - monto);
                            System.out.println("¡Giro realizado de manera exitosa!");
                            System.out.println("Usted tiene un saldo actual de " + clienteGir.getCuenta().getSaldo() + " pesos.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese Rut del cliente: ");
                    String rutCon = scanner.nextLine();
                    Cliente clienteCon = buscarCliente(clientes, rutCon);
                    if (clienteCon != null) {
                        System.out.println("Saldo actual: " + clienteCon.getCuenta().getSaldo() + " pesos");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 6);

        scanner.close();
    }

    private static Cliente buscarCliente(List<Cliente> clientes, String rut) {
        for (Cliente c : clientes) {
            if (c.getRut().equals(rut)) {
                return c;
            }
        }
        return null;
    }
}