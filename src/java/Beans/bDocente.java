package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class bDocente {

    private int iddocente;
    private String codigo;
    private String nombre_doc;
    private String correo;
    private String password;

    public bDocente() {
    }

    public bDocente(int iddocente, String codigo, String nombre_doc, String correo, String password) {
        this.iddocente = iddocente;
        this.codigo = codigo;
        this.nombre_doc = nombre_doc;
        this.correo = correo;
        this.password = password;
    }

    public bDocente(ResultSet rs) {
        try {
            this.iddocente = rs.getInt(1);
            this.codigo = rs.getString(2);
            this.nombre_doc = rs.getString(3);
            this.correo = rs.getString(4);
            this.password = rs.getString(5);
        } catch (Exception e) {

        }
    }

    public int getIddocente() {
        return iddocente;
    }

    public void setIddocente(int iddocente) {
        this.iddocente = iddocente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_doc() {
        return nombre_doc;
    }

    public void setNombre_doc(String nombre_doc) {
        this.nombre_doc = nombre_doc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object[] getParametros() {
        Object[] os = new Object[5];
        os[0] = iddocente;
        os[1] = codigo;
        os[2] = nombre_doc;
        os[3] = correo;
        os[4] = password;
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
