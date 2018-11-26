/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.MODEL;

/**
 *
 * @author Administrador
 */
public class model_tareaUser {
    private int id_tarea,idUser,idtarealst,idsupervisor;
    private String HoraInicio,HoraTermino,Fechatarea,HoraInicioE,HoraTerminoE,observacion,nombreTarea;

    public model_tareaUser(int id_tarea, String HoraInicio) {
        this.id_tarea = id_tarea;
        this.HoraInicio = HoraInicio;
    }

    public model_tareaUser(int id_tarea, int idUser, int idtarealst, int idsupervisor, String HoraInicio, String HoraTermino, String Fechatarea, String HoraInicioE, String HoraTerminoE, String observacion, String nombreTarea) {
        this.id_tarea = id_tarea;
        this.idUser = idUser;
        this.idtarealst = idtarealst;
        this.idsupervisor = idsupervisor;
        this.HoraInicio = HoraInicio;
        this.HoraTermino = HoraTermino;
        this.Fechatarea = Fechatarea;
        this.HoraInicioE = HoraInicioE;
        this.HoraTerminoE = HoraTerminoE;
        this.observacion = observacion;
        this.nombreTarea = nombreTarea;
    }

    public model_tareaUser() {
    }

    public model_tareaUser(int id_tarea, int idUser, int idtarealst, int idsupervisor, String HoraInicioE, String HoraTerminoE, String observacion) {
        this.id_tarea = id_tarea;
        this.idUser = idUser;
        this.idtarealst = idtarealst;
        this.idsupervisor = idsupervisor;
        this.HoraInicioE = HoraInicioE;
        this.HoraTerminoE = HoraTerminoE;
        this.observacion = observacion;
    }

    public model_tareaUser(int idUser, int idtarealst, int idsupervisor, String HoraInicioE, String HoraTerminoE, String observacion) {
        this.idUser = idUser;
        this.idtarealst = idtarealst;
        this.idsupervisor = idsupervisor;
        this.HoraInicioE = HoraInicioE;
        this.HoraTerminoE = HoraTerminoE;
        this.observacion = observacion;
    }
    

    public model_tareaUser(int id_tarea, int idUser, int idtarealst, int idsupervisor, String HoraInicio, String HoraTermino, String Fechatarea, String HoraInicioE, String HoraTerminoE, String observacion) {
        this.id_tarea = id_tarea;
        this.idUser = idUser;
        this.idtarealst = idtarealst;
        this.idsupervisor = idsupervisor;
        this.HoraInicio = HoraInicio;
        this.HoraTermino = HoraTermino;
        this.Fechatarea = Fechatarea;
        this.HoraInicioE = HoraInicioE;
        this.HoraTerminoE = HoraTerminoE;
        this.observacion = observacion;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdtarealst() {
        return idtarealst;
    }

    public void setIdtarealst(int idtarealst) {
        this.idtarealst = idtarealst;
    }

    public int getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(int idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraTermino() {
        return HoraTermino;
    }

    public void setHoraTermino(String HoraTermino) {
        this.HoraTermino = HoraTermino;
    }

    public String getFechatarea() {
        return Fechatarea;
    }

    public void setFechatarea(String Fechatarea) {
        this.Fechatarea = Fechatarea;
    }

    public String getHoraInicioE() {
        return HoraInicioE;
    }

    public void setHoraInicioE(String HoraInicioE) {
        this.HoraInicioE = HoraInicioE;
    }

    public String getHoraTerminoE() {
        return HoraTerminoE;
    }

    public void setHoraTerminoE(String HoraTerminoE) {
        this.HoraTerminoE = HoraTerminoE;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
