
var myapp= angular.module("myapp",[]);

//one controller
myapp.controller("createNewBottleCtrl",function($scope,$filter,$http){	
	$scope.data= {};
	$scope.unites='g (grams)';
    $scope.battleName={}; // variable	
	$scope.visible=true;
	$scope.createBottleVisible=false;
	$scope.prelogoutVisible=false;	
	$scope.sampleLoginVisible=false;	
	$scope.sampleLogoutVisible=false;	
	$scope.materialTypesVisible=false
	$scope.toShow =false;
	$scope.grossAmount=0.00;
	$scope.formData = {};
	$scope.menuheaders=[{id:1,name:'Enter a New Bottle to the Vault',continent:'newbottleform'},
	                {id:2,name:'Pre-Logout Information',continent:'prelogoutInfo'},
	                {id:3,name:'Sample-Logout Form',continent:'samplelogoutform'},
	                {id:4,name:'Sample-Log In',continent:'sampleloginform'},
	                {id:5,name:'Dispense Sample',continent:'loginform'},
	                {id:6,name:'Distroyed/ Consumed /Transfferred Menu...',continent:'distroyed'},
	                {id:7,name:'Reports Menu ...',continent:'reportsform'},
	                {id:8,name:'Inventory / Maintence Menu ',continent:'maintenceMenu'}
	                ];
	 
	 $scope.fetchInitialData = function($event,continentType) {
		var selectedvalue=$event;
		
		$scope.inputvalues =continentType;
		 if(selectedvalue === 1 && continentType === 'newbottleform'){
			 	$scope.onClickActivePage($scope,$http);
			 	$scope.createBottleVisible=true;	
				$scope.prelogoutVisible=false;	
				$scope.sampleLoginVisible=false;	
				$scope.sampleLogoutVisible=false;
				$scope.toShow = false;
				$scope.submenuheaders=[];
				$scope.destructionFormVisible=false;
				$scope.consumptionFormVisible=false;
				$scope.transferFormVisible=false;
				$scope.deaFormVisible=false;
				$scope.destructiondatesVisible=false;
		} else  if(selectedvalue === 2  && continentType === 'prelogoutInfo'){				 
				$scope.prelogoutVisible=true;
				$scope.createBottleVisible=false;				
				$scope.sampleLoginVisible=false;	
				$scope.sampleLogoutVisible=false;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope,$http);
				$scope.toShow = false;	
				$scope.destructionFormVisible=false;
				$scope.consumptionFormVisible=false;
				$scope.transferFormVisible=false;
				$scope.deaFormVisible=false;
				$scope.destructiondatesVisible=false;
		 } else  if(selectedvalue === 3  && continentType === 'samplelogoutform'){	
				$scope.sampleLoginVisible=false;	
				$scope.createBottleVisible=false;
				$scope.prelogoutVisible=false;				
				$scope.continuePageVisible=false;
				$scope.toShow = false;		
				$scope.sampleLogoutVisible=true;
				$scope.onClickActivePage($scope,$http);
				$scope.destructionFormVisible=false;
				$scope.consumptionFormVisible=false;
				$scope.transferFormVisible=false;
				$scope.deaFormVisible=false;
				$scope.destructiondatesVisible=false;
		 }else  if(selectedvalue === 4 && continentType === 'sampleloginform'){			
				$scope.sampleLogoutVisible=false;	
				$scope.createBottleVisible=false;
				$scope.prelogoutVisible=false;	
				$scope.sampleLoginVisible=true;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope,$http);
				$scope.toShow = false;
				$scope.destructionFormVisible=false;
				$scope.consumptionFormVisible=false;
				$scope.transferFormVisible=false;
				$scope.deaFormVisible=false;
				$scope.destructiondatesVisible=false;
		}else  if(selectedvalue === 6 && continentType === 'distroyed'){
			 $scope.activeSubmenuHeaders($scope,$http);
		 	};
		  }
	  	  
	   			/* This function will call For Determining value Whether you select the Value (IsSelected)*/
	    		$scope.whetherValueIsSelected = function (value) {
	    	    console.log($scope.mySelectedValue);
	    		};
	    		/* This function will call to initialize the select the Value and return the value*/
	    		$scope.someInitFunc = function () {
	    		 // var selectedValu=$scope.deaRegistrationId;
	    	    return 'selectedValu';
	    		};
		  
		    	  $scope.inputFormValidate = function(input){
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
				    	}	;
				    
				    $scope.simpleformlogoutValidate = function(input){
				    	return true; 
				    }
				    
				    $scope.continueTrasactionPage = function($scope,$http){
				     	$scope.visible=true;	     	
					 //	console.log($scope.formData.battleName);
					    $scope.continueFunction = function($event,$http) {
						     if($event ==0){
						      $scope.visible=false;	
						   		 $scope.invisible=true;
						   		$scope.continuePageVisible=true;
						   		$scope.buttonName="Hide";
						   		console.log($scope.battleName);
						     	}
						      else if($event ==1){
						        $scope.visible=false;	
						   		 $scope.invisible=false;
						   		$scope.continuePageVisible=false;
						   		$scope.buttonName="Show";
						      	} 
					     	}
				    	 }				    
				    $scope.activeSubmenuHeaders= function($scope,$http){						
						$scope.sampleLogoutVisible=false;	
						$scope.createBottleVisible=false;
						$scope.prelogoutVisible=false;	
						$scope.sampleLoginVisible=false;
						$scope.continuePageVisible=false;
						//$scope.onClickActivePage($scope,$http);
						//$scope.toShow = true;
						var flag =$scope.toShow;
						if(flag){							
						    $scope.toShow = false;
						    $scope.destructionFormVisible=false;
							$scope.consumptionFormVisible=false;
							$scope.transferFormVisible=false;
							$scope.deaFormVisible=false;
							$scope.destructiondatesVisible=false;
						}
						if(!flag){							
							$scope.toShow = true;
						}
						$scope.submenuheaders=[{id:9,name:'Sample Destruction Form (action by CSS)',continent:'sampleDestructionForm'},
								               {id:10,name:'Sample Consumption Form(action by customer)',continent:'sampleConsumptionForm'},
								               {id:11,name:'Sample Transfer Form',continent:'sampleTransferForm'},
								               {id:12,name:'DEA Form 41 Destruction by date',continent:'deaForm'},
								               {id:13,name:'Destruction dates',continent:'Destructiondates'},
								               {id:14,name:'Main Menu ... ',continent:'MainMenu'}
								                ];	 
				    }
				     $scope.fetchSubmenuInitalData = function($event,continentType) {
						var selectedvalue=$event;
						$scope.inputvalues =continentType;					
						 if(selectedvalue === 9 && continentType === 'sampleDestructionForm'){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=true;
								$scope.consumptionFormVisible=false;
								$scope.transferFormVisible=false;
								$scope.deaFormVisible=false;
								$scope.destructiondatesVisible=false;
						 }
						 else if(selectedvalue === 10 && continentType === 'sampleConsumptionForm'){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=false;
								$scope.consumptionFormVisible=true;
								$scope.transferFormVisible=false;
								$scope.deaFormVisible=false;
								$scope.destructiondatesVisible=false;
							//	$scope.basicCheckValue=false;
						 }
						 else if(selectedvalue === 11 && continentType === 'sampleTransferForm'){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=false;
								$scope.consumptionFormVisible=false;
								$scope.transferFormVisible=true;
								$scope.deaFormVisible=false;
								$scope.destructiondatesVisible=false;
						 }
						 else if(selectedvalue === 12 && continentType === 'deaForm'){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=false;
								$scope.consumptionFormVisible=false;
								$scope.transferFormVisible=false;
								$scope.deaFormVisible=true;
								$scope.destructiondatesVisible=false;
						 }
						 else if(selectedvalue === 13 && continentType === 'Destructiondates'){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=false;
								$scope.consumptionFormVisible=false;
								$scope.transferFormVisible=false;
								$scope.deaFormVisible=false;
								$scope.destructiondatesVisible=true;
						 }
						 else if(selectedvalue === 14 && continentType === ''){
							 $scope.onClickActivePage($scope,$http);
							 	$scope.createBottleVisible=false;	
								$scope.prelogoutVisible=false;	
								$scope.sampleLoginVisible=false;	
								$scope.sampleLogoutVisible=false;
								$scope.toShow = true;
								$scope.destructionFormVisible=false;
								$scope.consumptionFormVisible=false;
								$scope.transferFormVisible=false;
								$scope.deaFormVisible=false;
								$scope.destructiondatesVisible=false;
						 }
					 }

					    $scope.onClickActivePage = function($scope,$http){
					    	// On click event ajax call to get data form the DB     
						    // $scope.getDataFromServer = function() {
					    	var input=$scope.inputvalues;
						         $http({
						                 method : 'GET',
						                 url : './fetchInitalData.htm',
						                 params: {"selectedOption": $scope.inputvalues},
						                  // pass in data as strings
						                /* data: {"selectedOption": $scope.selectedvalue},
						                 params:{"namep": $scope.selectedvalue},*/
						                 headers: {
						                         'Content-Type': 'application/json'
						                     }		         
						         }).success(function(response) {
						        	 $scope.fetchInitalDataResponse(response);
						        	 $scope.object = response;                                                                        
				                     console.log(response);
						         }).error(function(data, status, headers, config) {
						        	 console.log(data);
						        	 
						                 // called asynchronously if an error occurs
						                 // or server returns response with an error status.
						         });	
					    }
					    
						  $scope.fetchInitalDataResponse = function (response) {
							  var data= response;
							  var action = data.actionName
							  if(action === "newbottleform"){
										 $scope.maretialTypeList=data.maretialTypeList;     	
								     	 $scope.tareTypeList=data.tareTypeList
								     	 $scope.deaRegistrationList=data.deaRegistrationList     	 
								     	 $scope.deaScheduleList=data.deaScheduleList
								     	 $scope.ownersList=data.ownersList
								     	 $scope.dispositionList=data.dispositionList
								     	 $scope.checkoutRestrictionList=data.checkoutRestrictionList
								     	 $scope.contentUnitesList=data.contentUnitesList
								     	 $scope.storageLocationList=data.storageLocationList
									  }
							  else if(action === "samplelogoutform"){
									 $scope.simpleFormList=data.simpleFormList;  
									 console.log(data.simpleFormList);			     	 
								  }
							  else if(action === "sampleloginform"){
									 $scope.simpleFormList=data.simpleFormList;  
									 console.log(data.simpleFormList);			     	 
								  }
							  else if(action === "sampleDestructionForm"){
									 $scope.simpleFormList=data.simpleFormList;  
									 console.log(data.simpleFormList);			     	 
								  }
							  else if(action === "sampleConsumptionForm"){
									 $scope.simpleFormList=data.simpleFormList;  
									 console.log(data.simpleFormList);			     	 
								  }
							  else if(action === "sampleTransferForm"){
									 $scope.simpleFormList=data.simpleFormList;  
									 console.log(data.simpleFormList);			     	 
								  }
						   	};
						    $scope.saveFromData = function($event,$scope,item) {
						    	  var selectedvalue=item;
						    	  $scope.actionName=$event;
						    	  if($scope == undefined){
						    		//  $scope.create.msg="Please check all the input value";
						    	    }
								  else{
									  var input = $scope;
									  if($event === 'newbottleform')
									  var vali= this.inputFormValidate(input);
									  else if($event === 'simpleformlogout')
										  var vali= this.simpleformlogoutValidate(input);
									  else if($event === 'sampleDestructionForm')
										  var vali= this.simpleformlogoutValidate(input);
									  else if($event === 'sampleConsumptionForm')
										  var vali= this.simpleformlogoutValidate(input);
									  else if($event === 'sampleTransferForm')
										  var vali= this.simpleformlogoutValidate(input);
									  
										 if(selectedvalue === 'Save' && vali){							
											 // On click event ajax call to SAVE data into the DB     
											    // $scope.getDataFromServer = function() {
											         $http({
											                 method : 'GET',
											                 url : './saveBottle.htm',
											                // data: $scope,
											                 params:$scope,
											                 headers: {
											                         'Content-Type': 'application/json'
											                     }
											                /* data: {carrier_id: battleName},
											                 params:{carrier_id: battleName},
											                 headers: {
											                         'Content-Type': 'application/json'
											                     }*/
											         }).success(function(response) {
											        	   $scope.reset();
											        	 $scope.msg=response.message;
											        	 
											        	// $scope.fetchInitalDataResponse($scope,data);							        	
											         }).error(function(data, status, headers, config) {
											        	 console.log(data);							        	 
											                 // called asynchronously if an error occurs
											                 // or server returns response with an error status.
											         });
											      
											    }
									    	  };
									    	  $scope.reset = function() {
									    		  $scope.actionName="";
									    		  $scope.bottleNumber="";
									    		  $scope.comment="";
									    		  $scope.cssEmpNo="";
									    		  $scope.customerEmpNo="";
									    		  $scope.grossAmount="";
									    		  }
									 	     
						    	 
						    	  };// End saveNewBottle function
						    	 
				    
});


