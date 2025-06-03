package com.grupo5.bankboston.cuentas;


public class Corriente extends Cuenta {
    private int lineaCredito;

    // Constructor completo
    public Corriente(int numero, int saldo, int lineaCredito) {
        super(numero, saldo);
        this.lineaCredito = lineaCredito;
    }

    // Sobrecarga: saldo por defecto 0
    public Corriente(int numero, int lineaCredito) {
        super(numero);
        this.lineaCredito = lineaCredito;
    }

    // Sobrecarga: todo por defecto
    public Corriente() {
        super();
        this.lineaCredito = 0;
    }

    public int getLineaCredito() { return lineaCredito; }
    public void setLineaCredito(int lineaCredito) { this.lineaCredito = lineaCredito; }

    @Override
    public void depositar(int monto) {
        setSaldo(getSaldo() + monto);
    }

    @Override
    public boolean retirar(int monto) {
        if (getSaldo() + lineaCredito >= monto && monto > 0) {
            setSaldo(getSaldo() - monto);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLínea de crédito: " + lineaCredito + " pesos";
    }
}