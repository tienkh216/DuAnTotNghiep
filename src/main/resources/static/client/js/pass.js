
	$('document').ready(function(){			
	var password = document.getElementById("pass")
	var confirmPassword = document.getElementById("cpass");
	
	function validatePassword(){
	  if(password.value != confirmPassword.value) {
	    confirmPassword.setCustomValidity("Passwords không trùng nhau");
	  } else {
	    confirmPassword.setCustomValidity('');
	  }
	}	
	password.onchange = validatePassword;
	confirmPassword.onkeyup = validatePassword;		
});
