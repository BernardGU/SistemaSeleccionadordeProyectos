package com.bernard_gu.sistemaseleccionadordeproyectos;

import java.util.ArrayList;

/**
 * Esta clase guardarà los atributos del proyecto
 */

public class Proyecto {

    public Proyecto(String identificador, String descripcion, int costo, ArrayList<Criterio> criterios) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.costo = costo;
        this.criterios = new ArrayList<>(criterios);
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Criterio> criterios) {
        this.criterios = new ArrayList<>(criterios);
    }

    //Atributos privados de cada instancia
    private String identificador;
    private String descripcion;
    private int costo;
    public ArrayList<Criterio> criterios;

    //Atributos estáticos de la clase
    public static ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();

}
