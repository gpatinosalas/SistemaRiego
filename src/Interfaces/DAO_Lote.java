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
public interface DAO_Lote {
    
    public LinkedList<VO_Lote> getAllLotes();
    public LinkedList<VO_Lote> getLostes(String condicion);
    public VO_Lote getLote(String condicion);
    public boolean crearLote(VO_Lote lote);
    public boolean modificarLote(VO_Lote lote);
    public boolean eliminarLote(VO_Lote lote);
    
}
