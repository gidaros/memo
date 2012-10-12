function showLoadingMask() {
	window.loadingMaskId = setTimeout(function() {
		$('.ajaxOverlay').fadeIn('fast');
		delete window.loadingMaskId;
	}, 600);
}

function hideLoadingMask() {
	clearTimeout(window.loadingMaskId);
	$('.ajaxOverlay').fadeOut('fast');
}

$(function() {
	$("<div class='ajaxOverlay'>"
	+ "<div class='ajaxIndicator'></div>"
	+ "</div>").appendTo("html > body");
});
