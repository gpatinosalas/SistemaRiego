/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.*;
import VO.*;
import Interfaces.DAO_Sistema;
import Utilidades.BD_Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_SistemaImpl extends BD_Conexion implements DAO_Sistema {

    private VO_Sistema voSistema;
    
    @Override
    public LinkedList<VO_Sistema> getAllSistemas() {
        
        LinkedList<VO_Sistema> sistemas = new LinkedList<VO_Sistema>();
        this.sql = "SELECT * FROM tb_sistema";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try{            
                while(this.res.next()){
                    voSistema = new VO_Sistema(this.res.getString("sis_id"), this.res.getString("sis_nombre"));
                    sistemas.add(voSistema);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 22: " + ex.getMessage(), "ERROR 22", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9 ", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return sistemas;
        
    }

    @Override
    public LinkedList<VO_Sistema> getSistemas(String condicion) {
        
        LinkedList<VO_Sistema> sistemas = new LinkedList<VO_Sistema>();
        this.sql = "SELECT * FROM tb_sistema WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try{            
                while(this.res.next()){
                    voSistema = new VO_Sistema(this.res.getString("sis_id"), this.res.getString("sis_nombre"));
                    sistemas.add(voSistema);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 23: " + ex.getMessage(), "ERROR 23", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9 ", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return sistemas;
    }

    @Override
    public VO_Sistema getSistema(String condicion) {
        
        this.sql = "SELECT * FROM tb_sistema WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try{            
                if(this.res.next()){
                    voSistema = new VO_Sistema(this.res.getString("sis_id"), this.res.getString("sis_nombre"));
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 24: " + ex.getMessage(), "ERROR 24", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9 ", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return this.voSistema;
    }

    @Override
    public boolean creaSistema(VO_Sistema sistema) {
        
        this.sql = "INSERT INTO tb_sistema(\n" +
                   "            sis_nombre)\n" +
                   "    VALUES (?)";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            //this.pst.setInt(1, Integer.parseInt(sistema.getSis_id()));
            this.pst.setString(1, sistema.getSis_nombre());
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 25: " + ex.getMessage(), "ERROR 25", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;        
    }

    @Override
    public boolean modificarSistema(VO_Sistema sistema) {
        
        this.sql = "UPDATE tb_sistema\n" +
                   "   SET sis_nombre=?\n" +
                   " WHERE sis_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(2, Integer.parseInt(sistema.getSis_id()));
            this.pst.setString(1, sistema.getSis_nombre());
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 26: " + ex.getMessage(), "ERROR 26", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }

    @Override
    public boolean eliminarSistema(VO_Sistema sistema) {
        
        this.sql = "DELETE FROM tb_sistema\n" +
                   " WHERE sis_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(sistema.getSis_id()));
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 27: " + ex.getMessage(), "ERROR 27", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_SistemaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }
    
}
