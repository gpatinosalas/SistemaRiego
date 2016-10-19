/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.*;
import VO.*;
import Interfaces.DAO_Lote;
import Utilidades.BD_Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_LoteImpl extends BD_Conexion implements DAO_Lote{

    private VO_Lote voLote;
    
    @Override
    public LinkedList<VO_Lote> getAllLotes() {
        
        LinkedList<VO_Lote> lotes = new LinkedList<VO_Lote>();
        this.sql = "SELECT * FROM tb_lotes";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    this.voLote = new VO_Lote(this.res.getString("lot_id"), this.res.getString("lot_nombre"), this.res.getDouble("lot_ancho"),
                            this.res.getDouble("lot_largo"), this.res.getInt("lot_estado"), this.res.getString("lot_identifier"));
                    lotes.add(voLote);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 28: " + ex.getMessage(), "ERROR 28", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return lotes;
        
    }

    @Override
    public LinkedList<VO_Lote> getLostes(String condicion) {
        
        LinkedList<VO_Lote> lotes = new LinkedList<VO_Lote>();
        this.sql = "SELECT * FROM tb_lotes WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    this.voLote = new VO_Lote(this.res.getString("lot_id"), this.res.getString("lot_nombre"), this.res.getDouble("lot_ancho"),
                            this.res.getDouble("lot_largo"), this.res.getInt("lot_estado"), this.res.getString("lot_identifier"));
                    lotes.add(voLote);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 29: " + ex.getMessage(), "ERROR 29", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return lotes;
    }

    @Override
    public VO_Lote getLote(String condicion) {
        
        this.sql = "SELECT * FROM tb_lotes WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    this.voLote = new VO_Lote(this.res.getString("lot_id"), this.res.getString("lot_nombre"), this.res.getDouble("lot_ancho"),
                            this.res.getDouble("lot_largo"), this.res.getInt("lot_estado"), this.res.getString("lot_identifier"));
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 30: " + ex.getMessage(), "ERROR 30", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return this.voLote;
    }

    @Override
    public boolean crearLote(VO_Lote lote) {
        
        this.sql = "INSERT INTO tb_lotes(\n" +
                   "            lod_nombre, lot_ancho, lot_largo, lot_estado, lot_identifier)\n" +
                   "    VALUES (?, ?, ?, ?, ?)";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            //this.pst.setInt(1, Integer.parseInt(lote.getLot_id()));
            this.pst.setString(1, lote.getLot_nombre());
            this.pst.setDouble(2, lote.getLot_ancho());
            this.pst.setDouble(3, lote.getLot_largo());
            this.pst.setInt(4, lote.getLot_estado());
            this.pst.setString(5, lote.getLot_identifier());
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 31: " + ex.getMessage(), "ERROR 31", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }

    @Override
    public boolean modificarLote(VO_Lote lote) {
        
        this.sql = "UPDATE tb_lotes\n" +
                   "   SET lod_nombre=?, lot_ancho=?, lot_largo=?, lot_estado=?, \n" +
                   "       lot_identifier=?\n" +
                   " WHERE lot_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(6, Integer.parseInt(lote.getLot_id()));
            this.pst.setString(1, lote.getLot_nombre());
            this.pst.setDouble(2, lote.getLot_ancho());
            this.pst.setDouble(3, lote.getLot_largo());
            this.pst.setInt(4, lote.getLot_estado());
            this.pst.setString(5, lote.getLot_identifier());
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 32: " + ex.getMessage(), "ERROR 32", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }

    @Override
    public boolean eliminarLote(VO_Lote lote) {
        
        this.sql = "DELETE FROM tb_lotes\n" +
                   " WHERE lot_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(lote.getLot_id()));
                        
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 33: " + ex.getMessage(), "ERROR 33", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_LoteImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }
    
}
