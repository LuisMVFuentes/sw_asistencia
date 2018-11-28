package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class tCursoSesion {

    private int idcurso;
    private String codCurso;
    private String nombCurso;
    private String fecha;
    private String hora_inicio;
    private String hora_fin;
    private String grupo;
    private int ciclo;
    private String carrera;
    private String facultad;

    public tCursoSesion() {
    }

    public tCursoSesion(ResultSet rs) {
        try {
            this.idcurso = rs.getInt(1);
            this.codCurso = rs.getString(2);
            this.nombCurso = rs.getString(3).toUpperCase();
            this.fecha = rs.getDate(4).toString();
            this.hora_inicio = rs.getString(5);
            this.hora_fin = rs.getString(6);
            this.grupo = rs.getString(7).toUpperCase();
            this.ciclo = rs.getInt(8);
            this.carrera = rs.getString(9).toUpperCase();
            this.facultad = rs.getString(10).toUpperCase();
        } catch (Exception e) {
        }
    }

    public tCursoSesion(int idcurso, String codCurso, String nombCurso, String fecha, String hora_inicio, String hora_fin, String grupo, int ciclo, String carrera, String facultad) {
        this.idcurso = idcurso;
        this.codCurso = codCurso;
        this.nombCurso = nombCurso.toUpperCase();
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.grupo = grupo.toUpperCase();
        this.ciclo = ciclo;
        this.carrera = carrera.toUpperCase();
        this.facultad = facultad.toUpperCase();
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombCurso() {
        return nombCurso;
    }

    public void setNombCurso(String nombCurso) {
        this.nombCurso = nombCurso;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Object[] getParametros() {
        Object[] os = new Object[10];
        os[0] = this.idcurso;
        os[1] = this.codCurso;
        os[2] = this.nombCurso;
        os[3] = this.fecha;
        os[4] = this.hora_inicio;
        os[5] = this.hora_fin;
        os[6] = this.grupo;
        os[7] = this.ciclo;
        os[8] = this.carrera;
        os[9] = this.facultad;
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
