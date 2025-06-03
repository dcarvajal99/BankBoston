package com.grupo5.bankboston.cuentas;


public class Ahorro extends Cuenta {
    private int retirosMensuales;
    private int saldoMinimo;

    // Constructor completo
    public Ahorro(int numero, int saldo, int retirosMensuales, int saldoMinimo) {
        super(numero, saldo);
        this.retirosMensuales = retirosMensuales;
        this.saldoMinimo = saldoMinimo;
    }

    // Sobrecarga: saldo por defecto 0
    public Ahorro(int numero, int retirosMensuales, int saldoMinimo) {
        super(numero);
        this.retirosMensuales = retirosMensuales;
        this.saldoMinimo = saldoMinimo;
    }

    // Sobrecarga: todo por defecto
    public Ahorro() {
        super();
        this.retirosMensuales = 0;
        this.saldoMinimo = 0;
    }

    public int getRetirosMensuales() { return retirosMensuales; }
    public void setRetirosMensuales(int retirosMensuales) { this.retirosMensuales = retirosMensuales; }
    public int getSaldoMinimo() { return saldoMinimo; }
    public void setSaldoMinimo(int saldoMinimo) { this.saldoMinimo = saldoMinimo; }

    @Override
    public void depositar(int monto) {
        setSaldo(getSaldo() + monto);
    }

    @Override
    public boolean retirar(int monto) {
        if (getSaldo() - monto >= saldoMinimo && retirosMensuales > 0 && monto > 0) {
            setSaldo(getSaldo() - monto);
            retirosMensuales--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRetiros mensuales permitidos: " + retirosMensuales +
                "\nSaldo mínimo: " + saldoMinimo + " pesos";
    }

}