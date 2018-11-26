/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.IDAO;
import SAT.PRACO.MODEL.ReporteModel;
import SAT.PRACO.MODEL.USER_MODEL;
import SAT.PRACO.MODEL.model_tareaUser;
import java.util.List;
/**
 *
 * @author SARA
 */
public interface IOperacionesUser {
    public String RegistraIngreso(int id_user);
    public String RegistroSalida(int id_user);
    public String Registrouser(USER_MODEL usu);
    public String Registarea(model_tareaUser tarea);
    public List<USER_MODEL> ListaUsers();
    public List<model_tareaUser> listaTareasPorUSer(int id_user);
    public USER_MODEL Login(int  iduser);
    public String InicioTarea(String fechainicio,int idtarea);
    public String FinTarea(String fechafin,int idtarea);
    public List<model_tareaUser> listatareasPorFEchayuser(model_tareaUser tarea);
    public String RegistraReporte(ReporteModel repore);
}
