
var schoolapp= angular.module("schoolapp",[]);


schoolapp.controller("MenuController", function($scope, $http) {
	$scope.menus=[{
		title:"Student",
		action: "#",
		studentmenus:[{
			title:"Student Marks",
			action:"sm"
		},{
			title:"Student Attendence",
			action:"sa"
		}]
	},{
		title:"Staff",
		action: "#",
		studentmenus:[{
			title:"Staff Subjects",
			action:"ss"
		},{
			title:"Staff Attendence",
			action:"sa"
		}]
	},{
		title:"Non Staff",
		action: "#",
		studentmenus:[{
			title:"Work type",
			action:"wt"
		},{
			title:"Non Staff Attendence",
			action:"nsa"
		}]
	},{}]

});


