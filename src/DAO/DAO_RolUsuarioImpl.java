/*
 * Esta es la clase que interactua con la tabla tb_rolusuarios de la base de datos.
 */

package DAO;

import java.util.*;
import VO.*;
import Interfaces.DAO_RolUsuario;
import Utilidades.BD_Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_RolUsuarioImpl extends BD_Conexion implements DAO_RolUsuario{
    
    private VO_RolUsuario voRol;

    @Override
    public LinkedList<VO_RolUsuario> getAllRolUsuario() {
        
        LinkedList<VO_RolUsuario> roles = new LinkedList<VO_RolUsuario>();
        this.sql = "SELECT * FROM tb_rolusuarios";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    voRol = new VO_RolUsuario(this.res.getString("rol_id"), this.res.getString("rol_nombre"));
                    roles.add(voRol);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 13: " + ex.getMessage(), "ERROR 13" , JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9" , JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return roles;
    }

    @Override
    public VO_RolUsuario getRolUsuario(String rol_id) {
    
        VO_RolUsuario rol = null;
        this.sql = "SELECT * FROM tb_rolusuarios WHERE rol_id = " + rol_id;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    rol = new VO_RolUsuario(this.res.getString("rol_id"), this.res.getString("rol_nombre"));
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 14: " + ex.getMessage(), "ERROR 14" , JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9" , JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return rol;
    }

    @Override
    public boolean crearRolUsuario(VO_RolUsuario rol) {
    
        this.sql = "INSERT INTO tb_rolusuarios(\n" +
                   "            rol_nombre)\n" +
                   "    VALUES (?);";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            //this.pst.setInt(1, Integer.parseInt(rol.getRol_id()));
            this.pst.setString(1, rol.getRol_nombre());
            flag = this.pst.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 15: " + ex.getMessage(), "ERROR 15", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(flag != 0)
            return true;
        
        return false;    
    }

    @Override
    public boolean modificarRolUsuario(VO_RolUsuario rol) {
        
        this.sql = "UPDATE tb_rolusuarios\n" +
                   "   SET rol_nombre=?\n" +
                   " WHERE rol id = ?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(2, Integer.parseInt(rol.getRol_id()));
            this.pst.setString(1, rol.getRol_nombre());
            flag = this.pst.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 16: " + ex.getMessage(), "ERROR 16", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(flag != 0)
            return true;
        
        return false;   
    }

    @Override
    public boolean elimnarRolUsuario(VO_RolUsuario rol) {
        
        this.sql = "DELETE FROM tb_rolusuarios\n" +
                   " WHERE rol_id = ?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(rol.getRol_id()));
            flag = this.pst.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 17: " + ex.getMessage(), "ERROR 17", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_RolUsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(flag != 0)
            return true;
        
        return false;     
    
    }
    
    
    
}
