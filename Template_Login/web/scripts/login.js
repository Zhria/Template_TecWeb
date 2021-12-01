function callLogin(){
	var data={
		username: $("[name='username']").value(),
		password: $("[name='username']").value()
		//email:
	};

	$.post("./loginservlet", encodeURIComponent(JSON.stringify(data)));

}

