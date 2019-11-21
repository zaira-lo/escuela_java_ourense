$(document).ready(function () {
    //evento click del botón
    $('#btn_peticion_ajax_jq').click(function () {
        //Creamos la petición AJAX:
        $.ajax({
            "url": "datosjson",
            "type": "GET",
            "success": function (respuestaJson) {
                $('#div_datos_json').html(
                        JSON.stringify(respuestaJson));
            },
            "error": function (jqXHR, textStatus, errorThrown) {
                console.error("no se ha podido obtener la info");
                console.warn(jqXHR);
                console.warn(textStatus);
                console.warn(errorThrown);
                if (jqXHR.status === 404) {
                    alert("URL no localizada");
                }

            }
        });
    });

    $('#btn_peticion_ajax_post').click(function () {
        let nombre = document.getElementById("nombre").value;
        let email = document.getElementById("email").value;
        if (nombre !=="" && nombre.length > 1 && (email) !== "") {
            
            let expresionNombre = new RegExp("^[A-Z][a-z]+ ?[A-Za-z]*$");
            let expresionEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*.([a-z]+)$/;
            
            if(!expresionNombre.test(nombre)){
                alert("Primera letra mayus, mínimo una mayúscila. Apellido opcional");
                return;
            } else if(!expresionEmail.test(email)){
                alert("Email inválido");
                return;
            }else{
                var datosUsuario = {
                "nombre": nombre,
                "email": email
            };
            $.post("datosjson", datosUsuario,
                    function (resp) {
                        $('#div_datos_json').html(
                                JSON.stringify(resp));
                    });
                
            }
        }

    });
});
