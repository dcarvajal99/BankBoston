/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo5.bankboston;

/**
 *
 * @author grupo5
 */
public class Cuenta {
    private int numero;
    private int saldo;

    public Cuenta(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return "" + numero + "\nSaldo: " + saldo + " pesos";
    }
}
