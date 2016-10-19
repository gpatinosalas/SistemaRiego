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
public interface DAO_Sistema {
    
    public LinkedList<VO_Sistema> getAllSistemas();
    public LinkedList<VO_Sistema> getSistemas(String condicion);
    public VO_Sistema getSistema(String condicion);
    public boolean creaSistema(VO_Sistema sistema);
    public boolean modificarSistema(VO_Sistema sistema);
    public boolean eliminarSistema(VO_Sistema sistema);
    
}
