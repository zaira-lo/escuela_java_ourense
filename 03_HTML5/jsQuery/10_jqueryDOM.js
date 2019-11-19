$(document).ready(function(){
    $("section").append("<div><p>Leyenda de lo que sea</p></div>");
    $('tr').append('<td>Info</td>');
    $('.articulo').append('<p>UN PÁRRAFO EN CADA ELEMENTO CON CLASS articulo</p>');
    $('td:nth-child(5)').attr('style', 'background-color: blue; color: white');
    $('td:nth-child(5)').click(()=> {alert('un click desde jQ')});
    $('#otro_menu').append('<p>.....</p><br/><br/>');
    $('#otro_menu').click(function(){
        $(this).slideUp();
    });

    $('h2').append('<button id="shower">Mostrar</button>');
    $('h2').append('<button id="hider">Ocultar</button>');
    $( "#hider" ).click(function() {
        $('.articulo').slideUp()});
      $( "#shower" ).click(function() {
        $( ".articulo" ).show( 2000 );
    });

});