package Datos;

import Beans.bSesion;
import Beans.bSesion_Estudiante;
import Utiles.Fecha;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class mSesion {

    CADO cado = new CADO();

    public boolean insertar(bSesion s) {
        String sql = "INSERT INTO sesion VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, s.getParametros());
    }

    public boolean insertar(bSesion_Estudiante se) {
        String sql = "INSERT INTO `sesion_has_estudiante` VALUES (?, ?, ?, ?)";
        return cado.Ejecutar(sql, se.getParametros());
    }

    public List<bSesion> sesiones(int idCurso) {
        String sql = "SELECT * FROM `sesion` WHERE cur_idcurso = " + idCurso;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    private List<bSesion> list(ResultSet rs) {
        List<bSesion> ses = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bSesion s = new bSesion(rs);
                ses.add(s);
            }
        } catch (Exception e) {
            ses = new ArrayList<>();
        }
        return ses;
    }
}
