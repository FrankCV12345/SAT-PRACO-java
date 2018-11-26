/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.MODEL;

/**
 *
 * @author SARA
 */
public class Tarea_model {
    private int idTarea,horas;
    private String descripcion,estado;

    public Tarea_model(int idTarea, int horas, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.horas = horas;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea_model(int horas, String descripcion, String estado) {
        this.horas = horas;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
