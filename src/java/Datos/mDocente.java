package Datos;

import Beans.bDocente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class mDocente {

    CADO cado = new CADO();

    public boolean insertar(bDocente d) {
        String sql = "INSERT INTO docente VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, d.getParametros());
    }

    public List<bDocente> list(ResultSet rs) {
        List<bDocente> ds = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bDocente d = new bDocente(rs);
                ds.add(d);
            }
        } catch (Exception e) {
            ds = new ArrayList<>();
        }
        return ds;
    }

    public static void main(String[] args) {
        bDocente d = new bDocente(12345, "263194H", "Juanita Paredez Dominguez", "jpd@gmail.com", "jpd12345");
        System.out.println(new mDocente().insertar(d));
    }
}
