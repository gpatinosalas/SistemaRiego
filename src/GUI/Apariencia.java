/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import VO.*;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class Apariencia {
    
    private UIManager.LookAndFeelInfo[] apariencias;
    
    public Apariencia(){
        
    }
    
    public void cambiarApariencia(JFrame frame){
        try {
            this.apariencias = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(this.apariencias[3].getClassName());
            SwingUtilities.updateComponentTreeUI(frame);
            frame.getContentPane().setBackground(new Color (240, 240, 240));
            frame.setLocationRelativeTo(null);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Apariencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Apariencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Apariencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Apariencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
