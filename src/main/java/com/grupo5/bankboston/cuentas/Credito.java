package com.grupo5.bankboston.cuentas;

public class Credito extends Cuenta {
    private int cupo;
    private int deuda;

    // Constructor completo
    public Credito(int numero, int saldo, int cupo, int deuda) {
        super(numero, saldo);
        this.cupo = cupo;
        this.deuda = deuda;
    }

    // Sobrecarga: saldo por defecto 0
    public Credito(int numero, int cupo, int deuda) {
        super(numero);
        this.cupo = cupo;
        this.deuda = deuda;
    }

    // Sobrecarga: todo por defecto
    public Credito() {
        super();
        this.cupo = 0;
        this.deuda = 0;
    }

    public int getCupo() { return cupo; }
    public void setCupo(int cupo) { this.cupo = cupo; }
    public int getDeuda() { return deuda; }
    public void setDeuda(int deuda) { this.deuda = deuda; }

    @Override
    public void depositar(int monto) {
        if (deuda > 0) {
            int pago = Math.min(monto, deuda);
            deuda -= pago;
            monto -= pago;
        }
        setSaldo(getSaldo() + monto);
    }

    @Override
    public boolean retirar(int monto) {
        if (getSaldo() + (cupo - deuda) >= monto && monto > 0) {
            if (getSaldo() >= monto) {
                setSaldo(getSaldo() - monto);
            } else {
                int restante = monto - getSaldo();
                setSaldo(0);
                deuda += restante;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCupo: " + cupo + " pesos\nDeuda: " + deuda + " pesos";
    }
}