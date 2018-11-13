package Utiles;

public class Fecha {

    public String getFechaHora() {
        java.util.Date d1 = new java.util.Date();
        java.sql.Timestamp d = new java.sql.Timestamp(d1.getTime());
        String s = d.toString().substring(0, d.toString().length() - 4);
        String c = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("-")) {
                c = c + "/";
            } else {
                c = c + s.substring(i, i + 1);
            }
        }

        return c;
    }

    public String getFecha() {
        return getFechaHora().substring(0, 10);
    }

    public String getFecha(String simbolo) {
        String fecha = getFecha();
        String[] ses = fecha.split("/");
        String nueva = "";
        for (int i = 0; i < ses.length; i++) {
            nueva += (i != 0 && i < ses.length) ? simbolo : "";
            nueva += ses[i];
        }
        return nueva;
    }

}
