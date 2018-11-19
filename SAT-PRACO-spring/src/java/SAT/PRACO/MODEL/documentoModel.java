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
public class documentoModel {
    private int Id_documento;
    private String nombre_doc;

    public documentoModel(int Id_documento, String nombre_doc) {
        this.Id_documento = Id_documento;
        this.nombre_doc = nombre_doc;
    }

    public documentoModel() {
    }

    public int getId_documento() {
        return Id_documento;
    }

    public void setId_documento(int Id_documento) {
        this.Id_documento = Id_documento;
    }

    public String getNombre_doc() {
        return nombre_doc;
    }

    public void setNombre_doc(String nombre_doc) {
        this.nombre_doc = nombre_doc;
    }
    
}
