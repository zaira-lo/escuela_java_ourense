let array_A= [4,5,6,7,8];
let array_B = [2,3,4,5,6];

let arraySumaAB= operarArrays(array_A, array_B, suma);
let arrayMultiplicaAB= operarArrays(array_A, array_B, multiplica);
let arrayDivAB= operarArrays(array_A, array_B, (x, y)=> x/y);
let arrayRest = operarArrays(array_A, array_B, resta);
        


tablaOrdenada(arrayMultiplicaAB);
tablaOrdenada(arrayDivAB);
tablaOrdenada(arrayRest);

tablaOrdenada(arraySumaAB)


function tablaOrdenada(array){
    let tabla = "<table border=2><tr><th>i</th><th>Elementos</th><th>Resultado</th></tr>";
    for (let i = 0; i < array.length; i++) {
        const element = array[i];
        tabla+= "<tr><td>&nbsp;"+ i + "&nbsp;</td><td>"+ hacerPunto(array_A[i], array_B[i]) +
         "</td><td>"+ array[i] + "</td></tr>"
    }
    document.getElementById("contenido_2").innerHTML += tabla+"</table>";
}
