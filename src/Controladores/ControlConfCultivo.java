/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import VO.*;
import DAO.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class ControlConfCultivo {
    
    private LinkedList<VO_Cultivo> voCultivos = new LinkedList<VO_Cultivo>();
    
    private VO_Cultivo voCultivo;
    private VO_Sistema voSistema;
    
    private DAO_CultivoImpl daoCultivo = new DAO_CultivoImpl();
    private DAO_SistemaImpl daoSistema = new DAO_SistemaImpl();
    
    public ControlConfCultivo(){
        
    }
    
    public boolean validarCamposCult(JTextField txtNombreCultivo, JTextField txtTiempo, JTextField txtDiasd, JTextField txtHumedadsd,
                                    JTextField txtTemperaturad, JTextField txtHumedadrd, JTextField txtphd, JTextField txtDiasfl, 
                                    JTextField txtHumedadsfl, JTextField txtTemperaturafl, JTextField txtHumedadrfl, JTextField txtphfl, 
                                    JTextField txtDiasfr, JTextField txtHumedadsfr, JTextField txtTemperaturafr, JTextField txtHumedadrfr, 
                                    JTextField txtphfr, JComboBox jcbSistemas){
        
        if(!(txtNombreCultivo.getText().isEmpty() || txtTiempo.getText().isEmpty() || txtDiasd.getText().isEmpty() || txtHumedadsd.getText().isEmpty() ||
                txtTemperaturad.getText().isEmpty() || txtHumedadrd.getText().isEmpty() || txtphd.getText().isEmpty() || txtDiasfl.getText().isEmpty() ||
                txtHumedadsfl.getText().isEmpty() || txtTemperaturafl.getText().isEmpty() || txtHumedadrfl.getText().isEmpty() ||
                txtphfl.getText().isEmpty() || txtDiasfr.getText().isEmpty() || txtHumedadsfr.getText().isEmpty() || txtTemperaturafr.getText().isEmpty() ||
                txtHumedadrfr.getText().isEmpty() || txtphfr.getText().isEmpty() || jcbSistemas.getSelectedIndex() == 0)){
            
            return true;
        }
        
        return false;
    }
    
    public boolean ordenCultivo(String cul_id, JTextField txtNombreCultivo, JTextField txtTiempo, JTextField txtDiasd, JTextField txtHumedadsd,
                                    JTextField txtTemperaturad, JTextField txtHumedadrd, JTextField txtphd, JTextField txtDiasfl, 
                                    JTextField txtHumedadsfl, JTextField txtTemperaturafl, JTextField txtHumedadrfl, JTextField txtphfl, 
                                    JTextField txtDiasfr, JTextField txtHumedadsfr, JTextField txtTemperaturafr, JTextField txtHumedadrfr, 
                                    JTextField txtphfr, JComboBox jcbSistemas, int operacion){
        
        this.voSistema = this.daoSistema.getSistema("sis_id = " + jcbSistemas.getSelectedIndex());
        this.voCultivo = new VO_Cultivo(cul_id, txtNombreCultivo.getText(), Integer.parseInt(txtTiempo.getText()), Float.parseFloat(txtHumedadsd.getText()), Float.parseFloat(txtHumedadrd.getText()), 
                                        Float.parseFloat(txtTemperaturad.getText()), Float.parseFloat(txtphd.getText()), Integer.parseInt(txtDiasd.getText()), Float.parseFloat(txtHumedadsfl.getText()), 
                                        Float.parseFloat(txtHumedadrfl.getText()), Float.parseFloat(txtTemperaturafl.getText()), Float.parseFloat(txtphfl.getText()), Integer.parseInt(txtDiasfl.getText()), 
                                        Float.parseFloat(txtHumedadsfr.getText()), Float.parseFloat(txtHumedadrfr.getText()), Float.parseFloat(txtTemperaturafr.getText()), 
                                        Float.parseFloat(txtphfr.getText()), Integer.parseInt(txtDiasfr.getText()), this.voSistema);
        switch(operacion){
            case 1: return this.daoCultivo.crearCultivo(voCultivo);
            
            case 2: return this.daoCultivo.modificarCultivo(voCultivo);
                
            default: break;
        }
        
        return false;
    }
    
    public boolean eliminarCultivo(VO_Cultivo cultivo){
        
        return this.daoCultivo.eliminarCultivo(cultivo);
    }
    
    public void modificarCamposCult(JTextField txtNombreCultivo, JTextField txtTiempo, JTextField txtDiasd, JTextField txtHumedadsd,
                                    JTextField txtTemperaturad, JTextField txtHumedadrd, JTextField txtphd, JTextField txtDiasfl, 
                                    JTextField txtHumedadsfl, JTextField txtTemperaturafl, JTextField txtHumedadrfl, JTextField txtphfl, 
                                    JTextField txtDiasfr, JTextField txtHumedadsfr, JTextField txtTemperaturafr, JTextField txtHumedadrfr, 
                                    JTextField txtphfr, JComboBox jcbSistemas, boolean estado){
        
        txtNombreCultivo.setEditable(estado);
        txtTiempo.setEditable(estado);
        txtDiasd.setEditable(estado);
        txtHumedadsd.setEditable(estado);
        txtTemperaturad.setEditable(estado);
        txtHumedadrd.setEditable(estado);
        txtphd.setEditable(estado);
        
        txtDiasfl.setEditable(estado);
        txtHumedadsfl.setEditable(estado);
        txtTemperaturafl.setEditable(estado);
        txtHumedadrfl.setEditable(estado);
        txtphfl.setEditable(estado);
        
        txtDiasfr.setEditable(estado);
        txtHumedadsfr.setEditable(estado);
        txtTemperaturafr.setEditable(estado);
        txtHumedadrfr.setEditable(estado);
        txtphfr.setEditable(estado);
        
        jcbSistemas.setEnabled(estado);
    }
    
    public void limpiarCamposCult(JTextField txtNombreCultivo, JTextField txtTiempo, JTextField txtDiasd, JTextField txtHumedadsd,
                                    JTextField txtTemperaturad, JTextField txtHumedadrd, JTextField txtphd, JTextField txtDiasfl, 
                                    JTextField txtHumedadsfl, JTextField txtTemperaturafl, JTextField txtHumedadrfl, JTextField txtphfl, 
                                    JTextField txtDiasfr, JTextField txtHumedadsfr, JTextField txtTemperaturafr, JTextField txtHumedadrfr, 
                                    JTextField txtphfr, JComboBox jcbSistemas){
        
        txtNombreCultivo.setText("");
        txtTiempo.setText("");
        txtDiasd.setText("");
        txtHumedadsd.setText("");
        txtTemperaturad.setText("");
        txtHumedadrd.setText("");
        txtphd.setText("");
        
        txtDiasfl.setText("");
        txtHumedadsfl.setText("");
        txtTemperaturafl.setText("");
        txtHumedadrfl.setText("");
        txtphfl.setText("");
        
        txtDiasfr.setText("");
        txtHumedadsfr.setText("");
        txtTemperaturafr.setText("");
        txtHumedadrfr.setText("");
        txtphfr.setText("");
        
        jcbSistemas.setSelectedIndex(0);
    }
    
    public void cargarDatos(JTextField txtNombreCultivo, JTextField txtTiempo, JTextField txtDiasd, JTextField txtHumedadsd,
                                    JTextField txtTemperaturad, JTextField txtHumedadrd, JTextField txtphd, JTextField txtDiasfl, 
                                    JTextField txtHumedadsfl, JTextField txtTemperaturafl, JTextField txtHumedadrfl, JTextField txtphfl, 
                                    JTextField txtDiasfr, JTextField txtHumedadsfr, JTextField txtTemperaturafr, JTextField txtHumedadrfr, 
                                    JTextField txtphfr, JComboBox jcbSistemas, VO_Cultivo cultivo){
        
        txtNombreCultivo.setText(cultivo.getCul_nombre());
        txtTiempo.setText("" + cultivo.getCul_tiempo());
        txtDiasd.setText("" + cultivo.getCul_diasd());
        txtHumedadsd.setText("" + cultivo.getHumedadsd());
        txtTemperaturad.setText("" + cultivo.getTemperaturad());
        txtHumedadrd.setText("" + cultivo.getHumedadrd());
        txtphd.setText("" + cultivo.getCul_phd());
        
        txtDiasfl.setText("" + cultivo.getCul_diasfl());
        txtHumedadsfl.setText("" + cultivo.getHumedadsfl());
        txtTemperaturafl.setText("" + cultivo.getTemperaturafl());
        txtHumedadrfl.setText("" + cultivo.getHumedadrfl());
        txtphfl.setText("" + cultivo.getCul_phfl());
        
        txtDiasfr.setText("" + cultivo.getCul_diasfr());
        txtHumedadsfr.setText("" + cultivo.getHumedadsfr());
        txtTemperaturafr.setText("" + cultivo.getTemperaturafl());
        txtHumedadrfr.setText("" + cultivo.getHumedadrfr());
        txtphfr.setText("" + cultivo.getCul_phfr());
        
        jcbSistemas.setSelectedIndex(Integer.parseInt(cultivo.getCul_sis().getSis_id()));
    }
    
    public LinkedList<VO_Cultivo> llenarTablaCultivo(JTable tabla){
        
        LinkedList<VO_Cultivo> cultivos = new LinkedList<VO_Cultivo>();
        Object[] row = new Object[3];
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        if(modelo.getRowCount() > 0){
            while (modelo.getRowCount() > 0)
                modelo.removeRow(0);
        }
        cultivos = this.daoCultivo.getAllCultivos();
        if(cultivos != null){
            for(VO_Cultivo cultivo : cultivos){
                row[0] = cultivo.getCul_nombre();
                row[1] = cultivo.getCul_tiempo();
                row[2] = cultivo.getCul_sis().getSis_nombre();
                modelo.addRow(row);
            }
        }
        
        return cultivos;
    }
    
    public LinkedList<VO_Sistema> llenarSistemas(JComboBox jcbSistemas){
        LinkedList<VO_Sistema> sistemas = new LinkedList<VO_Sistema>();
        jcbSistemas.removeAllItems();
        sistemas = daoSistema.getAllSistemas();
        jcbSistemas.addItem("--SELECCIONAR--");
        if(sistemas != null){
            for(VO_Sistema sistema : sistemas){
                jcbSistemas.addItem(sistema.getSis_nombre());
            }
        }
        
        return sistemas;
    }
    
}
