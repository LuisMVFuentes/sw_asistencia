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
;

