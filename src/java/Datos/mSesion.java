package Datos;

import Beans.bSesion;
import Beans.bSesion_Estudiante;
import Utiles.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean modificar(Object[] parametros) {
        String sql = "UPDATE `sesion` SET `hora_inicio`=?,`hora_fin`=? WHERE `idsesiones`=?";
        return cado.Ejecutar(sql, parametros);
    }

    public List<bSesion> sesiones(int idCurso) {
        String sql = "SELECT * FROM `sesion` WHERE cur_idcurso = " + idCurso;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    public List<bSesion_Estudiante> estados(int estudiante_codigo) {
        String sql = "SELECT * FROM `sesion_has_estudiante` WHERE estudiante_codigo=" + estudiante_codigo;
        ResultSet rs = cado.Recuperar(sql);
        return sesionAlumno(rs);
    }

    private List<bSesion> list(ResultSet rs) {
        List<bSesion> ses = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bSesion s = new bSesion(rs);
                ses.add(s);
            }
        } catch (SQLException e) {
            ses = new ArrayList<>();
        }
        return ses;
    }

    private List<bSesion_Estudiante> sesionAlumno(ResultSet rs) {
        List<bSesion_Estudiante> ses = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bSesion_Estudiante se = new bSesion_Estudiante(rs);
                ses.add(se);
            }
        } catch (SQLException e) {
        }
        return ses;
    }
}
