var myapp= angular.module("myapp",[]);

//one controller

myapp.controller("homeCtrl",
		function($scope,$filter,$http){
	// an have timeout service
	//service as uppercaseFilter OR we can use as $Filter
	
	//$scope.myname="Ranjan"; // variable
	
	//$scope.myname=uppercaseFilter('Ranjan'); // filter and service as uppercaseFilter
	$scope.myname=$filter('lowercase')('Ranjan');//uppercase 

	$scope.studentLOVVisible=true;
	$scope.studentLOVInVisible=false;	
	$scope.classVisible=false;
	$scope.sectionVisible=false;
	$scope.teachingVisible=false;
	
	$scope.doOnChangeTab= function(){
		alert("ll");
	};
	
	
	$scope.categorys=[{id:1,name:'Student',continent:'student'},
		                {id:2,name:'Teaching Staff',continent:'teaching'},
		                {id:3,name:'Non-Teaching Staff',continent:'nonteaching'},
		                {id:4,name:'Deportments',continent:'deportments'}
		                ];
	
	  $scope.myData = {};   
	 $scope.myData.doClick = function($event) {
         alert("clicked: " + event.clientX + ", " + event.clientY);
         
         
     }
// On change event
	 $scope.myData.doOnChange = function($event) {
        var category=$scope.selectedcategory.continent;
        var classsearchValues = [{id:1,name:'10th Class',continent:'X'},
                                 {id:2,name:'9th Class',continent:'IX'}
                                 ];
        if(category ==="student"){
        	$scope.classVisible=true;
        	$scope.sectionVisible=true;
        	$scope.depVisible=false;
        	$scope.classname="Select Class :";        	
        	$scope.classsearch= classsearchValues;
        	$scope.sectionname="Select Section :";
        	$scope.sectionsearch=[{id:1,name:'A Section',continent:'A'},
      		                {id:2,name:'B Section',continent:'B'}
      		                ];
        	
        	
        }
        else if(category ==="teaching"){
        	$scope.classVisible=false;
        	$scope.sectionVisible=false;
        	$scope.depVisible=true;
        	$scope.depname="Select Deportment :";        	
        	$scope.depSearch= [{id:1,name:'English',continent:'Eng'},
                                 {id:2,name:'Telugu',continent:'tel'}
            ];
        	
        }
        else{
        	$scope.classVisible=false;
        	$scope.sectionVisible=false;
        	$scope.depVisible=false;
        }
        
         $scope.firstName = $scope.selectedcategory.continent;
         $scope.middleName = "Al";
         $scope.lastName = "Smith";
         // $scope.getFullName=[{id:1,firstName:"Ranjan"},{id:2,middleName:" a"},{id:3,lastName:" Avula"}];

         // Define utility functions
         $scope.getFullName = function ()
         {
           return $scope.firstName + " " + $scope.middleName + " " + $scope.lastName;
         };
     };
 // On click event ajax call to get data form the DB     
     $scope.getDataFromServer = function() {
         $http({
                 method : 'GET',
                 url : 'LoginServlet'
                // data: JSON.stringify(data),
         }).success(function(data, status, headers, config) {
        	 $scope.people = data;
        	 $scope.products = data;
        	 
        	  /*var myjson = JSON.parse(data);           
        	 console.log(data);
                 $scope.firstName = myjson.iteamId;
                 $scope.middleName = myjson.iteamName;*/
         }).error(function(data, status, headers, config) {
        	 console.log(data);
        	  var myjson = JSON.parse(data);
              $scope.products= JSON.parse(myjson);
                 // called asynchronously if an error occurs
                 // or server returns response with an error status.
         });

 };     
 $scope.myData.doOnChangeProduct = function(itemSelected) {
	 alert(itemSelected.iteamId);
	 var iteamId=itemSelected.iteamId;
	 var parameters = {
             keyword: itemSelected.iteamId
         };
	 var config = {
             params: parameters
         };
	 
     $http({
         method : 'GET',
         url : 'LoginServlet',
         data: {carrier_id: iteamId},
         params:{carrier_id: iteamId},
         headers: {
             'Content-Type': 'application/json'
         }

     	}).success(function(data, status, headers, config) {
	 		$scope.people = data;
	 		$scope.products = data;	
	 	}).error(function(data, status, headers, config) {
	 		console.log(data);
	 		var myjson = JSON.parse(data);
	 		$scope.products= JSON.parse(myjson);
         // called asynchronously if an error occurs
         // or server returns response with an error status.
 });
 };

	
});



myapp.controller("expand",
		function($scope,$filter,$http){
alert();



});
//myApp.factory('myService', function() {});

myapp.controller('SheetController', ['$scope', function($scope) {
    $scope.Price = true;

    $scope.canShow = function(field) {
        return $scope.Price;
    }

    $scope.setConfig = function(config) {
        $scope.Price = config.Price;
    }
}]);


myapp.controller("secondController",
		function($scope){
  // Initialize the model variables
 /* $scope.firstName = "Bob";
  $scope.middleName = "Al";
  $scope.lastName = "Smith";

  // Define utility functions
  $scope.getFullName = function ()
  {
    return $scope.firstName + " " + $scope.middleName + " " + $scope.lastName;
  };*/
});