package com.bernard_gu.sistemaseleccionadordeproyectos;

import java.util.ArrayList;

/**
 * Esta clase guardarà los atributos del proyecto
 */

public class Proyecto {

    public Proyecto(String identificador, String descripcion, double costo, ArrayList<Criterio> criterios) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.costo = costo;
        this.criterios = criterios;

        //Modificar los atributos estáticos de la clase
        Proyecto.listaProyectos.add(this);
        Proyecto.cantProyectos++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public ArrayList<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Criterio> criterios) {
        this.criterios = criterios;
    }

    //Atributos privados de cada instancia
    private String identificador;
    private String descripcion;
    private double costo;
    private ArrayList<Criterio> criterios = new ArrayList<Criterio>();

    //Atributos estáticos de la clase
    public static ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
    public static int cantProyectos = 0;

}
