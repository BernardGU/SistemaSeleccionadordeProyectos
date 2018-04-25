package com.bernard_gu.sistemaseleccionadordeproyectos;

import java.util.ArrayList;

/**
 * Esta clase guardará los atributos de cada criterio
 */

public class Criterio {
    public Criterio(String nombre, Boolean cuantitativo, Boolean mayorEsMejor, int ponderacion) {
        this.nombre = nombre;
        this.cuantitativo = cuantitativo;
        this.mayorEsMejor = mayorEsMejor;
        this.ponderacion = ponderacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getCuantitativo() {
        return cuantitativo;
    }

    public Boolean getMayorEsMejor() {
        return mayorEsMejor;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public int getValor() {
        return valor;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static void addCriterio(Criterio c) {
        Criterio.listaCriterios.add(c);
        Criterio.cantCriterios++;
    }

    private String nombre;
    private Boolean cuantitativo;
    private Boolean mayorEsMejor;
    private int ponderacion; //Expresada en porcentaje
    private int valor; //Este valor será único para cada proyecto

    public static ArrayList<Criterio> listaCriterios = new ArrayList<Criterio>();
    public static int cantCriterios = 0;
}
