/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.IDAO;
import SAT.PRACO.MODEL.Tarea_model;
import java.util.List;

/**
 *
 * @author SARA
 */
public interface IOperacionesTarea {
    public List<Tarea_model> listaTareas();
    public String Addtarea(Tarea_model tarea);
    
}
