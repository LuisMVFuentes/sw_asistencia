package Datos;

import Beans.bCurso;
import Utiles.random;
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
        String sql = "INSERT INTO `curso`(`idcurso`, `codigo`, `nombre`, `grupo`, `ciclo`, `doc_iddocente`, `car_idcarrera`) VALUES (?,?,?,?,?,?,?)";
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

    public static void main(String[] args) {
        mCurso modelo = new mCurso();
        random r = new random();
        bCurso c = new bCurso(r.getInt(),
                "1818A",
                "FUNDAMENTOS DE BASE DE DATOS",
                "18B",
                4,
                12345,
                23456);
        System.out.println(modelo.insertar(c));
    }
}
