/**
 * 
 */

myapp.factory('BottleService', ['$http', '$q', function($http, $q,data){
	return {
		fetchAllUsers: function() {
			return $http.get('./fetchInitalData.htm', data)
					.then(
							function(response){
								//$scope.fetchInitalDataResponse($scope,data);
								return response.data;
							}, 
							function(errResponse){
								//console.error('Error while fetching users');
								return $q.reject(errResponse);
							}
					);
	}
		
		}
	
	
	
	
}]);