function check() {
	if(form.pid.value == ""){
		alert("��Ŀ��Ų���Ϊ�գ�");
		form.pid.focus();
		return false;
	}
	if(form.pname.value == ""){
		alert("��Ŀ������Ϊ��");
		form.pname.focus();
		return false;
	}
	if(form.showtime.value == ""){
		alert("����ʱ�䲻��Ϊ��");
		form.showtime.focus();
		return false;
	}
}