 function bottleValidationsCheck(input){
	alert();
	var battleNumber= input.battleName;
	var description = input.description;
	var sampleID= input.sampleID;
	var deaRegistrationId = input.deaRegistrationId;
	var maretialId= input.maretialId;
	var tare = input.tare;
	var tareId= input.tareId;
	var deaScheduleId = input.deaScheduleId;
	var contentUnitesId = input.contentUnitesId;
	var content = input.content;
	var customerEmpNo = input.customerEmpNo;
	var storageLocationId = input.storageLocationId;
	
	if (battleNumber && description && sampleID && deaRegistrationId && tare && tareId && deaScheduleId
			&& contentUnitesId && contentUnitesId && contentUnitesId && content && customerEmpNo && storageLocationId) 
		return true; 
	else 
		return false;
}
 
 function sampleLogoutValidationsCheck(input){

 	var battleNumber= input.bottleNumber;
 	var grossAmount = input.grossAmount;
 	var transactionDate= input.transactionDate;
 	var customerEmpNo = input.customerEmpNo;
 	var cssEmpNo = input.cssEmpNo;
 	var transactionLogRef= input.transactionLogRef;
 	var comment= input.comment;
 	
 	
 	if (battleNumber && grossAmount && transactionDate && customerEmpNo && cssEmpNo && transactionLogRef ) 
 		return true; 
 	else 
 		return false;
 }