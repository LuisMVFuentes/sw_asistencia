package Datos;

import Beans.bCurso;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARIANO
 */
public class mCurso {

    CADO cado = new CADO();

    public boolean insertar(bCurso c) {
        String sql = "INSERT INTO curso VALUES (?, ?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, c.getParametros());
    }

    public List<bCurso> cursos_docente(int idDoc) {
        String sql = "SELECT * FROM curso WHERE doc_iddocente = " + idDoc;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);

    }

    public List<bCurso> sel_curso(int idCurso) {
        String sql = "SELECT * FROM curso WHERE idCurso = " + idCurso;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);

    }

    private List<bCurso> list(ResultSet rs) {
        List<bCurso> cs = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bCurso c = new bCurso(rs);
                cs.add(c);
            }
        } catch (Exception e) {
            cs = new ArrayList<>();
        }
        return cs;
    }

}
