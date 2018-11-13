package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class bSesion {

    private int idsesiones;
    private String fecha;
    private String hora_inicio;
    private String hora_fin;
    private int cur_idcurso;

    public bSesion() {
    }

    public bSesion(int idsesiones, String fecha, String hora_inicio, String hora_fin, int cur_idcurso) {
        this.idsesiones = idsesiones;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.cur_idcurso = cur_idcurso;
    }

    public bSesion(ResultSet rs) {
        try {
            this.idsesiones = rs.getInt(1);
            this.fecha = rs.getDate(2).toString();
            this.hora_inicio = rs.getString(3);
            this.hora_fin = rs.getString(4);
            this.cur_idcurso = rs.getInt(5);
        } catch (Exception e) {
        }
    }

    public int getIdsesiones() {
        return idsesiones;
    }

    public void setIdsesiones(int idsesiones) {
        this.idsesiones = idsesiones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getCur_idcurso() {
        return cur_idcurso;
    }

    public void setCur_idcurso(int cur_idcurso) {
        this.cur_idcurso = cur_idcurso;
    }

    public Object[] getParametros() {
        Object[] os = new Object[5];
        os[0] = this.idsesiones;
        os[1] = this.fecha;
        os[2] = this.hora_inicio;
        os[3] = this.hora_fin;
        os[4] = this.cur_idcurso;
        return os;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getParametros().length; i++) {
            s += (i != 0 && i < getParametros().length) ? ", " : "";
            s += getParametros()[i];
        }
        return s;
    }

}
