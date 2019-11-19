//Manera ES5
function GestorEventosES5(inputId, btnId, divId){
    this.input = document.getElementById(inputId);
    this.btn = document.getElementById(btnId);
    this.divInfo = document.getElementById(divId);
    this.funCallbkAlPulsarBIND = this.funCallbkAlPulsar.bind(this);
    this.btn.addEventListener("click", this.funCallbkAlPulsarBIND);
    
    this.btn.addEventListener("click", this.funCallbkAlPulsar.bind(this));
    this.btn.addEventListener("click", this.funCallbkOnClick_2);

    this.funCallbkOnClick_2 = (evento) =>{
        this.input.style = "color: blue;";
    }

}

GestorEventosES5.prototype.funCallbkAlPulsar = function(evento){
    this.input.value = "Tipo evento: " + evento.type;
    this.divInfo.innerHTML = "evento.currentTarget.id= "+ evento.currentTarget.id;
    evento.currentTarget.value = "Puedes repetir";
    evento.currentTarget.removeEventListener("click", this.funCallbkAlPulsarBIND);
}

GestorEventosES5.prototype.metodoEstatico = function(){
    alert("Método estático")
}


//Manera ES6
class GestorEventosES6{
    constructor(inputId, btnId, divId){
        this.input = document.getElementById(inputId);
        this.btn = document.getElementById(btnId);
        this.divInfo = document.getElementById(divId);
        this.btn.addEventListener("click", this.funCallbkAlPulsar.bind(this));
        this.btn.addEventListener("click", this.funCallbkOnClick_2.bind);
    }

    funCallbkAlPulsar (evento){
        this.input.value = "Tipo evento: " + evento.type;
        this.divInfo.innerHTML += "evento.currentTarget.id= "+ evento.currentTarget.id;
    }

    funCallbkOnClick_2 = (evento) =>{
        this.input.style = "color: red;";
    }
}