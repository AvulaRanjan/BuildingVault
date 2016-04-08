var bottleapp = angular.module('bottleapp',[]);
bottleapp.controller('BottleController', ['$scope', 'BottleService', function($scope, BottleService) {
	
	var self = this;
	$scope.menuheaders=[{id:1,name:'Enter a New Bottle to the Vault',continent:'newbottleform'},
		                {id:2,name:'Pre-Logout Information',continent:'prelogoutInfo'},
		                {id:3,name:'Sample-Logout Form',continent:'samplelogoutform'},
		                {id:4,name:'Sample-Log In',continent:'sampleloginform'},
		                {id:5,name:'Dispense Sample',continent:'loginform'},
		                {id:6,name:'Distroyed/ Consumed /Transfferred Menu...',continent:'distroyed'},
		                {id:7,name:'Reports Menu ...',continent:'reportsform'},
		                {id:8,name:'Inventory / Maintence Menu ',continent:'maintenceMenu'}
		                ];
		
    
    $scope.fetchAllUsers = function($event){
    	 var selectedvalue=$event;
			// $scope.selectedvalue = selectedvalue;
		 if(selectedvalue === 1){	

    	BottleService.fetchAllUsers()
            .then(
					       function(d) {
						       // self.users = d;
					       },
      					function(errResponse){
      						console.error('Error while fetching Currencies');
      					}
			       );
		 }
    };
    console.log( $scope.fetchAllUsers);
    
}]);