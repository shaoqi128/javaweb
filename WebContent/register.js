function check() {
	if(form.uid.value == ""){
		alert("用户编号不能为空！");
		form.uid.focus();
		return false;
	}
	if(form.username.value == ""){
		alert("用户名不能为空！");
		form.username.focus();
		return false;
	}
	var regm = /^[a-z0-9]+$/;
	if(form.username.value != "" && !form.username.value.match(regm)){
		alert("用户名格式不对，用户名只能由小写字母与数字组成，检查后重新输入！");
		form.username.focus();
		return false;
	}
	if(form.password1.value == ""){
		alert("请输入密码！");
		form.password1.focus();
		return false;
	}
	if(form.password2.value == ""){
		alert("请再次输入密码！");
		form.password2.focus();
		return false;
	}
	if(form.password1.value != form.password2.value){
		alert("两次输入的密码不一致！");
		form.password2.focus();
		return false;
	}
}