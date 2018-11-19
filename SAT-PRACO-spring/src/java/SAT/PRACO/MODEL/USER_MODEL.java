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
public class USER_MODEL {
        private int id_user,id_cargo,id_Docimento;
        private String Nombre,Apellido,Email,Contacto,fecha_nac,estado_civil,sexo,nacionalidad,domicilio,nro_documento;

    public USER_MODEL( String Nombre, String Apellido, String Email, String Contacto,int id_cargo, String fecha_nac, String estado_civil, String sexo, String nacionalidad, String domicilio, int id_Docimento, String nro_documento) {
        this.id_cargo = id_cargo;
        this.id_Docimento = id_Docimento;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Contacto = Contacto;
        this.fecha_nac = fecha_nac;
        this.estado_civil = estado_civil;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.nro_documento = nro_documento;
    }

    public USER_MODEL(int id_user, int id_cargo, int id_Docimento, String Nombre, String Apellido, String Email, String Contacto, String fecha_nac, String estado_civil, String sexo, String nacionalidad, String domicilio, String nro_documento) {
        this.id_user = id_user;
        this.id_cargo = id_cargo;
        this.id_Docimento = id_Docimento;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Contacto = Contacto;
        this.fecha_nac = fecha_nac;
        this.estado_civil = estado_civil;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.domicilio = domicilio;
        this.nro_documento = nro_documento;
    }

    public USER_MODEL() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_Docimento() {
        return id_Docimento;
    }

    public void setId_Docimento(int id_Docimento) {
        this.id_Docimento = id_Docimento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }
        
}
