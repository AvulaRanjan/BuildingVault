
var myapp= angular.module("myapp",[]);

//one controller
//myapp.controller("createNewBottleCtrl",function($scope,$filter,$http){
	
	myapp.controller('createNewBottleCtrl', ['$scope', 'BottleService', function($scope, BottleService) {
	// an have timeout service
	//service as uppercaseFilter OR we can use as $Filter
	$scope.data= {};
	$scope.unites='g (grams)';
    $scope.battleName={}; // variable
	//$scope.msg=true;
	//$scope.myname=uppercaseFilter('Ranjan'); // filter and service as uppercaseFilter
	//$scope.myname=$filter('lowercase')('Ranjan');//uppercase 
	//$scope.message='';
	$scope.visible=true;
	$scope.createBottleVisible=false;
	$scope.prelogoutVisible=false;	
	$scope.sampleLoginVisible=false;	
	$scope.sampleLogoutVisible=false;	
	$scope.materialTypesVisible=false
	$scope.toShow = false;
	$scope.menuheaders=[{id:1,name:'Enter a New Bottle to the Vault',continent:'newbottleform'},
	                {id:2,name:'Pre-Logout Information',continent:'prelogoutInfo'},
	                {id:3,name:'Sample-Logout Form',continent:'samplelogoutform'},
	                {id:4,name:'Sample-Log In',continent:'sampleloginform'},
	                {id:5,name:'Dispense Sample',continent:'loginform'},
	                {id:6,name:'Distroyed/ Consumed /Transfferred Menu...',continent:'distroyed'},
	                {id:7,name:'Reports Menu ...',continent:'reportsform'},
	                {id:8,name:'Inventory / Maintence Menu ',continent:'maintenceMenu'}
	                ];
	
	
	
	 $scope.formData = {};
	 $scope.fetchAllUsers = function($event,continentType) {
			 var selectedvalue=$event;
		 //$scope.inputvalues.type=selectedvalue;
		 $scope.inputvalues =continentType;
		// var inputvalues=[{selectedvalue:,continent:continentType}];
		 if(selectedvalue === 1 && continentType === 'newbottleform'){
			 	$scope.onClickActivePage($scope);
			 	$scope.createBottleVisible=true;	
				$scope.prelogoutVisible=false;	
				$scope.sampleLoginVisible=false;	
				$scope.sampleLogoutVisible=false;
				$scope.materialTypesVisible=true;
				$scope.toShow = false;
				$scope.submenuheaders=[];
				
			 
		 }
		 else  if(selectedvalue === 2  && continentType === ''){	
			 
				$scope.prelogoutVisible=true;
				$scope.createBottleVisible=false;				
				$scope.sampleLoginVisible=false;	
				$scope.sampleLogoutVisible=false;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope,$http);
				$scope.toShow = false;
				
		 }
		 else  if(selectedvalue === 3  && continentType === 'samplelogoutform'){	
			// $scope.activeCreateBottlepage($scope,$http);
				$scope.sampleLoginVisible=false;	
				$scope.createBottleVisible=false;
				$scope.prelogoutVisible=false;						
				$scope.sampleLogoutVisible=true;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope,$http);
				$scope.toShow = false;
				
		 }else  if(selectedvalue === 4){			
				$scope.sampleLogoutVisible=false;	
				$scope.createBottleVisible=false;
				$scope.prelogoutVisible=false;	
				$scope.sampleLoginVisible=true;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope,$http);
				
				
		 }
		 else  if(selectedvalue === 6){			
				$scope.sampleLogoutVisible=false;	
				$scope.createBottleVisible=false;
				$scope.prelogoutVisible=false;	
				$scope.sampleLoginVisible=false;
				$scope.continuePageVisible=false;
				$scope.onClickActivePage($scope);
				$scope.toShow = true;
				$scope.submenuheaders=[{id:1,name:'Sample Destruction Form (action by CSS)',continent:'SampleDestructionForm'},
						                {id:2,name:'Sample Consumption Form(action by customer)',continent:'SampleConsumptionForm'},
						                {id:3,name:'Sample Transfer Form',continent:'SampleTransferForm'},
						                {id:3,name:'DEA Form 41 Destruction by date',continent:'DEAForm'},
						                {id:3,name:'Destruction dates',continent:'Destructiondates'},
						                {id:8,name:'Main Menu ... ',continent:'MainMenu'}
						                ];
				
				
		 };
		 
		
	    }
	  
	    $scope.onClickActivePage = function($scope){
	    	var input=$scope.inputvalues;
	    	var params= {"selectedOption": $scope.inputvalues};
	    	var url = './fetchInitalData.htm';
	    	var parameters = {
	                keyword: $scope.inputvalues
	            };
	            var config = {
	                params: params
	            };
	    	 
	    	BottleService.fetchAllUsers(parameters)
            .then(
					       function(d) {
						        self.users = d;
					       },
      					function(errResponse){
      						console.error('Error while fetching Currencies');
      					}
			       );
	    	/*
	    	
		//	$scope.continueTrasactionPage($scope,$http);
	    	// On click event ajax call to get data form the DB     
		    // $scope.getDataFromServer = function() {
	    	var input=$scope.inputvalues;
		         $http({
		                 method : 'GET',
		                 url : './fetchInitalData.htm',
		                 params: {"selectedOption": $scope.inputvalues},
		                  // pass in data as strings
		                 data: {"selectedOption": $scope.selectedvalue},
		                 params:{"namep": $scope.selectedvalue},
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
			
	    	
	    */}
	    
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
			  if(action === "samplelogoutform"){
					 $scope.simpleFormList=data.simpleFormList;  
					 console.log(data.simpleFormList);
			     	 
				  }
			  
	     	};
		
	    
			  
	   /* This function will call For Determining value Whether you select the Value (IsSelected)*/
	  
	    	$scope.whetherValueIsSelected = function (value) {
	    	    console.log($scope.mySelectedValue);
	    	  };
	    	  
	    /* This function will call to initialize the select the Value and return the value*/
	    	  $scope.someInitFunc = function () {
	    		 // var selectedValu=$scope.deaRegistrationId;
	    	    return 'selectedValu';
	    	  };
		    $scope.saveNewBottle = function($event,$scope,item) {
		    	  var selectedvalue=item;
		    	//  $scope.buttonActionName="Save";
		    	  if($scope == undefined){
		    		//  $scope.create.msg="Please check all the input value";
		    	    }
				  else{
					  var input = $scope;
					  var vali= this.inputMyValidate(input);
						 
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
							        	 $scope.msg=response.message;
							        	// $scope.fetchInitalDataResponse($scope,data);
							        	
							         }).error(function(data, status, headers, config) {
							        	 console.log(data);
							        	 
							                 // called asynchronously if an error occurs
							                 // or server returns response with an error status.
							         });
							       
								 
   	
						 		}
					    	  };
					    	     
		    	 
		    	  };// End saveNewBottle function
		    	  $scope.inputMyValidate = function(input){
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
				    			&& contentUnitesId && contentUnitesId && contentUnitesId && content && customerEmpNo && storageLocationId) {
				    		
				    		return true; 
				    		} 
				    	else {
				    		return false;
				    	}
				    									    	
				    	
				    }	;	
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
				    
				    
}]);


