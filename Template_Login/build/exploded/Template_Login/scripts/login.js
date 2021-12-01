function callLogin(){
	var data={
		username: $("[name=username]").val(),
		password: $("[name=password]").val()
		//email:
	}

	//document.getElementsByName("password")[0].value  
	//document.getElementsByName("username")[0].value 

	$.post("loginservlet", (JSON.stringify(data)));

}

