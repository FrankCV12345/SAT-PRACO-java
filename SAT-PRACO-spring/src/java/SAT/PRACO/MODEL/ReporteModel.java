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
public class ReporteModel {
    private int idreporte,idUsu,tareasCumplidas,tareasIncumplidas;
    private double promedioTiempo;
    private String fechaReporte;

    public ReporteModel(int idUsu, int tareasCumplidas, int tareasIncumplidas, double promedioTiempo, String fechaReporte) {
        this.idUsu = idUsu;
        this.tareasCumplidas = tareasCumplidas;
        this.tareasIncumplidas = tareasIncumplidas;
        this.promedioTiempo = promedioTiempo;
        this.fechaReporte = fechaReporte;
    }

    public int getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(int idreporte) {
        this.idreporte = idreporte;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getTareasCumplidas() {
        return tareasCumplidas;
    }

    public void setTareasCumplidas(int tareasCumplidas) {
        this.tareasCumplidas = tareasCumplidas;
    }

    public int getTareasIncumplidas() {
        return tareasIncumplidas;
    }

    public void setTareasIncumplidas(int tareasIncumplidas) {
        this.tareasIncumplidas = tareasIncumplidas;
    }

    public double getPromedioTiempo() {
        return promedioTiempo;
    }

    public void setPromedioTiempo(double promedioTiempo) {
        this.promedioTiempo = promedioTiempo;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
    
}
