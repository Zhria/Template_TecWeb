function callLogin(){
	var data={
		username: $("#username").value,
		password: $("#password").value
		//email:
	};

	//document.getElementsByName("password")[0].value  
	//document.getElementsByName("username")[0].value 

	$.post("loginservlet", encodeURIComponent(JSON.stringify(data)));

}

