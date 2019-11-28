var lenguaje = "JavaScript";
var textoExtra = "con tipado fuerte Opcional";
console.log("Typescript es " + lenguaje + textoExtra);
var UnaClase = (function () {
    function UnaClase(propiedad) {
        this.propiedad = propiedad;
    }
    UnaClase.prototype.getPropiedad = function () {
        return this.propiedad;
    };
    return UnaClase;
})();
var unObjeto = new UnaClase("Tiene POO");
textoExtra = 2000;
console.log(unObjeto.getPropiedad());
