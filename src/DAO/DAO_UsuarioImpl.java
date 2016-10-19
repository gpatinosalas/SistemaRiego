/*
 * Esta es la clase con la que se hace interaccion con la tabla tb_usuarios de la base de datos.
 */

package DAO;

import VO.*;
import java.util.*;
import Interfaces.DAO_Usuarios;
import Utilidades.BD_Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_UsuarioImpl extends BD_Conexion implements DAO_Usuarios {
    
    private VO_RolUsuario voRol;
    private VO_Usuario usuario;
    private DAO_RolUsuarioImpl daoRol = new DAO_RolUsuarioImpl();

    @Override
    public LinkedList<VO_Usuario> getAllUsuarios() {
        
        VO_RolUsuario rol = null;
        VO_Usuario user = null;
        LinkedList<VO_Usuario> usuarios = new LinkedList<VO_Usuario>();
        this.conectar();
        this.sql = "SELECT * FROM tb_usuarios";
        this.res = this.select(sql);
        if(res != null){
            try {
                while(res.next()){
                    rol = this.daoRol.getRolUsuario(res.getString("rol_id"));
                    user = new VO_Usuario(this.res.getString("usu_id"), this.res.getString("usu_nombres"), 
                                                this.res.getString("usu_apellidos"), this.res.getString("usu_nickname"), 
                                                this.res.getString("usu_password"), this.res.getInt("usu_estado"), rol);
                    usuarios.add(user);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 8: " + ex.getMessage(), "ERROR 8", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return usuarios;                
    }

    @Override
    public LinkedList<VO_Usuario> getUsuarios(String condicion) {
        
        VO_RolUsuario rol = null;
        VO_Usuario user = null;
         LinkedList<VO_Usuario> usuarios = new LinkedList<VO_Usuario>();
         this.sql = "SELECT * FROM tb_usuarios WHERE " + condicion;
         this.conectar();
         this.res = this.select(sql);
         if(this.res != null){
             try {
                 while(this.res.next()){
                    rol = this.daoRol.getRolUsuario(this.res.getString("rol_id"));
                    user = new VO_Usuario(this.res.getString("usu_id"), this.res.getString("usu_nombres"),
                             this.res.getString("usu_apellidos"), this.res.getString("usu_nickname"),
                             this.res.getString("usu_password"), this.res.getInt("usu_estado"), rol); 
                     usuarios.add(user);
                 }
                 this.res.close();
                 this.st.close();
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "ERROR 8: " + ex.getMessage(), "ERROR 8", JOptionPane.ERROR_MESSAGE);
                 Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
             finally{
                 try {
                     this.desconectar();
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                     Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
                 
        return usuarios;
    }

    @Override
    public VO_Usuario getUsuarioID(String id) {
        
        VO_RolUsuario rol = null;
        VO_Usuario user = null;    
        this.conectar();
        this.sql = "SELECT * FROM tb_usuarios WHERE usu_id = " + id;
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    rol = this.daoRol.getRolUsuario(this.res.getString("rol_id"));
                    user = new VO_Usuario(this.res.getString("usu_id"), this.res.getString("usu_nombres"),
                             this.res.getString("usu_apellidos"), this.res.getString("usu_nickname"),
                             this.res.getString("usu_password"), this.res.getInt("usu_estado"), rol); 
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 8: " + ex.getMessage(), "ERROR 8", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return user;
    }

    @Override
    public VO_Usuario getUsuarioNamePass(String nickName, String password) {
        
        VO_RolUsuario rol = null;
        VO_Usuario user = null;        
        this.conectar();
        this.sql = "SELECT * FROM tb_usuarios WHERE usu_nickname = '" + nickName + "' AND usu_password = '" + password +  "'";
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    rol = this.daoRol.getRolUsuario(this.res.getString("rol_id"));
                    
                    user = new VO_Usuario(this.res.getString("usu_id"), this.res.getString("usu_nombres"),
                             this.res.getString("usu_apellidos"), this.res.getString("usu_nickname"),
                             this.res.getString("usu_password"), this.res.getInt("usu_estado"), rol); 
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 8: " + ex.getMessage(), "ERROR 8", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return user;
    }

    @Override
    public VO_Usuario getUsuario(String condicion) {
        
        VO_RolUsuario rol = null;
        VO_Usuario user = null;
        this.conectar();
        this.sql = "SELECT * FROM tb_usuarios WHERE " + condicion;
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    rol = this.daoRol.getRolUsuario(this.res.getString("rol_id"));
                    
                    user = new VO_Usuario(this.res.getString("usu_id"), this.res.getString("usu_nombres"),
                             this.res.getString("usu_apellidos"), this.res.getString("usu_nickname"),
                             this.res.getString("usu_password"), this.res.getInt("usu_estado"), rol); 
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 8: " + ex.getMessage(), "ERROR 8", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return user;
        
    }

    @Override
    public boolean crearUsuario(VO_Usuario usuarioNew) {
    
        this.conectar();
        int flag = 0;
        this.sql = "INSERT INTO tb_usuarios(usu_id, usu_nombres, usu_apellidos, usu_nickname, usu_password, rol_id," +
                   " usu_estado)\n" +
                   "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(usuarioNew.getUsu_id()));
            this.pst.setString(2, usuarioNew.getUsu_nombres());
            this.pst.setString(3, usuarioNew.getUsu_apellidos());
            this.pst.setString(4, usuarioNew.getUsu_nickName());
            this.pst.setString(5, usuarioNew.getUsu_password());
            this.pst.setInt(6, Integer.parseInt(usuarioNew.getRol().getRol_id()));
            this.pst.setInt(7, usuarioNew.getUsu_estado());
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 10: " + ex.getMessage(), "ERROR 10", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (flag != 0) return true;
        
        return false;
        
    }

    @Override
    public boolean modificarUsuario(VO_Usuario usuarioNew) {

        this.conectar();
        int flag = 0;
        this.sql = "UPDATE tb_usuarios\n" +
                   "   SET usu_nombres=?, usu_apellidos=?, usu_nickname=?, usu_password=?, \n" +
                   "       rol_id=?, usu_estado=?\n" +
                   " WHERE usu_id=?";
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setString(7, usuarioNew.getUsu_id());
            this.pst.setString(1, usuarioNew.getUsu_nombres());
            this.pst.setString(2, usuarioNew.getUsu_apellidos());
            this.pst.setString(3, usuarioNew.getUsu_nickName());
            this.pst.setString(4, usuarioNew.getUsu_password());
            this.pst.setInt(5, Integer.parseInt(usuarioNew.getRol().getRol_id()));
            this.pst.setInt(6, usuarioNew.getUsu_estado());
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 11: " + ex.getMessage(), "ERROR 11", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (flag != 0) return true;
        
        return false;
        
    }

    @Override
    public boolean eliminarUsuario(VO_Usuario usuarioNew) {
        
        this.conectar();
        int flag = 0;
        this.sql = "DELETE FROM tb_usuarios\n" +
                   " WHERE usu_id = ?";
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(usuarioNew.getUsu_id()));
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 12: " + ex.getMessage(), "ERROR 12", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (flag != 0) return true;
        
        return false;
    }
    
}
