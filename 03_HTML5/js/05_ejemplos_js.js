var dinamica= "variable dinámica";
console.log("Mensaje por consola");
console.error("Error por consola");
document.write("<h1>Titulo</h1>");
document.write("<P>Aqui aparece la "+dinamica+"</p>");
dinamica= 999;
var parrafo = document.createElement("p");
var textoParrafo= document.createTextNode("Dinamica : "+ dinamica);
parrafo.appendChild(textoParrafo);
var body= document.getElementsByTagName("body")[0];
body.appendChild(parrafo);
var arrayParrafos= document.getElementsByTagName("p");
for(p of arrayParrafos){
    p.setAttribute("style", "background-color: lightgrey")
}
alert(body.innerHTML);