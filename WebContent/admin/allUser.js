function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;
	}
}
function allnotcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=false;
	}
}
function delAllUser(){
	var alluid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			alluid.push(oCheck[i].value);
			flag = true;
		}
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateUser?f=delall&alluid="+alluid;
		}else{
			alert("��������ѡ��һ����¼����ɾ����");
		}
	}
}
function delAllProgram(){
	var allpid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allpid.push(oCheck[i].value);
			flag = true;
		}
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updatePro?f=delpro&allpid="+allpid;
		}else{
			alert("��������ѡ��һ����¼����ɾ����");
		}
	}
}

