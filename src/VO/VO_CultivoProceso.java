/*
 * Esta clase es un objeto con el que reflejamos un registro de la tabla tb_cultivoproceso, esto con el fin de mantener 
 * los datos y evitar los accesos a la base de datos.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_CultivoProceso {
    
    private String cp_id;
    private String cp_fechainicio;
    private String cp_horainicio;
    private int cp_estado;
    private VO_Cultivo cp_cultivo;
    private VO_Lote cp_lote;
    private VO_Usuario cp_usuario;

    public VO_CultivoProceso() {
    }

    public VO_CultivoProceso(String cp_id, String cp_fechainicio, String cp_horainicio, int cp_estado, VO_Cultivo cp_cultivo, VO_Lote cp_lote, VO_Usuario cp_usuario) {
        this.cp_id = cp_id;
        this.cp_fechainicio = cp_fechainicio;
        this.cp_horainicio = cp_horainicio;
        this.cp_estado = cp_estado;
        this.cp_cultivo = cp_cultivo;
        this.cp_lote = cp_lote;
        this.cp_usuario = cp_usuario;
    }

    public String getCp_id() {
        return cp_id;
    }

    public void setCp_id(String cp_id) {
        this.cp_id = cp_id;
    }

    public String getCp_fechainicio() {
        return cp_fechainicio;
    }

    public void setCp_fechainicio(String cp_fechainicio) {
        this.cp_fechainicio = cp_fechainicio;
    }

    public String getCp_horainicio() {
        return cp_horainicio;
    }

    public void setCp_horainicio(String cp_horainicio) {
        this.cp_horainicio = cp_horainicio;
    }

    public int getCp_estado() {
        return cp_estado;
    }

    public void setCp_estado(int cp_estado) {
        this.cp_estado = cp_estado;
    }

    public VO_Cultivo getCp_cultivo() {
        return cp_cultivo;
    }

    public void setCp_cultivo(VO_Cultivo cp_cultivo) {
        this.cp_cultivo = cp_cultivo;
    }

    public VO_Lote getCp_lote() {
        return cp_lote;
    }

    public void setCp_lote(VO_Lote cp_lote) {
        this.cp_lote = cp_lote;
    }

    public VO_Usuario getCp_usuario() {
        return cp_usuario;
    }

    public void setCp_usuario(VO_Usuario cp_usuario) {
        this.cp_usuario = cp_usuario;
    }
    
}
