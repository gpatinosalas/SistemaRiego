/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.*;
import VO.*;
import Interfaces.DAO_Cultivo;
import Utilidades.BD_Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class DAO_CultivoImpl extends BD_Conexion implements DAO_Cultivo{
    
    private DAO_SistemaImpl daoSistema = new DAO_SistemaImpl();
    private VO_Sistema voSistema;
    private VO_Cultivo voCultivo;

    @Override
    public LinkedList<VO_Cultivo> getAllCultivos() {
        
        LinkedList<VO_Cultivo> cultivos = new LinkedList<VO_Cultivo>();
        this.sql = "SELECT * FROM tb_cultivo";
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voSistema = this.daoSistema.getSistema("sis_id = " + this.res.getString("sis_id"));
                    
                    this.voCultivo = new VO_Cultivo(this.res.getString("cul_id"), this.res.getString("cul_nombre"), this.res.getInt("cul_tiempo"),
                                    this.res.getFloat("cul_humedadsd"), this.res.getFloat("cul_humedadrd"), this.res.getFloat("cul_temperaturad"),
                                    this.res.getFloat("cul_phd"), this.res.getInt("cul_diasd"), this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), 
                                    this.res.getFloat("cul_temperaturafl"), this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), 
                                    this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), this.res.getFloat("cul_temperaturafl"), 
                                    this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), this.voSistema);
                    cultivos.add(voCultivo);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 17: " + ex.getMessage(), "ERROR 17", JOptionPane.ERROR_MESSAGE);
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
        
        return cultivos;
    }

    @Override
    public LinkedList<VO_Cultivo> getCultivos(String condicion) {
        
        LinkedList<VO_Cultivo> cultivos = new LinkedList<VO_Cultivo>();
        this.sql = "SELECT * FROM tb_cultivo WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                while(this.res.next()){
                    
                    this.voSistema = this.daoSistema.getSistema("sis_id = " + this.res.getString("sis_id"));
                    
                    this.voCultivo = new VO_Cultivo(this.res.getString("cul_id"), this.res.getString("cul_nombre"), this.res.getInt("cul_tiempo"),
                                    this.res.getFloat("cul_humedadsd"), this.res.getFloat("cul_humedadrd"), this.res.getFloat("cul_temperaturad"),
                                    this.res.getFloat("cul_phd"), this.res.getInt("cul_diasd"), this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), 
                                    this.res.getFloat("cul_temperaturafl"), this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), 
                                    this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), this.res.getFloat("cul_temperaturafl"), 
                                    this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), this.voSistema);
                    cultivos.add(voCultivo);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 18: " + ex.getMessage(), "ERROR 18", JOptionPane.ERROR_MESSAGE);
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
        
        return cultivos;
    }

    @Override
    public VO_Cultivo getCultivo(String condicion) {
        
        this.sql = "SELECT * FROM tb_cultivon WHERE " + condicion;
        this.conectar();
        this.res = this.select(sql);
        if(this.res != null){
            try {
                if(this.res.next()){
                    
                    this.voSistema = this.daoSistema.getSistema("sis_id = " + this.res.getString("sis_id"));
                    
                    this.voCultivo = new VO_Cultivo(this.res.getString("cul_id"), this.res.getString("cul_nombre"), this.res.getInt("cul_tiempo"),
                                    this.res.getFloat("cul_humedadsd"), this.res.getFloat("cul_humedadrd"), this.res.getFloat("cul_temperaturad"),
                                    this.res.getFloat("cul_phd"), this.res.getInt("cul_diasd"), this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), 
                                    this.res.getFloat("cul_temperaturafl"), this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), 
                                    this.res.getFloat("cul_humedadsfl"), this.res.getFloat("cul_humedadrfl"), this.res.getFloat("cul_temperaturafl"), 
                                    this.res.getFloat("cul_phfl"), this.res.getInt("cul_diasfl"), this.voSistema);                    
                }
                this.res.close();
                this.st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 19: " + ex.getMessage(), "ERROR 19", JOptionPane.ERROR_MESSAGE);
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
        
        return this.voCultivo;
    }

    @Override
    public boolean crearCultivo(VO_Cultivo cultivo) {
        
        this.sql = "INSERT INTO tb_cultivo(\n" +
                   "            cul_nombre, cul_humedadsd, cul_temperaturad, cul_phd, cul_tiempo, \n" +
                   "            cul_diasd, cul_diasfl, cul_humedadsfl, cul_humedadrfl, \n" +
                   "            cul_temperaturafl, cul_phfl, cul_diasfr, cul_humedadsfr, cul_humedadrfr, \n" +
                   "            cul_temperaturafr, cul_phfr, cul_humedadrd, sis_id)\n" +
                   "    VALUES (?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?, ?, \n" +
                   "            ?, ?, ?, ?)";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setString(1, cultivo.getCul_nombre());
            this.pst.setFloat(2, cultivo.getHumedadsd());
            this.pst.setFloat(3, cultivo.getTemperaturad());
            this.pst.setFloat(4, cultivo.getCul_phd());
            this.pst.setInt(5, cultivo.getCul_tiempo());
            this.pst.setInt(6, cultivo.getCul_diasd());
            this.pst.setInt(7, cultivo.getCul_diasfl());
            this.pst.setFloat(8, cultivo.getHumedadsfl());
            this.pst.setFloat(9, cultivo.getHumedadrfl());
            this.pst.setFloat(10, cultivo.getTemperaturafl());
            this.pst.setFloat(11, cultivo.getCul_phfl());
            this.pst.setInt(12, cultivo.getCul_diasfr());
            this.pst.setFloat(13, cultivo.getHumedadsfr());
            this.pst.setFloat(14, cultivo.getHumedadrfr());
            this.pst.setFloat(15, cultivo.getTemperaturafr());
            this.pst.setFloat(16, cultivo.getCul_phfr());
            this.pst.setFloat(17, cultivo.getHumedadrd());
            this.pst.setInt(18, Integer.parseInt(cultivo.getCul_sis().getSis_id()));
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 20: " + ex.getMessage(), "ERROR 20", JOptionPane.ERROR_MESSAGE);
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
    public boolean modificarCultivo(VO_Cultivo cultivo) {
        
        this.sql = "UPDATE tb_cultivo\n" +
                   "   SET cul_nombre=?, cul_humedadsd=?, cul_temperaturad=?, cul_phd=?, \n" +
                   "       cul_tiempo=?, cul_diasd=?, cul_diasfl=?, cul_humedadsfl=?, \n" +
                   "       cul_humedadrfl=?, cul_temperaturafl=?, cul_phfl=?, cul_diasfr=?, \n" +
                   "       cul_humedadsfr=?, cul_humedadrfr=?, cul_temperaturafr=?, cul_phfr=?, \n" +
                   "       cul_humedadrd=?, sis_id=?\n" +
                   " WHERE cul_id = ?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setString(1, cultivo.getCul_nombre());
            this.pst.setFloat(2, cultivo.getHumedadsd());
            this.pst.setFloat(3, cultivo.getTemperaturad());
            this.pst.setFloat(4, cultivo.getCul_phd());
            this.pst.setInt(5, cultivo.getCul_tiempo());
            this.pst.setInt(6, cultivo.getCul_diasd());
            this.pst.setInt(7, cultivo.getCul_diasfl());
            this.pst.setFloat(8, cultivo.getHumedadsfl());
            this.pst.setFloat(9, cultivo.getHumedadrfl());
            this.pst.setFloat(10, cultivo.getTemperaturafl());
            this.pst.setFloat(11, cultivo.getCul_phfl());
            this.pst.setInt(12, cultivo.getCul_diasfr());
            this.pst.setFloat(13, cultivo.getHumedadsfr());
            this.pst.setFloat(14, cultivo.getHumedadrfr());
            this.pst.setFloat(15, cultivo.getTemperaturafr());
            this.pst.setFloat(16, cultivo.getCul_phfr());
            this.pst.setFloat(17, cultivo.getHumedadrd());
            this.pst.setInt(18, Integer.parseInt(cultivo.getCul_id()));
            this.pst.setInt(18, Integer.parseInt(cultivo.getCul_sis().getSis_id()));
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERR0R 21: " + ex.getMessage(), "ERROR 21", JOptionPane.ERROR_MESSAGE);
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
    public boolean eliminarCultivo(VO_Cultivo cultivo) {
        
        this.sql = "DELETE FROM tb_cultivo\n" +
                   " WHERE cul_id = ?";
        int flag = 0;
        this.conectar();
        try {
            this.pst = this.bdConexion.prepareStatement(sql);
            this.pst.setInt(1, Integer.parseInt(cultivo.getCul_id()));
            
            flag = this.pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 21: " + ex.getMessage(), "ERROR 21", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                this.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR 21: " + ex.getMessage(), "ERROR 21", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(DAO_CultivoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(flag != 0)
            return true;
        
        return false;
        
    }
    
}
