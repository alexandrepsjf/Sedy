$(document).ready(function(){
	$('#btn-dropdown-perfil').dropdown();
});

$(document).ready(function(){
	$('#btn-search-add').dropdown();
});

$('.master-menu').click(function(e){
	e.preventDefault();
	$(this).next('ul').slideToggle('slow');
	//fecha os que não são parte do que foi clicado
	$('.child-menu').not($(this).next()).slideUp('slow');
});

$('#btn-sidebar').click(function(e){
	e.preventDefault();
	$('#wrapper').toggleClass('toggled');
	$('#btn-sidebar').toggleClass('toggled');
});
$(document).ready(function(){
    $('.slider').slider();
  

});

$(document).ready(function() {
    Materialize.updateTextFields();
});
$(document).ready(function() {
    $('select').material_select();
});

