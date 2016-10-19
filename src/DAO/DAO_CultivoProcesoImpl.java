/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Interfaces.DAO_CultivoProceso;
import Utilidades.BD_Conexion;
import VO.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_CultivoProcesoImpl extends BD_Conexion implements DAO_CultivoProceso{
    
    private VO_Cultivo voCultivo;
    private VO_Lote voLote;
    private VO_Usuario voUsuario;
    private VO_CultivoProceso voCultivoProceso;
    private DAO_CultivoImpl daoCultivo = new DAO_CultivoImpl();
    private DAO_LoteImpl daoLote = new DAO_LoteImpl();
    private DAO_UsuarioImpl daoUsuario = new DAO_UsuarioImpl();

    @Override
    public LinkedList<VO_CultivoProceso> getAllCultivoProcesos() {
        
        LinkedList<VO_CultivoProceso> cultivosProcesos = new LinkedList<VO_CultivoProceso>();
        this.sql = "SELECT * FROM tb_cultivoproceso";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voCultivo = this.daoCultivo.getCultivo("cul_id=" + this.res.getString("cul_id"));
                    this.voLote = this.daoLote.getLote("lot_id = " + this.res.getString("lot_id"));
                    this.voUsuario = this.daoUsuario.getUsuarioID(this.res.getString("usu_id"));
                                        
                    this.voCultivoProceso = new VO_CultivoProceso(this.res.getString("cp_id"), this.res.getString("cp_fechainicio"),
                                            this.res.getString("cp_horainicio"), this.res.getInt("cp_estado"), this.voCultivo, this.voLote, this.voUsuario);
                    cultivosProcesos.add(voCultivoProceso);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 34: " + ex.getMessage(), "ERROR 34", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return cultivosProcesos;
    }

    @Override
    public LinkedList<VO_CultivoProceso> getCultivoProcesos(String condicion) {
        
        LinkedList<VO_CultivoProceso> cultivosProcesos = new LinkedList<VO_CultivoProceso>();
        this.sql = "SELECT * FROM tb_cultivoproceso WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voCultivo = this.daoCultivo.getCultivo("cul_id=" + this.res.getString("cul_id"));
                    this.voLote = this.daoLote.getLote("lot_id = " + this.res.getString("lot_id"));
                    this.voUsuario = this.daoUsuario.getUsuarioID(this.res.getString("usu_id"));
                                        
                    this.voCultivoProceso = new VO_CultivoProceso(this.res.getString("cp_id"), this.res.getString("cp_fechainicio"),
                                            this.res.getString("cp_horainicio"), this.res.getInt("cp_estado"), this.voCultivo, this.voLote, this.voUsuario);
                    cultivosProcesos.add(voCultivoProceso);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 35: " + ex.getMessage(), "ERROR 35", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return cultivosProcesos;
    }

    @Override
    public LinkedList<VO_CultivoProceso> getCultivoProcesosActivos() {
        
        LinkedList<VO_CultivoProceso> cultivosProcesos = new LinkedList<VO_CultivoProceso>();
        this.sql = "SELECT * FROM tb_cultivoproceso WHERE cd_estado = 1";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voCultivo = this.daoCultivo.getCultivo("cul_id=" + this.res.getString("cul_id"));
                    this.voLote = this.daoLote.getLote("lot_id = " + this.res.getString("lot_id"));
                    this.voUsuario = this.daoUsuario.getUsuarioID(this.res.getString("usu_id"));
                                        
                    this.voCultivoProceso = new VO_CultivoProceso(this.res.getString("cp_id"), this.res.getString("cp_fechainicio"),
                                            this.res.getString("cp_horainicio"), this.res.getInt("cp_estado"), this.voCultivo, this.voLote, this.voUsuario);
                    cultivosProcesos.add(voCultivoProceso);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 36: " + ex.getMessage(), "ERROR 36", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return cultivosProcesos;
    }

    @Override
    public VO_CultivoProceso getCultivoProceso(String condicion) {
        
        this.sql = "SELECT * FROM tb_cultivoproceso WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    
                    this.voCultivo = this.daoCultivo.getCultivo("cul_id=" + this.res.getString("cul_id"));
                    this.voLote = this.daoLote.getLote("lot_id = " + this.res.getString("lot_id"));
                    this.voUsuario = this.daoUsuario.getUsuarioID(this.res.getString("usu_id"));
                                        
                    this.voCultivoProceso = new VO_CultivoProceso(this.res.getString("cp_id"), this.res.getString("cp_fechainicio"),
                                            this.res.getString("cp_horainicio"), this.res.getInt("cp_estado"), this.voCultivo, this.voLote, this.voUsuario);                   
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 37: " + ex.getMessage(), "ERROR 37", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return this.voCultivoProceso;
    }

    @Override
    public VO_CultivoProceso getLastCultivoProceso() {
        
        this.sql = "SELECT * FROM tb_cultivoproceso WHERE cp_id = (SELECT MAX(cp_id) FROM tb_cultivoproceso)";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    
                    this.voCultivo = this.daoCultivo.getCultivo("cul_id=" + this.res.getString("cul_id"));
                    this.voLote = this.daoLote.getLote("lot_id = " + this.res.getString("lot_id"));
                    this.voUsuario = this.daoUsuario.getUsuarioID(this.res.getString("usu_id"));
                                        
                    this.voCultivoProceso = new VO_CultivoProceso(this.res.getString("cp_id"), this.res.getString("cp_fechainicio"),
                                            this.res.getString("cp_horainicio"), this.res.getInt("cp_estado"), this.voCultivo, this.voLote, this.voUsuario);
                                        
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 38: " + ex.getMessage(), "ERROR 38", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else return null;
        
        return this.voCultivoProceso;
    }

    @Override
    public boolean crearCultivoProceso(VO_CultivoProceso cultivoProceso) {
        
        this.sql = "INSERT INTO tb_cultivoproceso(\n" +
                   "            cul_id, lot_id, usu_id, cp_fechaincio, cp_horainicio, \n" +
                   "            cp_estado)\n" +
                   "    VALUES (?, ?, ?, ?, ?, \n" +
                   "            ?)";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(cultivoProceso.getCp_cultivo().getCul_id()));
            this.pst.setInt(2, Integer.parseInt(cultivoProceso.getCp_lote().getLot_id()));
            this.pst.setInt(3, Integer.parseInt(cultivoProceso.getCp_usuario().getUsu_id()));
            this.pst.setString(4, cultivoProceso.getCp_fechainicio());
            this.pst.setString(5, cultivoProceso.getCp_horainicio());
            this.pst.setInt(6, cultivoProceso.getCp_estado());
                        
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 39: " + ex.getMessage(), "ERROR 39", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERR0R 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }

    @Override
    public boolean modificarCultivoProceso(VO_CultivoProceso cultivoProceso) {
        
        this.sql = "UPDATE tb_cultivoproceso\n" +
                   "   SET cul_id=?, lot_id=?, usu_id=?, cp_fechaincio=?, cp_horainicio=?, \n" +
                   "       cp_estado=?\n" +
                   " WHERE cp_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(cultivoProceso.getCp_cultivo().getCul_id()));
            this.pst.setInt(2, Integer.parseInt(cultivoProceso.getCp_lote().getLot_id()));
            this.pst.setInt(3, Integer.parseInt(cultivoProceso.getCp_usuario().getUsu_id()));
            this.pst.setString(4, cultivoProceso.getCp_fechainicio());
            this.pst.setString(5, cultivoProceso.getCp_horainicio());
            this.pst.setInt(6, cultivoProceso.getCp_estado());
            this.pst.setInt(7, Integer.parseInt(cultivoProceso.getCp_id()));
                        
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 40: " + ex.getMessage(), "ERROR 40", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERR0R 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }

    @Override
    public boolean eliminarCultivoProceso(VO_CultivoProceso cultivoProceso) {
        
        this.sql = "DELETE FROM tb_cultivoproceso\n" +
                   " WHERE cp_id=?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(cultivoProceso.getCp_id()));
                        
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 41: " + ex.getMessage(), "ERROR 41", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERR0R 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
    }
    
}
