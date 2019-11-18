var divBis = document.getElementById("contenido_bis");

divBis.style = "background-color: lightgrey";

var mostrarTodosParam = function(primerParam){
    divBis.innerHTML+= "<p>Primer parámetro: "+ primerParam + "</p>"
    for(argumento of arguments){
        divBis.innerHTML+= "Argumento: " + argumento + "</br>";
    }
    if(typeof(primerParam)=== "undefined"){
        divBis+="primerParam no está definida";
    }if (primerParam== "1"){
        divBis.innerHTML+= "Pues es \"1\"";
    }else{
        divBis.innerHTML+= "No es parecido a \"1\"";
    }
    if (primerParam=== 1){
        divBis.innerHTML+= "Pues es idéntico 1 number";
    }else{
        divBis.innerHTML+= "No es idéntico a 1 number";
    }
}

mostrarTodosParam("Un argumento", 50, true, bebida);
mostrarTodosParam("1"); // cadena de texto
mostrarTodosParam(1); //número 1

var intentoConversion = parseFloat("veinte");
divBis.innerHTML +=  "</br> Convirtiendo. Resultado=  " + intentoConversion;
divBis.innerHTML += "</br> El tipo de dato es " + typeof(intentoConversion);

if(isNaN(intentoConversion)){
    divBis.innerHTML += "</br> No es un número"
}
divBis.innerHTML+= "</br> Infinito " + 1/0;
divBis.innerHTML+= "</br> Valor max " + 1.23456789012345678;