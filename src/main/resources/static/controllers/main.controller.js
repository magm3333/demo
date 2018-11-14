angular.module('demo')
.controller('mainController',function($scope,$rootScope){
	$scope.titulo="Menú";
	$rootScope.authInfo();
	
});