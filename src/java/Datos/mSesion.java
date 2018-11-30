package Datos;

import Beans.bSesion;
import Beans.bSesion_Estudiante;
import Beans.tAlumnoSesion;
import Beans.tCursoSesion;
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
        String sql = "SELECT * FROM `sesion` WHERE cur_idcurso = " + idCurso+" ORDER BY fecha DESC";
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }

    public List<bSesion_Estudiante> estados(int estudiante_codigo) {
        String sql = "SELECT * FROM `sesion_has_estudiante` WHERE estudiante_codigo=" + estudiante_codigo;
        ResultSet rs = cado.Recuperar(sql);
        return sesionAlumno(rs);
    }

    public List<tCursoSesion> tCursoSesions(int idDocente) {
        String sql = "SELECT curso.idcurso, sesion.idsesiones AS \"idsesion\", curso.codigo AS \"codCurso\", curso.nombre AS "
                + "\"nombCurso\", sesion.fecha, sesion.hora_inicio, sesion.hora_fin, curso.grupo, "
                + "curso.ciclo, carrera.carrera, carrera.facultad FROM curso INNER JOIN sesion ON "
                + "curso.idcurso = sesion.cur_idcurso INNER JOIN carrera ON curso.car_idcarrera = "
                + "carrera.idcarrera WHERE curso.doc_iddocente = " + idDocente
                + " ORDER BY sesion.fecha DESC";
        ResultSet rs = cado.Recuperar(sql);
        return tCursoSesions(rs);
    }

    public List<tAlumnoSesion> tAlumnoSesions(int idCurso) {
        String sql = "SELECT estudiante.codigo, estudiante.nombre, sesion_has_estudiante.estado, "
                + "sesion_has_estudiante.observacion, sesion.idsesiones, sesion.cur_idcurso AS "
                + "'idcurso', sesion.fecha FROM estudiante INNER JOIN sesion_has_estudiante ON "
                + "estudiante.codigo = sesion_has_estudiante.estudiante_codigo INNER JOIN sesion "
                + "ON sesion_has_estudiante.sesion_idsesiones = sesion.idsesiones WHERE "
                + "sesion.cur_idcurso = " + idCurso + " ORDER BY estudiante.nombre ";
        ResultSet rs = cado.Recuperar(sql);
        return tAlumnoSesions(rs);
    }

    public List<tAlumnoSesion> tAlumnoSesions(ResultSet rs) {
        List<tAlumnoSesion> ases = new ArrayList<>();
        try {
            while (rs.next()) {
                tAlumnoSesion as = new tAlumnoSesion(rs);
                ases.add(as);
            }
        } catch (Exception e) {
        }
        return ases;
    }

    private List<tCursoSesion> tCursoSesions(ResultSet rs) {
        List<tCursoSesion> cses = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                tCursoSesion cs = new tCursoSesion(rs);
                cses.add(cs);
            }
        } catch (SQLException e) {
            cses = new ArrayList<>();
        }
        return cses;
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

    public static void main(String[] args) {
        List<tAlumnoSesion> ases = new mSesion().tAlumnoSesions(34567);
        for (int i = 0; i < ases.size(); i++) {
            System.out.println(ases.get(i).toString());
        }
    }

}
