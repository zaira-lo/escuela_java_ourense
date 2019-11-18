//Nomenclatura típica de function en variable
let suma = function(x,y){return x + y;}

let multiplica = function (x,y){return x*y;}

//Nomenclatura de objeto Function
let divide =  new Function ("x", "y", "return x/y");

//Nomenclatura de función flecha

let resta =(x,y)=>{
    return x-y;
}

function hacerPunto(x,y){
    return`(${x},${y})`;
}



       
       