package Model.Entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

public class Trabajador {

    //Creamos los atributos del Objeto cliente, que hace referencia a las columnas de la Tabla TRABAJADOR.

    private Integer idTrabajador;

    private String nombre;

    private String apellido;

    private Integer numeroSS;

    private Double salario;

    private String telefono;

    private String email;

    private String contrasena;

    private String tipoTrabajo;

    private Date FechaContratacion;


    //Crearemos el constructor con todos los campos de los atributos anteriores
    public Trabajador(Integer idTrabajador, String nombre, String apellido, Integer numeroSS, Double salario, String telefono, String email, String contrasena, String tipoTrabajo, Date fechaContratacion) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSS = numeroSS;
        this.salario = salario;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
        this.tipoTrabajo = tipoTrabajo;
        FechaContratacion = fechaContratacion;
    }

    //Crearemos el constructor vacio de los atributos anteriores
    public Trabajador () {
    }



    //Crear los Getter y setter de los atributos de la clase TrabajdorBean.
    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(Integer numeroSS) {
        this.numeroSS = numeroSS;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public Date getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        FechaContratacion = fechaContratacion;
    }


    //Crear el metodo ToSting del objeto Cliente

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", numeroSS=" + numeroSS + ", salario=" + salario + ", telefono='" + telefono + '\'' + ", email='" + email + '\'' + ", contrasena='" + contrasena + '\'' + ", tipoTrabajo='" + tipoTrabajo + '\'' + ", FechaContratacion=" + FechaContratacion + '}';
    }


    //Creamos el método Json para pasar el arrayList a Json
    public static String toArrayJson(ArrayList<Trabajador> Trabajador) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(Trabajador);
    }





}
