var lenguaje = "JavaScript";

let textoExtra:String = "con tipado fuerte Opcional";

console.log("Typescript es " + lenguaje + textoExtra);

class UnaClase{
	
	constructor(private propiedad: String){
	}
	
	getPropiedad ():String{
		return this.propiedad;
	}
}

let unObjeto : UnaClase = new UnaClase("Tiene POO");

textoExtra = 2000;

console.log(unObjeto.getPropiedad());