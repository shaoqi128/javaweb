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
		if(confirm("您确定要删除这些记录吗？")){
			location.href="updateUser?f=delall&alluid="+alluid;
		}else{
			alert("请您至少选择一条记录进行删除！");
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
		if(confirm("您确定要删除这些记录吗？")){
			location.href="updatePro?f=delpro&allpid="+allpid;
		}else{
			alert("请您至少选择一条记录进行删除！");
		}
	}
}

