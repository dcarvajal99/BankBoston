package com.grupo5.bankboston;

import com.grupo5.bankboston.cuentas.Ahorro;
import com.grupo5.bankboston.cuentas.Corriente;
import com.grupo5.bankboston.cuentas.Credito;
import com.grupo5.bankboston.cuentas.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

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
            opcion = Utils.leerEnteroEnRango(scanner, "Seleccione una opción: ", 1, 6);

            switch (opcion) {
                case 1:
                    String rut;
                    do {
                        rut = Utils.leerStringNoVacio(scanner, "Ingrese Rut: ");
                        if (rut.length() < 11 || rut.length() > 12) {
                            System.out.println("El Rut debe tener entre 11 y 12 caracteres. (1.111.111-1 o 11.111.111-1)");
                        }
                    } while (rut.length() < 11 || rut.length() > 12);

                    String nombre = Utils.leerStringNoVacio(scanner, "Ingrese nombre: ");
                    String apPat = Utils.leerStringNoVacio(scanner, "Ingrese apellido paterno: ");
                    String apMat = Utils.leerStringNoVacio(scanner, "Ingrese apellido materno: ");
                    String domicilio = Utils.leerStringNoVacio(scanner, "Ingrese domicilio: ");
                    String comuna = Utils.leerStringNoVacio(scanner, "Ingrese comuna: ");
                    String telefono = Utils.leerTelefono(scanner, "Ingrese teléfono: ");

                    List<Cuenta> cuentas = new ArrayList<>();
                    boolean agregarOtra;
                    do {
                        int tipoCuenta = Utils.leerEnteroEnRango(scanner,
                                "Seleccione tipo de cuenta a agregar:\n1. Corriente\n2. Ahorro\n3. Crédito\n", 1, 3);

                        int numCuenta = Utils.leerEnteroPositivo(scanner, "Ingrese número de cuenta: ");
                        int saldo = Utils.leerEnteroNoNegativo(scanner, "Ingrese saldo inicial: ");

                        switch (tipoCuenta) {
                            case 1:
                                int lineaCredito = Utils.leerEnteroNoNegativo(scanner, "Ingrese línea de crédito: ");
                                cuentas.add(new Corriente(numCuenta, saldo, lineaCredito));
                                break;
                            case 2:
                                int retiros = Utils.leerEnteroPositivo(scanner, "Ingrese retiros mensuales permitidos: ");
                                int saldoMin = Utils.leerEnteroNoNegativo(scanner, "Ingrese saldo mínimo: ");
                                cuentas.add(new Ahorro(numCuenta, saldo, retiros, saldoMin));
                                break;
                            case 3:
                                int cupo = Utils.leerEnteroNoNegativo(scanner, "Ingrese cupo: ");
                                int deuda = Utils.leerEnteroNoNegativo(scanner, "Ingrese deuda inicial: ");
                                cuentas.add(new Credito(numCuenta, saldo, cupo, deuda));
                                break;
                        }
                        String resp = Utils.leerStringNoVacio(scanner, "¿Desea agregar otra cuenta a este cliente? (s/n): ");
                        agregarOtra = resp.equalsIgnoreCase("s");
                    } while (agregarOtra);

                    clientes.add(new Cliente(rut, nombre, apPat, apMat, domicilio, comuna, telefono, cuentas));
                    System.out.println("¡Cliente registrado exitosamente!");
                    break;
                case 2:
                    String rutDatos = Utils.leerStringNoVacio(scanner, "Ingrese Rut del cliente: ");
                    Cliente clienteDatos = Utils.buscarCliente(clientes, rutDatos);
                    if (clienteDatos != null) {
                        clienteDatos.mostrarInformacion();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 3:
                    String rutDep = Utils.leerStringNoVacio(scanner, "Ingrese Rut del cliente: ");
                    Cliente clienteDep = Utils.buscarCliente(clientes, rutDep);
                    if (clienteDep != null) {
                        Cuenta cuentaDep = Utils.seleccionarCuenta(clienteDep, scanner);
                        if (cuentaDep != null) {
                            int monto = Utils.leerEnteroPositivo(scanner, "Ingrese un monto para depositar: ");
                            cuentaDep.depositar(monto);
                            System.out.println("¡Depósito realizado de manera exitosa!");
                            System.out.println("Usted tiene un saldo actual de " + cuentaDep.getSaldo() + " pesos.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 4:
                    String rutGir = Utils.leerStringNoVacio(scanner, "Ingrese Rut del cliente: ");
                    Cliente clienteGir = Utils.buscarCliente(clientes, rutGir);
                    if (clienteGir != null) {
                        Cuenta cuentaGir = Utils.seleccionarCuenta(clienteGir, scanner);
                        if (cuentaGir != null) {
                            int monto = Utils.leerEnteroPositivo(scanner, "Ingrese un monto para girar: ");
                            boolean exito = cuentaGir.retirar(monto);
                            if (exito) {
                                System.out.println("¡Giro realizado de manera exitosa!");
                                System.out.println("Usted tiene un saldo actual de " + cuentaGir.getSaldo() + " pesos.");
                            } else {
                                System.out.println("No se pudo realizar el giro. Verifique condiciones de la cuenta.");
                            }
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 5:
                    String rutCon = Utils.leerStringNoVacio(scanner, "Ingrese Rut del cliente: ");
                    Cliente clienteCon = Utils.buscarCliente(clientes, rutCon);
                    if (clienteCon != null) {
                        Cuenta cuentaCon = Utils.seleccionarCuenta(clienteCon, scanner);
                        if (cuentaCon != null) {
                            System.out.println("Saldo actual: " + cuentaCon.getSaldo() + " pesos");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
            System.out.println();
        } while (opcion != 6);

        scanner.close();
    }
}