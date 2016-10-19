/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import DAO.*;
import VO.*;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gustavo Patiño Salas
 */
public class ControlConfUsuario {
    
    private VO_Usuario voUsuario;
    private VO_RolUsuario voRol;
    private DAO_UsuarioImpl daoUsuario = new DAO_UsuarioImpl();
    private DAO_RolUsuarioImpl daoRol = new DAO_RolUsuarioImpl();
    
    public ControlConfUsuario(){ }
    
    public void modificarCamposUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario, boolean estado) {
        
        txtNombreUsuario.setEditable(estado);
        txtApellidosUsuario.setEditable(estado);
        txtDocumentoUsuario.setEditable(estado);
        txtTelefonoUsuario.setEditable(estado);
        txtCelularUsuario.setEditable(estado);
        txtDireccionUsuario.setEditable(estado);
        txtEmailUsuario.setEditable(estado);
        txtNickNameUsuario.setEditable(estado);
        txtPasswordUsuario.setEditable(estado);
        txtCheckPasswordUsuario.setEditable(estado);
        jcbRolesUsuario.setEnabled(estado);       
    }
        
    public void limpiarCamposUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario){
        
        txtNombreUsuario.setText("");
        txtApellidosUsuario.setText("");
        txtDocumentoUsuario.setText("");
        txtTelefonoUsuario.setText("");
        txtCelularUsuario.setText("");
        txtDireccionUsuario.setText("");
        txtEmailUsuario.setText("");
        txtNickNameUsuario.setText("");
        txtPasswordUsuario.setText("");
        txtCheckPasswordUsuario.setText("");
        jcbRolesUsuario.setSelectedIndex(0);
    }
    
    public boolean validarCamposUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario){
        
        if(!(txtNombreUsuario.getText().isEmpty() || txtApellidosUsuario.getText().isEmpty() || txtDocumentoUsuario.getText().isEmpty() ||
                txtTelefonoUsuario.getText().isEmpty() || txtCelularUsuario.getText().isEmpty() || txtDireccionUsuario.getText().isEmpty() ||
                txtEmailUsuario.getText().isEmpty() || txtNickNameUsuario.getText().isEmpty() || txtPasswordUsuario.getText().isEmpty() ||
                txtCheckPasswordUsuario.getText().isEmpty() || jcbRolesUsuario.getSelectedIndex() == 0)){
            
            VO_Usuario usuario = new VO_Usuario();
            //Valido que el nombre de usuario no este en uso.
            usuario = this.daoUsuario.getUsuario("usu_nickname = '" + txtNickNameUsuario.getText() + "'");   
            if(usuario != null){
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe en la base de datos, por favor elija uno nuevo", 
                        "Nombre de Usuario", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }else{
                //Valido que el password y la confirmacion coincidan.
                if(!(txtPasswordUsuario.getText().equals(txtCheckPasswordUsuario.getText()))){
                    JOptionPane.showMessageDialog(null, "El password no coincide con el de verificacion, por favor verifique los datos suministrados.", 
                            "Verificar Password", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }else{
                    //Valido que el documento suministrado no se haya usado anteriormente.
                    usuario = this.daoUsuario.getUsuarioID(txtDocumentoUsuario.getText());
                    if(usuario != null){
                        JOptionPane.showMessageDialog(null, "El documento que esta suministrando ya ha sido usado.", "Verificar Documento", JOptionPane.INFORMATION_MESSAGE);
                         return false;
                    }else{
                        return true;
                    }
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos.", "Verificar Campos", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    public boolean agregarUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario){
        
        this.voRol = this.daoRol.getRolUsuario(""+jcbRolesUsuario.getSelectedIndex());
        this.voUsuario = new VO_Usuario(txtDocumentoUsuario.getText(), txtNombreUsuario.getText(), txtApellidosUsuario.getText(),
                        txtNickNameUsuario.getText(), txtPasswordUsuario.getText(), 1, this.voRol);
        return this.daoUsuario.crearUsuario(voUsuario);
    }
    
    public boolean modificarUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario){
        
        this.voRol = this.daoRol.getRolUsuario("" + jcbRolesUsuario.getSelectedIndex());
        this.voUsuario = new VO_Usuario(txtDocumentoUsuario.getText(), txtNombreUsuario.getText(), txtApellidosUsuario.getText(),
                        txtNickNameUsuario.getText(), txtPasswordUsuario.getText(), 1, this.voRol);
        
        return this.daoUsuario.modificarUsuario(voUsuario);
    }
    
    public boolean eliminarUsuario(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario){

        voRol = this.daoRol.getRolUsuario("" + jcbRolesUsuario.getSelectedIndex());
        this.voUsuario = new VO_Usuario(txtDocumentoUsuario.getText(), txtNombreUsuario.getText(), txtApellidosUsuario.getText(),
                        txtNickNameUsuario.getText(), txtPasswordUsuario.getText(), 1, this.voRol);
        return this.daoUsuario.eliminarUsuario(voUsuario);
    }
    
    public LinkedList<VO_Usuario> llenarTabla(JTable tabla){
        
        LinkedList<VO_Usuario> usuarios = new LinkedList<VO_Usuario>();
        Object[] row = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        if(modelo.getRowCount() > 0){
            while (modelo.getRowCount() > 0)
                modelo.removeRow(0);
        }
        usuarios = this.daoUsuario.getAllUsuarios();
        if(usuarios != null){
            for(VO_Usuario user : usuarios){
                row[0] = user.getUsu_nombres();
                row[1] = user.getUsu_apellidos();
                row[2] = user.getUsu_nickName();
                row[3] = user.getRol().getRol_nombre();
                modelo.addRow(row);
            }
        }
        return usuarios;
    }
    
    public LinkedList<VO_RolUsuario> llenarRoles(JComboBox jcbRoles){
        LinkedList<VO_RolUsuario> roles = new LinkedList<VO_RolUsuario>();
        jcbRoles.removeAllItems();
        roles = daoRol.getAllRolUsuario();
        jcbRoles.addItem("--SELECCIONAR--");
        if(roles != null){
            for(VO_RolUsuario rol : roles){
                jcbRoles.addItem(rol.getRol_nombre());
            }
        }
        
        return roles;
    }
    
    public void cargarDatos(JTextField txtNombreUsuario, JTextField txtApellidosUsuario, JTextField txtDocumentoUsuario,
            JTextField txtTelefonoUsuario, JTextField txtCelularUsuario, JTextField txtDireccionUsuario, JTextField txtEmailUsuario, 
            JTextField txtNickNameUsuario, JTextField txtPasswordUsuario, JTextField txtCheckPasswordUsuario, JComboBox jcbRolesUsuario, VO_Usuario user){
        
        txtNombreUsuario.setText(user.getUsu_nombres());
        txtApellidosUsuario.setText(user.getUsu_apellidos());
        txtDocumentoUsuario.setText(user.getUsu_id());
        txtNickNameUsuario.setText(user.getUsu_nickName());
        txtPasswordUsuario.setText(user.getUsu_password());
        txtCheckPasswordUsuario.setText(user.getUsu_password());
        jcbRolesUsuario.setSelectedIndex(Integer.parseInt(user.getRol().getRol_id()));
    }
}
