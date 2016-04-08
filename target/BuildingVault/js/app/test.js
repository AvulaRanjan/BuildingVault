/**
 * http://usejsdoc.org/
 */
angular.module('myapp', [])

.controller('firstCtrl', ['$scope', function($scope) {
  $scope.item = {
    star: false,
    favorite: false,
    bookmark: false
  };
}])

.directive('buttonStar', function() {
  return {
    scope: true,
    restrict: 'E',
    template: '<button class="btn btn-icon"><span class="glyphicon glyphicon-star" ng-class="{active: item.star}"></span></button>',
    link: function(scope, elem) {
      elem.bind('click', function() {
        scope.$apply(function(){
          scope.item.star = !scope.item.star;
          alert();
        });
      });
    }
  };
})

.directive('buttonFavorite', function() {
  return {
    scope: true,
    restrict: 'E',
    template: '<button class="btn btn-icon"><span class="glyphicon glyphicon-heart" ng-class="{active: item.favorite}"></span></button>',
    link: function(scope, elem) {
      elem.bind('click', function() {
        scope.$apply(function(){
          scope.item.favorite = !scope.item.favorite;
        });
      });
    }
  };
})

.directive('buttonBookmark', function() {
  return {
    scope: true,
    restrict: 'E',
    template: '<button class="btn btn-icon"><span class="glyphicon glyphicon-bookmark" ng-class="{active: item.bookmark}"></span></button>',
    link: function(scope, elem) {
      elem.bind('click', function() {
        scope.$apply(function(){
          scope.item.bookmark = !scope.item.bookmark;
        });
      });
    }
  };
});