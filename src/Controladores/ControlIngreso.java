/*
 * Con este objeto se realizan las operaciones principales del frame ingreso. Se haran las vlidaciones consultas y demás.
 */

package Controladores;

import VO.*;
import DAO.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class ControlIngreso {
    
    private DAO_UsuarioImpl daoUsuario = new DAO_UsuarioImpl();
    private VO_Usuario voUsuario;
    
    public ControlIngreso(){ }
    
    public VO_Usuario validarUsuario(String nickName, String password){
        
        voUsuario = this.daoUsuario.getUsuarioNamePass(nickName, password);
        return voUsuario;
        
    }
    
}
