/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.util.*;
import VO.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public interface DAO_CultivoProceso {
    
    public LinkedList<VO_CultivoProceso> getAllCultivoProcesos();
    public LinkedList<VO_CultivoProceso> getCultivoProcesos(String condicion);
    public LinkedList<VO_CultivoProceso> getCultivoProcesosActivos();
    public VO_CultivoProceso getCultivoProceso(String condicion);
    public VO_CultivoProceso getLastCultivoProceso();
    public boolean crearCultivoProceso(VO_CultivoProceso cultivoProceso);
    public boolean modificarCultivoProceso(VO_CultivoProceso cultivoProceso);
    public boolean eliminarCultivoProceso(VO_CultivoProceso cultivoProceso);
    
}
