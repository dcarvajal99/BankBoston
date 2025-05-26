/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author grupo5
 */
public class Cliente {
    private String rut;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;

    public Cliente(String rut, String nombre, String apellido_paterno, String apellido_materno, String domicilio, String comuna, String telefono, Cuenta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "\n===== Cliente =====\n" +
                "RUT: " + rut + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido Paterno: " + apellido_paterno + "\n" +
                "Apellido Materno: " + apellido_materno + "\n" +
                "Domicilio: " + domicilio + "\n" +
                "Comuna: " + comuna + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Cuenta: " + cuenta + "\n" +
                "==================\n";
    }
}