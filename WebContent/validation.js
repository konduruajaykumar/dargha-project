function onlyAlphabets(textValue) {
	var val = textValue.value;

	if (val.match(/[^a-zA-Z\s]/)) {
		// alert('Only alphabets are allowed');
		val = val.substring(0, (val.length - 1));
		textValue.value = val;
		return false;
	}

	return true;
}

function onlyNumbers(numValue) {
	var checkNum = numValue.value;
	if (checkNum.match(/[^0-9]/)) {
		checkNum = checkNum.substring(0, (checkNum.length - 1));
		numValue.value = checkNum;
	}
}

/*$('myNavbar > ul.navbar-nav li').click(function(e) {
    $('.nav li.active').removeClass('active');
    var $this = $(this);
    $this.addClass('active');
    e.preventDefault();
});
*/

