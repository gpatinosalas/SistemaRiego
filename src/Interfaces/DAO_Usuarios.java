/*
 * Con esta interface implementamos los metodos que sera obligatorios en la clase.
 */

package Interfaces;

import VO.*;
import java.util.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public interface DAO_Usuarios {
    
    public LinkedList<VO_Usuario> getAllUsuarios();
    public LinkedList<VO_Usuario> getUsuarios(String condicion);
    public VO_Usuario getUsuarioID(String id);
    public VO_Usuario getUsuarioNamePass(String nickName, String password);
    public VO_Usuario getUsuario(String condicion);
    public boolean crearUsuario(VO_Usuario usuario);
    public boolean modificarUsuario(VO_Usuario usario);
    public boolean eliminarUsuario(VO_Usuario usario);
    
    
}
