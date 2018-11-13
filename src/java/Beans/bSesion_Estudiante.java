package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class bSesion_Estudiante {

    private int sesion_idsesiones;
    private String estudiante_codigo;
    private String estado;
    private String observacion;

    public bSesion_Estudiante() {
    }

    public bSesion_Estudiante(int sesion_idsesiones, String estudiante_codigo, String estado, String observacion) {
        this.sesion_idsesiones = sesion_idsesiones;
        this.estudiante_codigo = estudiante_codigo;
        this.estado = estado;
        this.observacion = observacion;
    }

    public bSesion_Estudiante(ResultSet rs) {
        try {
            this.sesion_idsesiones = rs.getInt(1);
            this.estudiante_codigo = rs.getString(2);
            this.estado = rs.getString(3);
            this.observacion = rs.getString(4);
        } catch (Exception e) {
        }
    }

    public int getSesion_idsesiones() {
        return sesion_idsesiones;
    }

    public void setSesion_idsesiones(int sesion_idsesiones) {
        this.sesion_idsesiones = sesion_idsesiones;
    }

    public String getEstudiante_codigo() {
        return estudiante_codigo;
    }

    public void setEstudiante_codigo(String estudiante_codigo) {
        this.estudiante_codigo = estudiante_codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Object[] getParametros() {
        Object[] os = new Object[4];
        os[0] = this.sesion_idsesiones;
        os[1] = this.estudiante_codigo;
        os[2] = this.estado;
        os[3] = this.observacion;
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
