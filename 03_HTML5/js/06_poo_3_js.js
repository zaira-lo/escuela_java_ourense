//Notación JSON: JavaScript Object Notation

//Lo que se puede almacenar en XML se puede convertir a JSOn y viceversa.


var unObjeto ={ }//new Object();

var otroObj= {
    "prop_1": "Propiedad uno",
    "prop_2": "Propiedad dos",
    "prop_3": "Propiedad tres",
    "prop_4": "Propiedad cuatro",
    toString : function(){
        var largo = Object.keys(this).length;
        var listaPropr = "Lista de propiedades: </br>";
        var numProp = "";
        for(var i =0; i< largo; i++){
            var largoProp= Object.keys(this)[i].length;
            numProp = Object.keys(this)[i].substr(5, largoProp);
            if(Object.keys(this)[i] == "prop_" + numProp){
                listaPropr+= Object.values(this)[i] + "</br>";
            }    
        }
        return listaPropr;
    }
}

otroObj.prop_5 = "Propiedad cinco";
otroObj.prop_9= "Propiedad nueve";
otroObj.prop_19= "Propiedad diecinueve";
otroObj.prop_198= "Propiedad ciento noventa y ocho"
var contenido_tris = document.getElementById("contenido_tris");
contenido_tris.innerHTML += otroObj.toString();
