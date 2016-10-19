/*
 * Con esta interface implementamos los metodos que sera obligatorios en la clase.
 */

package Interfaces;

import java.util.*;
import VO.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public interface DAO_RolUsuario {
    
    public LinkedList<VO_RolUsuario> getAllRolUsuario();
    public VO_RolUsuario getRolUsuario(String rol_id);
    public boolean crearRolUsuario(VO_RolUsuario rol);
    public boolean modificarRolUsuario(VO_RolUsuario rol);
    public boolean elimnarRolUsuario(VO_RolUsuario rol);
    
}
