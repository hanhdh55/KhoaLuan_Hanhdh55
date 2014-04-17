

function FirstPageHandler(){
	document.getElementById("pageNumber").value = "1";
	
	document.getElementById("data_form").submit();
} 

 function NextPageHandler(){
	 var pagenum = parseInt(document.getElementById("pageNumber").value);
	 var totalpage = parseInt(document.getElementById("totalPage").value);
	 if (pagenum < totalpage)
		 document.getElementById("pageNumber").value = (pagenum + 1) + "";
	
	document.getElementById("data_form").submit();
}  

function PreviousPageHandler(){
	var pagenum = parseInt(document.getElementById("pageNumber").value);
	if (pagenum-1 == 0){ 
		document.getElementById("pageNumber").value = "1";
	}
	else if (pagenum-1 < 0) document.getElementById("pageNumber").value = "0";
	else document.getElementById("pageNumber").value = (pagenum - 1) + "";
	
	document.getElementById("data_form").submit();
}

function LastPageHandler(){
	var totalpage = parseInt(document.getElementById("totalPage").value);
	document.getElementById("pageNumber").value = totalpage+"";
	
	document.getElementById("data_form").submit();
} 
