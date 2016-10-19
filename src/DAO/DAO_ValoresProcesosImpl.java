/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Interfaces.DAO_ValoresProceso;
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
public class DAO_ValoresProcesosImpl extends BD_Conexion implements DAO_ValoresProceso{

    private VO_CultivoProceso voCultivoProceso;
    private VO_ValoresProceso voValores;
    private DAO_CultivoProcesoImpl daoCultivoProceso = new DAO_CultivoProcesoImpl();
    
    @Override
    public LinkedList<VO_ValoresProceso> getAllValoresProceso(VO_CultivoProceso cultivoProceso) {
        
        LinkedList<VO_ValoresProceso> valoresProceso = new LinkedList<VO_ValoresProceso>();
        this.sql = "SELECT * FROM tb_valoresproceso WHERE cp_id = " + cultivoProceso.getCp_id();
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voValores = new VO_ValoresProceso(this.res.getString("vc_id"), this.res.getString("vc_fecha"), res.getString("vc_hora"),
                            this.res.getFloat("vc_humedad1"), this.res.getFloat("vc_humedad2"), this.res.getFloat("vc_humedad3"),
                            this.res.getFloat("vc_humedad4"), this.res.getFloat("vc_humedad5"), this.res.getFloat("vc_humedad6"),
                            this.res.getFloat("vc_temperatura1"), this.res.getFloat("vc_temperatura2"), this.res.getFloat("vc_temperatura3"),
                            this.res.getFloat("vc_temperatura4"), this.res.getFloat("vc_temperatura5"), this.res.getFloat("vc_temperatura6"),
                            this.res.getFloat("vc_ph"), this.res.getInt("vc_estadovalvula"), this.res.getInt("vc_estadobomba"), cultivoProceso);
                    valoresProceso.add(this.voValores);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 42: " + ex.getMessage(), "ERROR 42", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return valoresProceso;
    }

    @Override
    public LinkedList<VO_ValoresProceso> getValoresProceso(String condicion) {
        
        LinkedList<VO_ValoresProceso> valoresProceso = new LinkedList<VO_ValoresProceso>();
        this.sql = "SELECT * FROM tb_valoresproceso WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    this.voCultivoProceso = this.daoCultivoProceso.getCultivoProceso("cp_id = " + this.res.getString("cp_id"));
                    this.voValores = new VO_ValoresProceso(this.res.getString("vc_id"), this.res.getString("vc_fecha"), res.getString("vc_hora"),
                            this.res.getFloat("vc_humedad1"), this.res.getFloat("vc_humedad2"), this.res.getFloat("vc_humedad3"),
                            this.res.getFloat("vc_humedad4"), this.res.getFloat("vc_humedad5"), this.res.getFloat("vc_humedad6"),
                            this.res.getFloat("vc_temperatura1"), this.res.getFloat("vc_temperatura2"), this.res.getFloat("vc_temperatura3"),
                            this.res.getFloat("vc_temperatura4"), this.res.getFloat("vc_temperatura5"), this.res.getFloat("vc_temperatura6"),
                            this.res.getFloat("vc_ph"), this.res.getInt("vc_estadovalvula"), this.res.getInt("vc_estadobomba"), this.voCultivoProceso);
                    valoresProceso.add(this.voValores);
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 43: " + ex.getMessage(), "ERROR 43", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return valoresProceso;
    }

    @Override
    public VO_ValoresProceso getValorProceso(VO_CultivoProceso cultivoProceso, String condicion) {
        
        this.sql = "SELECT * FROM tb_valoresproceso WHERE cp_id = " + cultivoProceso.getCp_id() + " AND " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voValores = new VO_ValoresProceso(this.res.getString("vc_id"), this.res.getString("vc_fecha"), res.getString("vc_hora"),
                            this.res.getFloat("vc_humedad1"), this.res.getFloat("vc_humedad2"), this.res.getFloat("vc_humedad3"),
                            this.res.getFloat("vc_humedad4"), this.res.getFloat("vc_humedad5"), this.res.getFloat("vc_humedad6"),
                            this.res.getFloat("vc_temperatura1"), this.res.getFloat("vc_temperatura2"), this.res.getFloat("vc_temperatura3"),
                            this.res.getFloat("vc_temperatura4"), this.res.getFloat("vc_temperatura5"), this.res.getFloat("vc_temperatura6"),
                            this.res.getFloat("vc_ph"), this.res.getInt("vc_estadovalvula"), this.res.getInt("vc_estadobomba"), cultivoProceso);
                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 44: " + ex.getMessage(), "ERROR 44", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return this.voValores;
    }

    @Override
    public VO_ValoresProceso getLastValorProceso(VO_CultivoProceso cultivoProceso) {
        
        this.sql = "SELECT * FROM tb_valoresproceso WHERE cp_id = " + cultivoProceso.getCp_id() + " AND vc_id = (SELECT MAX(vc_id) FROM tb_valoresproceso WHERE cp_id = " + cultivoProceso.getCp_id() + ")";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voValores = new VO_ValoresProceso(this.res.getString("vc_id"), this.res.getString("vc_fecha"), res.getString("vc_hora"),
                            this.res.getFloat("vc_humedad1"), this.res.getFloat("vc_humedad2"), this.res.getFloat("vc_humedad3"),
                            this.res.getFloat("vc_humedad4"), this.res.getFloat("vc_humedad5"), this.res.getFloat("vc_humedad6"),
                            this.res.getFloat("vc_temperatura1"), this.res.getFloat("vc_temperatura2"), this.res.getFloat("vc_temperatura3"),
                            this.res.getFloat("vc_temperatura4"), this.res.getFloat("vc_temperatura5"), this.res.getFloat("vc_temperatura6"),
                            this.res.getFloat("vc_ph"), this.res.getInt("vc_estadovalvula"), this.res.getInt("vc_estadobomba"), cultivoProceso);
                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 45: " + ex.getMessage(), "ERROR 45", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try {
                    this.desconectar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR 9: " + ex.getMessage(), "ERROR 9", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DAO_ValoresProcesosImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            return null;
        
        return this.voValores;
    }

    @Override
    public boolean crearValorProceso(VO_ValoresProceso valorProceso) {
        
        this.sql = "INSERT INTO tb_valoresproceso(\n" +
                   "            cp_id, vc_humedad1, vc_humedad2, vc_humedad3, vc_humedad4, \n" +
                   "            vc_humedads5, vc_humedads6, vc_temperatura1, vc_temperatura2, \n" +
                   "            vc_temperatura3, vc_temperatura4, vc_temperatura5, vc_temperatura6, \n" +
                   "            vc_estadovalvula, vc_estadobomba, vc_ph, vc_fecha, vc_hora)\n" +
                   "    VALUES (?, ?, ?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?)";
        int flag = 0;
        this.conectar();
        try {
            
            this.pst = this.bdConexion.prepareStatement(sql);
            
            this.pst.setInt(1, Integer.parseInt(valorProceso.getVc_cultivoproceso().getCp_id()));
            this.pst.setFloat(2, valorProceso.getVc_humedad1());
            this.pst.setFloat(3, valorProceso.getVc_humedad2());
            this.pst.setFloat(4, valorProceso.getVc_humedad3());
            this.pst.setFloat(5, valorProceso.getVc_humedad4());
            this.pst.setFloat(6, valorProceso.getVc_humedad5());
            this.pst.setFloat(7, valorProceso.getVc_humedad6());
            this.pst.setFloat(8, valorProceso.getVc_temperatura1());
            this.pst.setFloat(9, valorProceso.getVc_temperatura2());
            this.pst.setFloat(10, valorProceso.getVc_temperatura3());
            this.pst.setFloat(11, valorProceso.getVc_temperatura4());
            this.pst.setFloat(12, valorProceso.getVc_temperatura5());
            this.pst.setFloat(13, valorProceso.getVc_temperatura6());            
            this.pst.setInt(14, valorProceso.getVc_estadovalvula());
            this.pst.setInt(15, valorProceso.getVc_estadobomba());
            this.pst.setFloat(16, valorProceso.getVc_ph());
            this.pst.setString(17, valorProceso.getVc_fecha());
            this.pst.setString(18, valorProceso.getVc_hora());
                                    
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 46: " + ex.getMessage(), "ERROR 46", JOptionPane.ERROR_MESSAGE);
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
    public boolean modificarValorProceso(VO_ValoresProceso valorProceso) {
        
        this.sql = "UPDATE tb_valoresproceso\n" +
                   "   SET cp_id=?, vc_humedad1=?, vc_humedad2=?, vc_humedad3=?, \n" +
                   "       vc_humedad4=?, vc_humedads5=?, vc_humedads6=?, vc_temperatura1=?, \n" +
                   "       vc_temperatura2=?, vc_temperatura3=?, vc_temperatura4=?, vc_temperatura5=?, \n" +
                   "       vc_temperatura6=?, vc_estadovalvula=?, vc_estadobomba=?, \n" +
                   "       vc_ph=?, vc_fecha=?, vc_hora=?\n" +
                   " WHERE vc_id=?";
        int flag = 0;
        this.conectar();
        try {
            
            this.pst = this.bdConexion.prepareStatement(sql);
            
            this.pst.setInt(1, Integer.parseInt(valorProceso.getVc_cultivoproceso().getCp_id()));
            this.pst.setFloat(2, valorProceso.getVc_humedad1());
            this.pst.setFloat(3, valorProceso.getVc_humedad2());
            this.pst.setFloat(4, valorProceso.getVc_humedad3());
            this.pst.setFloat(5, valorProceso.getVc_humedad4());
            this.pst.setFloat(6, valorProceso.getVc_humedad5());
            this.pst.setFloat(7, valorProceso.getVc_humedad6());
            this.pst.setFloat(8, valorProceso.getVc_temperatura1());
            this.pst.setFloat(9, valorProceso.getVc_temperatura2());
            this.pst.setFloat(10, valorProceso.getVc_temperatura3());
            this.pst.setFloat(11, valorProceso.getVc_temperatura4());
            this.pst.setFloat(12, valorProceso.getVc_temperatura5());
            this.pst.setFloat(13, valorProceso.getVc_temperatura6());            
            this.pst.setInt(14, valorProceso.getVc_estadovalvula());
            this.pst.setInt(15, valorProceso.getVc_estadobomba());
            this.pst.setFloat(16, valorProceso.getVc_ph());
            this.pst.setString(17, valorProceso.getVc_fecha());
            this.pst.setString(18, valorProceso.getVc_hora());
            this.pst.setInt(19, Integer.parseInt(valorProceso.getVc_id()));
                                    
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 47: " + ex.getMessage(), "ERROR 47", JOptionPane.ERROR_MESSAGE);
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
    public boolean eliminarValorProceso(VO_ValoresProceso valorProceso) {
        
        this.sql = "DELETE FROM tb_valoresproceso\n" +
                   " WHERE vc_id=?";
        int flag = 0;
        this.conectar();
        try {
            
            this.pst = this.bdConexion.prepareStatement(sql);
            
            this.pst.setInt(1, Integer.parseInt(valorProceso.getVc_id()));
                                    
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 48: " + ex.getMessage(), "ERROR 48", JOptionPane.ERROR_MESSAGE);
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
