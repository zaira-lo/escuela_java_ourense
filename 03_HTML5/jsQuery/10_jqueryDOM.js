$(document).ready(function(){
    $("section").append("<div><p>Leyenda de lo que sea</p></div>");
    $('tr').append('<td>Info</td>');
    $('.articulo').append('<p>UN PÁRRAFO EN CADA ELEMENTO CON CLASS articulo</p>');
    $('td:nth-child(5)').attr('style', 'background-color: blue; color: white');
    $('td:nth-child(5)').click(()=> {alert('un click desde jQ')});
    $('#otro_menu').html('<h2>Menú de artículos</h2><br/><br/>');
    
    $('article').hide();
    var articuloActivo
    $('article').each( function(index){
        let idArticulo= "articulo_213_"+index;
        $(this).attr("id", idArticulo);
        $('#otro_menu').append("<a class='enlacesMenu2' id='enlaceMenu2_"+index+"'>Articulo "+ index+"</a>");    
        $('#enlaceMenu2_'+index).click(function(){
            if(typeof(articuloActivo)==="undefined"){
                $("#"+ idArticulo).show( 2000 );
            }else{
                $(articuloActivo).slideUp(800, function(){
                    $("#"+ idArticulo).show( 2000 );
                });
            }
            articuloActivo = $("#"+ idArticulo)
        });
    });
    
});