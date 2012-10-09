function showLoadingMask() {
//	console.log('### showLoadingMask');
	$('.ajaxOverlay').fadeIn('fast');
}

function hideLoadingMask() {
//	console.log('### hideLoadingMask');
	$('.ajaxOverlay').fadeOut('fast');
}

$(function() {
	$("<div class='ajaxOverlay'>" + 
	  "<div class='ajaxIndicator'></div>" + 
	  "</div>").appendTo("html > body");
});
