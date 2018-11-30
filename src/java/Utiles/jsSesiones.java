package Utiles;

import Beans.tCursoSesion;
import Datos.mSesion;
import java.util.List;

public class jsSesiones {

    public String[] agregar(String[] ses, String s) {
        String[] ses1 = ses;
        ses = new String[ses1.length + 1];
        for (int i = 0; i < ses1.length; i++) {
            ses[i] = ses1[i];
        }
        ses[ses.length - 1] = s;
        return ses;
    }

    public String varListado(String[] ses) {
        String s = "";
        for (int i = 0; i < ses.length; i++) {
            s += (i != 0 && i < ses.length) ? ", " : "";
            s += "'" + ses[i] + "'";
        }
        return s;
    }

    public boolean buscar(Object[] objects, Object object) {
        boolean b = false;
        for (int i = 0; i < objects.length; i++) {
            b = b || ((objects[i]).equals(object));
        }
        return b;
    }

    public String diasdelaseman(List<tCursoSesion> cses) {
        jsSesiones nc = new jsSesiones();
        String[] ses = {};
        if (!cses.isEmpty()) {
            for (int i = 0; i < cses.size(); i++) {
                String agregar = cses.get(i).getFecha().split("-")[2]
                        + "/" + cses.get(i).getFecha().split("-")[1];
                if (!nc.buscar(ses, agregar)) {
                    ses = nc.agregar(ses, agregar);
                }
            }
        }
        return (nc.varListado(ses));
    }

    public String[] getHoras() {
        String[] horas = {"07:30", "08:20", "09:10", "10:00", "10:50", "11:40", "12:30",
            "13:20", "14:10", "15:00", "15:50", "16:40", "17:30", "18:20", "19:10",
            "20:00", "20:50", "21:40", "22:30", "23:20"};
        return horas;
    }

    public int getUbicacion(String hora) {
        int ubicacion = -1;
        String[] horas = getHoras();
        for (int i = 0; i < horas.length; i++) {
            ubicacion = (hora.equals(horas[i])) ? i : ubicacion;
        }
        return ubicacion;
    }

    public boolean validar(String hInicio, String hTermino) {
        String[] horas = getHoras();
        int ubInicio = getUbicacion(hInicio);
        int ubTermino = getUbicacion(hTermino);
        return ubTermino > ubInicio;
    }

    public String getDuracion(String hInicio, String hTermino) {
        String[] horas = getHoras();
        String s = "";
        if (validar(hInicio, hTermino)) {
            int ubInicio = getUbicacion(hInicio);
            int ubTermino = getUbicacion(hTermino);
            String[] duracion = new String[0];
            for (int i = ubInicio; i <= ubTermino; i++) {
                duracion = agregar(duracion, horas[i]);
            }
            return varListado(duracion);
        } else {
            return "";
        }
    }

    public String romanos(int numero) {
        switch (numero) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            default:
                return ">10";
        }
    }

    public String getSesiones(List<tCursoSesion> cses) {
        String string = "";
        for (int i = 0; i < cses.size(); i++) {
            string += (i != 0 && i < cses.size()) ? ", " : "";
            string += "    {\n"
                    + "        Id: '" + cses.get(i).getIdsesion() + "',\n"
                    + "        Codigo: '" + cses.get(i).getCodCurso() + "',\n"
                    + "        Nombre: '" + cses.get(i).getNombCurso() + "',\n"
                    + "        Hora: [{dia: '" + cses.get(i).getFecha().split("-")[2] + "/" + cses.get(i).getFecha().split("-")[1] + "',\n"
                    + "                horas: [" + new jsSesiones().getDuracion(cses.get(i).getHora_inicio(), cses.get(i).getHora_fin()) + "]}],\n"
                    + "        Grupo: '" + cses.get(i).getGrupo() + "',\n"
                    + "        Ciclo: '" + new jsSesiones().romanos(cses.get(i).getCiclo()) + "',\n"
                    + "        Carrera: '" + cses.get(i).getCarrera() + "',\n"
                    + "        Facultad: '" + cses.get(i).getFacultad() + "',\n"
                    + "        Color: '" + new jsSesiones().getColor(cses.get(i).getIdsesion()) + "'\n"
                    + "    }\n";
        }
        return string;
    }

    public String getColor(int idSesion) {
        String[] color = {"red", "pink", "purple", "deep-purple", "indigo", "blue",
            "light-blue", "cyan", "teal", "green", "light-green", "lime", "yellow",
            "orange", "deep-orange", "brown", "grey", "blue-grey"};
        String s = "";
        s += color[idSesion % color.length];
        s += (idSesion % 5 != 0) ? " darken-" + (idSesion % 5) : "";
        return s;
    }

    public String getRangoHoras(List<tCursoSesion> cses) {
        int hMenor = getHoras().length, hMayor = 0;
        for (int i = 0; i < cses.size(); i++) {
            if (getUbicacion(cses.get(i).getHora_inicio()) < hMenor) {
                hMenor = getUbicacion(cses.get(i).getHora_inicio());
            }
            if (getUbicacion(cses.get(i).getHora_fin()) > hMayor) {
                hMayor = getUbicacion(cses.get(i).getHora_fin());
            }
        }
        String[] ses = new String[0];
        for (int j = hMenor; j <= hMayor; j++) {
            ses = agregar(ses, getHoras()[j]);
        }
        return varListado(ses);
    }

    public static void main(String[] args) {
        List<tCursoSesion> cses = new mSesion().tCursoSesions(12345);
        System.out.println(new jsSesiones().getRangoHoras(cses));
    }

    public String getScript(int idDocente) {
        List<tCursoSesion> cses = new mSesion().tCursoSesions(idDocente);
        String s = "var diasdelasemana = [" + new jsSesiones().diasdelaseman(cses) + "];\n"
                + "var horasdelasemana = [" + new jsSesiones().getRangoHoras(cses) + "];\n"
                + "var cursosGuias = [\n"
                + getSesiones(cses)
                + "];\n"
                + "\n"
                + "\n"
                + "function cargar() {\n"
                + "    var html = document.getElementById('horario');\n"
                + "    html.innerHTML = '';\n"
                + "    var html1 = '';\n"
                + "\n"
                + "    for (var i = 0; i < horasdelasemana.length; i++) {\n"
                + "        html1 += '<tr>';\n"
                + "        for (var j = 0; j < diasdelasemana.length + 1; j++) {\n"
                + "            html1 += (i === 0 && j === 0) ? '<th class=\"grey lighten-1 center-align\">Hora</th>' : '';\n"
                + "            html1 += (i === 0 && j !== 0) ? '<th class=\"grey lighten-1 center-align\">' + diasdelasemana[j - 1] + '</th>' : '';\n"
                + "            html1 += (j === 0 && i !== 0) ? '<th class=\"grey lighten-1 center-align\">' + horasdelasemana[i - 1] + '</th>' : '';\n"
                + "            html1 += (j !== 0 && i !== 0) ? '<td style=\"padding: 0px\" class=\"grey lighten-3 center-align\" id=\"cel-' + (i - 1) + '' + (j - 1) + '\"></td>' : '';\n"
                + "        }\n"
                + "        ;\n"
                + "        html1 += '</tr>';\n"
                + "    }\n"
                + "    ;\n"
                + "    document.getElementById('horario').innerHTML = html1;\n"
                + "}\n"
                + ";\n"
                + "\n"
                + "function rellenar() {\n"
                + "\n"
                + "    for (var i = 0; i < cursosGuias.length; i++) {\n"
                + "        for (var j = 0; j < cursosGuias[i].Hora.length; j++) {\n"
                + "            for (var k = 0; k < diasdelasemana.length; k++) {\n"
                + "                if (cursosGuias[i].Hora[j].dia === diasdelasemana[k]) {\n"
                + "                    for (var m = 0; m < cursosGuias[i].Hora[j].horas.length; m++) {\n"
                + "                        for (var n = 0; n < horasdelasemana.length; n++) {\n"
                + "                            var pintar2 = 'cel-';\n"
                + "                            if (cursosGuias[i].Hora[j].horas[m] === horasdelasemana[n]) {\n"
                + "                                pintar2 += n + '' + k;\n"
                + "                                //console.log(pintar2);\n"
                + "                                var casillero1 = document.getElementById(pintar2);\n"
                + "                                var tablacasillero;\n"
                + "                                if (document.getElementById('tabl-' + pintar2) !== null) {\n"
                + "                                    tablacasillero = document.getElementById('tabl-' + pintar2);\n"
                + "                                } else {\n"
                + "                                    tablacasillero = document.createElement('table');\n"
                + "                                    tablacasillero.setAttribute('id', 'tabl-' + pintar2);\n"
                + "                                }\n"
                + "                                var tr1 = document.createElement('tr');\n"
                + "\n"
                + "                                var td1 = document.createElement('td');\n"
                + "                                td1.setAttribute('class', 'tooltipped ' + cursosGuias[i].Color + ' white-text center-align');\n"
                + "                                td1.setAttribute('data-position', 'bottom');\n"
                + "                                td1.setAttribute('data-tooltip', 'Id: '+cursosGuias[i].Id+' - Grupo: ' + cursosGuias[i].Grupo +' - '+cursosGuias[i].Ciclo+' Ciclo'\n"
                + "                                         +'<hr> Nombre: '+cursosGuias[i].Nombre+ '<hr>'\n"
                + "                                         +'Escuela: '+cursosGuias[i].Carrera+' - Facultad: '+cursosGuias[i].Facultad);\n"
                + "                                var texto1 = document.createTextNode(cursosGuias[i].Codigo);\n"
                + "                                td1.appendChild(texto1);\n"
                + "                                tr1.appendChild(td1);\n"
                + "                                tablacasillero.appendChild(tr1);\n"
                + "                                casillero1.appendChild(tablacasillero);\n"
                + "                                //document.getElementById(pintar2).innerHTML = cursosGuias[i].Codigo;\n"
                + "                            }\n"
                + "                            ;\n"
                + "                        }\n"
                + "                        ;\n"
                + "                    }\n"
                + "                    ;\n"
                + "                }\n"
                + "                ;\n"
                + "            }\n"
                + "            ;\n"
                + "        }\n"
                + "        ;\n"
                + "    }\n"
                + "    ;\n"
                + "}\n"
                + ";\n"
                + "\n"
                + "window.addEventListener('load', function () {\n"
                + "    console.log('JS creado en java');\n"
                + "    if (document.getElementById('horario') !== null) {\n"
                + "        cargar();\n"
                + "        rellenar();\n"
                + "    }\n"
                + "    ;\n"
                + "    $(document).ready(function () {\n"
                + "        $('.tooltipped').tooltip();\n"
                + "    });\n"
                + "});\n"
                + "";
        return s;
    }
}
