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
public interface DAO_Cultivo {
    
    public LinkedList<VO_Cultivo> getAllCultivos();
    public LinkedList<VO_Cultivo> getCultivos(String condicion);
    public VO_Cultivo getCultivo(String condicion);
    public boolean crearCultivo (VO_Cultivo cultivo);
    public boolean modificarCultivo(VO_Cultivo cultivo);
    public boolean eliminarCultivo(VO_Cultivo cultivo);
    
}
