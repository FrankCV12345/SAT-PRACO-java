/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.IDAO;
import SAT.PRACO.MODEL.USER_MODEL;
import SAT.PRACO.MODEL.model_tareaUser;
/**
 *
 * @author SARA
 */
public interface IOperacionesUser {
    public String RegistraIngreso(int id_user);
    public String RegistroSalida(int id_user);
    public String Registrouser(USER_MODEL usu);
    public String Registarea(model_tareaUser tarea);
}
