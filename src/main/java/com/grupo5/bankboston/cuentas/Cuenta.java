/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo5.bankboston.cuentas;

/**
 *
 * @author grupo5
 */

public abstract class Cuenta {
    private int numero;
    private int saldo;

    // Constructor principal
    public Cuenta(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Cuenta(int numero) {
        this(numero, 0);
    }

    public Cuenta() {
        this(0, 0);
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getSaldo() { return saldo; }
    public void setSaldo(int saldo) { this.saldo = saldo; }

    public abstract void depositar(int monto);
    public abstract boolean retirar(int monto);

    @Override
    public String toString() {
        return "N°: " + numero + "\nSaldo: " + saldo + " pesos";
    }
}