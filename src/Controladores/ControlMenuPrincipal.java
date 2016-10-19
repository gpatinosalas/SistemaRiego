/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import DAO.*;
import GUI.*;
import VO.*;
import javax.swing.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class ControlMenuPrincipal {
    
    private VO_Usuario voUsuario;
    
    public ControlMenuPrincipal(){}
    
    public void activarOpciones(VO_Usuario usuario, JButton btnMonitoreo, JButton btnReportes, JButton btnDepositoAgua, JButton btnConfiguracion){
        
        this.voUsuario = usuario;
        System.out.println(this.voUsuario.getRol().getRol_id());
        int id = (int)Integer.parseInt(this.voUsuario.getRol().getRol_id());
        switch(id){
            case 1: btnMonitoreo.setEnabled(true);
                btnReportes.setEnabled(true);
                btnDepositoAgua.setEnabled(true);
                btnConfiguracion.setEnabled(true);
                break;
            case 2: btnMonitoreo.setEnabled(true);
                btnReportes.setEnabled(true);
                btnDepositoAgua.setEnabled(true);
                btnConfiguracion.setEnabled(false);
                break;
            case 3: btnMonitoreo.setEnabled(true);
                btnReportes.setEnabled(true);
                btnDepositoAgua.setEnabled(true);
                btnConfiguracion.setEnabled(true);
                break;
            default: btnMonitoreo.setEnabled(false);
                btnReportes.setEnabled(false);
                btnDepositoAgua.setEnabled(false);
                btnConfiguracion.setEnabled(false);
                break;
        }
        
    }
}
