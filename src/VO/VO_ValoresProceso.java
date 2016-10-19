/*
 * Este objeto se usará para mantener los datos de cada registro de la tabla tb_valoresproceso.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_ValoresProceso {
    
    private String vc_id;
    private String vc_fecha;
    private String vc_hora;
    private float vc_humedad1;
    private float vc_humedad2;
    private float vc_humedad3;
    private float vc_humedad4;
    private float vc_humedad5;
    private float vc_humedad6;
    private float vc_temperatura1;
    private float vc_temperatura2;
    private float vc_temperatura3;
    private float vc_temperatura4;
    private float vc_temperatura5;
    private float vc_temperatura6;
    private float vc_ph;
    private int vc_estadovalvula;
    private int vc_estadobomba;
    private VO_CultivoProceso vc_cultivoproceso;

    public VO_ValoresProceso() {
    }

    public VO_ValoresProceso(String vc_id, String vc_fecha, String vc_hora, float vc_humedad1, float vc_humedad2, float vc_humedad3, float vc_humedad4, float vc_humedad5, float vc_humedad6, float vc_temperatura1, float vc_temperatura2, float vc_temperatura3, float vc_temperatura4, float vc_temperatura5, float vc_temperatura6, float vc_ph, int vc_estadovalvula, int vc_estadobomba, VO_CultivoProceso vc_cultivoproceso) {
        this.vc_id = vc_id;
        this.vc_fecha = vc_fecha;
        this.vc_hora = vc_hora;
        this.vc_humedad1 = vc_humedad1;
        this.vc_humedad2 = vc_humedad2;
        this.vc_humedad3 = vc_humedad3;
        this.vc_humedad4 = vc_humedad4;
        this.vc_humedad5 = vc_humedad5;
        this.vc_humedad6 = vc_humedad6;
        this.vc_temperatura1 = vc_temperatura1;
        this.vc_temperatura2 = vc_temperatura2;
        this.vc_temperatura3 = vc_temperatura3;
        this.vc_temperatura4 = vc_temperatura4;
        this.vc_temperatura5 = vc_temperatura5;
        this.vc_temperatura6 = vc_temperatura6;
        this.vc_ph = vc_ph;
        this.vc_estadovalvula = vc_estadovalvula;
        this.vc_estadobomba = vc_estadobomba;
        this.vc_cultivoproceso = vc_cultivoproceso;
    }

    public String getVc_id() {
        return vc_id;
    }

    public void setVc_id(String vc_id) {
        this.vc_id = vc_id;
    }

    public String getVc_fecha() {
        return vc_fecha;
    }

    public void setVc_fecha(String vc_fecha) {
        this.vc_fecha = vc_fecha;
    }

    public String getVc_hora() {
        return vc_hora;
    }

    public void setVc_hora(String vc_hora) {
        this.vc_hora = vc_hora;
    }

    public float getVc_humedad1() {
        return vc_humedad1;
    }

    public void setVc_humedad1(float vc_humedad1) {
        this.vc_humedad1 = vc_humedad1;
    }

    public float getVc_humedad2() {
        return vc_humedad2;
    }

    public void setVc_humedad2(float vc_humedad2) {
        this.vc_humedad2 = vc_humedad2;
    }

    public float getVc_humedad3() {
        return vc_humedad3;
    }

    public void setVc_humedad3(float vc_humedad3) {
        this.vc_humedad3 = vc_humedad3;
    }

    public float getVc_humedad4() {
        return vc_humedad4;
    }

    public void setVc_humedad4(float vc_humedad4) {
        this.vc_humedad4 = vc_humedad4;
    }

    public float getVc_humedad5() {
        return vc_humedad5;
    }

    public void setVc_humedad5(float vc_humedad5) {
        this.vc_humedad5 = vc_humedad5;
    }

    public float getVc_humedad6() {
        return vc_humedad6;
    }

    public void setVc_humedad6(float vc_humedad6) {
        this.vc_humedad6 = vc_humedad6;
    }

    public float getVc_temperatura1() {
        return vc_temperatura1;
    }

    public void setVc_temperatura1(float vc_temperatura1) {
        this.vc_temperatura1 = vc_temperatura1;
    }

    public float getVc_temperatura2() {
        return vc_temperatura2;
    }

    public void setVc_temperatura2(float vc_temperatura2) {
        this.vc_temperatura2 = vc_temperatura2;
    }

    public float getVc_temperatura3() {
        return vc_temperatura3;
    }

    public void setVc_temperatura3(float vc_temperatura3) {
        this.vc_temperatura3 = vc_temperatura3;
    }

    public float getVc_temperatura4() {
        return vc_temperatura4;
    }

    public void setVc_temperatura4(float vc_temperatura4) {
        this.vc_temperatura4 = vc_temperatura4;
    }

    public float getVc_temperatura5() {
        return vc_temperatura5;
    }

    public void setVc_temperatura5(float vc_temperatura5) {
        this.vc_temperatura5 = vc_temperatura5;
    }

    public float getVc_temperatura6() {
        return vc_temperatura6;
    }

    public void setVc_temperatura6(float vc_temperatura6) {
        this.vc_temperatura6 = vc_temperatura6;
    }

    public float getVc_ph() {
        return vc_ph;
    }

    public void setVc_ph(float vc_ph) {
        this.vc_ph = vc_ph;
    }

    public int getVc_estadovalvula() {
        return vc_estadovalvula;
    }

    public void setVc_estadovalvula(int vc_estadovalvula) {
        this.vc_estadovalvula = vc_estadovalvula;
    }

    public int getVc_estadobomba() {
        return vc_estadobomba;
    }

    public void setVc_estadobomba(int vc_estadobomba) {
        this.vc_estadobomba = vc_estadobomba;
    }

    public VO_CultivoProceso getVc_cultivoproceso() {
        return vc_cultivoproceso;
    }

    public void setVc_cultivoproceso(VO_CultivoProceso vc_cultivoproceso) {
        this.vc_cultivoproceso = vc_cultivoproceso;
    }
        
}
