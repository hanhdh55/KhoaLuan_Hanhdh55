function changeItemMenu() {
   var fullpath = window.location.pathname; // path bao gom ten Project "ServiceDirectory"
   var path = fullpath.substring(17, fullpath.length); // loai bo ten Project trong path
   
   if (path.indexOf("Programme") != -1) {
	   $("#twoChild").css("display", "block");
	   $("#programme").css("color", "orange");
   } else if (path.indexOf("GovOfficeRegion") != -1) {
	   $("#threeChild").css("display", "block");
	   $("#govOfficeReion").css("color", "orange");
   } else if (path.indexOf("TrustRegion") != -1 || path.indexOf("trustRegion") != -1 
		   || path.indexOf("trustDistrict") != -1 || path.indexOf("TrustDistrict") != -1) {
	   $("#threeChild").css("display", "block");
	   $("#trustReion").css("color", "orange");
   } else if (path.indexOf("Contact") != -1) {
	   $("#contact").css("color", "orange");
   } else if (path.indexOf("Service") != -1) {
	   $("#twoChild").css("display", "block");
	   $("#service").css("color", "orange");
   } else if (path.indexOf("Premise") != -1) {
	   $("#premise").css("color", "orange");
   } 
   
}