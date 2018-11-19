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
public class CargoModel {
   private int id_cargo;
   private String nombre_cargo;

    public CargoModel(int id_cargo, String nombre_cargo) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
    }

    public CargoModel() {
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }
   
    
}
