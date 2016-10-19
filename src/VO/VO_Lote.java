/*
 * Este objeto representa un registro de la tabla tb_lotes. De modo que se pueda mantener la informacion en la vista 
 * y recuperar mas facilmente.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_Lote {
    
    private String lot_id;
    private String lot_nombre;
    private double lot_ancho;
    private double lot_largo;
    private int lot_estado;
    private String lot_identifier;

    public VO_Lote() {
    }

    public VO_Lote(String lot_id, String lot_nombre, double lot_ancho, double lot_largo, int lot_estado, String lot_identifier) {
        this.lot_id = lot_id;
        this.lot_nombre = lot_nombre;
        this.lot_ancho = lot_ancho;
        this.lot_largo = lot_largo;
        this.lot_estado = lot_estado;
        this.lot_identifier = lot_identifier;
    }

    public String getLot_id() {
        return lot_id;
    }

    public void setLot_id(String lot_id) {
        this.lot_id = lot_id;
    }

    public String getLot_nombre() {
        return lot_nombre;
    }

    public void setLot_nombre(String lot_nombre) {
        this.lot_nombre = lot_nombre;
    }

    public double getLot_ancho() {
        return lot_ancho;
    }

    public void setLot_ancho(double lot_ancho) {
        this.lot_ancho = lot_ancho;
    }

    public double getLot_largo() {
        return lot_largo;
    }

    public void setLot_largo(double lot_largo) {
        this.lot_largo = lot_largo;
    }

    public int getLot_estado() {
        return lot_estado;
    }

    public void setLot_estado(int lot_estado) {
        this.lot_estado = lot_estado;
    }

    public String getLot_identifier() {
        return lot_identifier;
    }

    public void setLot_identifier(String lot_identifier) {
        this.lot_identifier = lot_identifier;
    }
    
}
