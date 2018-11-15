package Datos;

import Beans.bCarrera;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class mCarrera {

    CADO cado = new CADO();

    public boolean insertar(bCarrera c) {
        String sql = "INSERT INTO carrera VALUES(?, ?, ?)";
        return cado.Ejecutar(sql, c.getParametros());
    }

    public List<bCarrera> sel_carrera(int idcarrera) {
        String sql = "SELECT * FROM `carrera` WHERE idcarrera = " + idcarrera;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }
    
    public List<bCarrera> listar(){
        String sql = "SELECT * FROM carrera";
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }
    private List<bCarrera> list(ResultSet rs) {
        List<bCarrera> cs = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bCarrera c = new bCarrera(rs);
                cs.add(c);
            }
        } catch (Exception e) {
            cs = new ArrayList<>();
        }
        return cs;
    }

}
