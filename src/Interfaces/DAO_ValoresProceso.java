/*
 * 
 */

package Interfaces;

import java.util.*;
import VO.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public interface DAO_ValoresProceso {
    
    public LinkedList<VO_ValoresProceso> getAllValoresProceso(VO_CultivoProceso cultivoProceso);
    public LinkedList<VO_ValoresProceso> getValoresProceso(String condicion);
    public VO_ValoresProceso getValorProceso (VO_CultivoProceso cultivoProceso, String condicion);
    public VO_ValoresProceso getLastValorProceso (VO_CultivoProceso cultivoProceso);
    public boolean crearValorProceso(VO_ValoresProceso valorProceso);
    public boolean modificarValorProceso (VO_ValoresProceso valorProceso);
    public boolean eliminarValorProceso(VO_ValoresProceso valorProceso);
    
}
