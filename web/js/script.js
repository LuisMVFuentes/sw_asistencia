function validarSesion() {
    var fecha = document.getElementById("txtFecha");
    var hInicio = document.getElementById("txtHoraInicio");
    var hFin = document.getElementById("txtHoraFin");
    if (fecha.value === "" || hInicio.value === 0 || hFin.value === 0) {
        window.alert("Complete todos los campos!");
        return false;
    } else {
        confirm("¿Desea Guardar?");
    }
}

function validarCurso() {
    var codigo = document.getElementById("txtCodigoCurso");
    var grupo = document.getElementById("txtGrupo");
    var ciclo = document.getElementById("txtCiclo");
    var nombre = document.getElementById("txtNombre");
    var carrera = document.getElementById("txtCarrera");
    if (codigo.value === "" || grupo.value === "" || nombre.value === "") {
        window.alert("Complete todos los campos!");
        return false;
    } else if (ciclo.value === "0" || carrera.value === "0") {
        window.alert("Seleccione el ciclo o carrera a la que pertenece!");
        return false;
    } else if (codigo.value.length > 5) {
        return false;
    } else {
        confirm("¿Desea Guardar?");
    }
}

function validar() {
    var user = document.getElementById("txtUser");
    var uservalue = user.value;
    var pass = document.getElementById("txtPass");
    var passvalue = pass.value;
    if (uservalue.length === 0 || passvalue.length === 0) {
        (uservalue.length === 0)
                ? user.setAttribute("style", "border-color: red") : user.removeAttribute("style");
        (passvalue.length === 0)
                ? pass.setAttribute("style", "border-color: red") : pass.removeAttribute("style");
        window.alert("Complete todos los campos!");
        return false;
    }

}

function validarEditar() {
    var nombre = document.getElementById("txtNombre");
    var email = document.getElementById("txtCorreo");
    var pass = document.getElementById("txtPass");
    var pass1 = document.getElementById("txtPass1");
    if (nombre.value.length === 0 || email.value.length === 0 ||
            pass.value.length === 0 || pass1.value.length === 0) {
        window.alert("Complete todos los campos!");
        return false;
    } else if (pass.value !== pass1.value) {
        window.alert("Las Contraseñas(password) no coinciden!");
        return false;
    } else {
        return confirm("¿Desea Guardar?");
    }
}