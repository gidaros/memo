function showLoadingMask() {
	$('.ajaxOverlay').fadeIn('fast');
}

function hideLoadingMask() {
	$('.ajaxOverlay').fadeOut('fast');
}

$(function() {
	$("<div class='ajaxOverlay'>" + 
	  "<div class='ajaxIndicator'></div>" + 
	  "</div>").appendTo("html > body");
});
