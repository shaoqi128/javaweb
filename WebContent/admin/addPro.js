function check() {
	if(form.pid.value == ""){
		alert("节目编号不能为空！");
		form.pid.focus();
		return false;
	}
	if(form.pname.value == ""){
		alert("节目名不能为空");
		form.pname.focus();
		return false;
	}
	if(form.showtime.value == ""){
		alert("表演时间不能为空");
		form.showtime.focus();
		return false;
	}
}