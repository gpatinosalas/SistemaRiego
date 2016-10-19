/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import DAO.*;
import VO.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gustavo Patiño Salas
 */
public class ControlConfLote {
    
    private VO_Lote voLote;
    private DAO_LoteImpl daoLote = new DAO_LoteImpl();
    
    public void modificarCamposLotes(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                     JTextField txtAncho, JTextField txtAlto, boolean estado){
        txtNombreLote.setEditable(estado);
        txtReferencia.setEditable(estado);
        txtDescripcion.setEditable(estado);
        txtAncho.setEditable(estado);
        txtAlto.setEditable(estado);
        
    }
    
    public void limparCampos(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                     JTextField txtAncho, JTextField txtAlto){
        txtNombreLote.setText("");
        txtReferencia.setText("");
        txtDescripcion.setText("");
        txtAncho.setText("");
        txtAlto.setText("");
        
    }
        
    public LinkedList<VO_Lote> llenarTabla(JTable tabla){
        
        LinkedList<VO_Lote> lotes = new LinkedList<VO_Lote>();
        Object[] row = new Object[6];
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        if(modelo.getRowCount() > 0){
            while (modelo.getRowCount() > 0)
                modelo.removeRow(0);
        }
        lotes = this.daoLote.getAllLotes();
        if(lotes != null){
            for(VO_Lote lote : lotes){
                row[0] = lote.getLot_nombre();
                row[1] = lote.getLot_identifier();
                row[3] = lote.getLot_ancho();
                row[4] = lote.getLot_largo();
                row[5] = lote.getLot_estado();
                modelo.addRow(row);
            }
        }
        return lotes;        
    }
    
    public boolean validarCampos(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                 JTextField txtAncho, JTextField txtAlto){
        
        if(!(txtNombreLote.getText().isEmpty() || txtReferencia.getText().isEmpty() || txtDescripcion.getText().isEmpty() ||
                txtAncho.getText().isEmpty() || txtAlto.getText().isEmpty())){
            
            this.voLote = this.daoLote.getLote("lod_nombre = '" + txtNombreLote + "'");
            if(this.voLote != null){
                JOptionPane.showMessageDialog(null, "Ya existe un lote con el mismo nombre. Puede editar el existente, o eliminarlo y crear nuevo", 
                        "Lote Existente", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }else{
                this.voLote = this.daoLote.getLote("lod_identifier = '" + txtReferencia + "'");
                if(this.voLote != null){
                    JOptionPane.showMessageDialog(null, "Ya existe un lote con la misma Referencia. Puede editar el existente, o eliminarlo y crear nuevo", 
                            "Lote Existente", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }else
                    return true;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos.", "Verificar Campos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    public boolean crearLote(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                 JTextField txtAncho, JTextField txtAlto){
        
        this.voLote = new VO_Lote("", txtNombreLote.getText(), Double.parseDouble(txtAncho.getText()), Double.parseDouble(txtAlto.getText()), 1, txtReferencia.getText());
        return this.daoLote.crearLote(this.voLote);        
    }
    
    public boolean modificarLote(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                 JTextField txtAncho, JTextField txtAlto){
        
        this.voLote = new VO_Lote("", txtNombreLote.getText(), Double.parseDouble(txtAncho.getText()), Double.parseDouble(txtAlto.getText()), 1, txtReferencia.getText());
        return this.daoLote.modificarLote(this.voLote);        
    }
    
    public boolean EliminarLote(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                                 JTextField txtAncho, JTextField txtAlto){
        
        this.voLote = new VO_Lote("", txtNombreLote.getText(), Double.parseDouble(txtAncho.getText()), Double.parseDouble(txtAlto.getText()), 1, txtReferencia.getText());
        return this.daoLote.eliminarLote(this.voLote);        
    }
    
    public void cargarDatos(JTextField txtNombreLote, JTextField txtReferencia, JTextField txtDescripcion, 
                            JTextField txtAncho, JTextField txtAlto, VO_Lote lote){
        txtNombreLote.setText(lote.getLot_nombre());
        txtReferencia.setText(lote.getLot_identifier());
        txtAncho.setText("" + lote.getLot_ancho());
        txtAlto.setText(""+ lote.getLot_largo());
    }
}
