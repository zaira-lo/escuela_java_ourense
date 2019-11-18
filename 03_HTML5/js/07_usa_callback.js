function operarArrays(arrX, arrY, opera){
    //Comprobamos que el tamaño de los arrays son iguales
    if(arrX.length == arrY.length){
        //Declaramos un array con la palabra var: ámbito es de función.
        //A diferencia de let en ES6, que sí es ámbito a nivel bloque.
        var arrayResultado = new Array(); //Una manera de crear un array
        for(let i=0; i< arrX.length; i++){
            arrayResultado[i] = opera(arrX[i], arrY[i]);
        }
    }
    return arrayResultado;
}



//OTRO EJEMPLO ARRAY:
        //Declaramos un array
        //var arrayResultado = new Array(); //Una manera de crear un array
        var arrayEjemplo= [];//Otra manera, con notación JSON sin indicar tamaño
        //Los arrays de js son como los ArrayList<Object> de java
        //Incluso a un HashMap cuya clave sería un integer (HashMap<Integer, Object>)
arrayEjemplo.push("Primer elemento");
arrayEjemplo[10]= "lo que sea";