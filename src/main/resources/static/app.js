angular.module('demo',[]);

angular.module('demo')
	.controller('ctrl-div1',function($scope,$interval){
		$scope.titulo="Este es el título real";
		$scope.numero=Math.random();
		$scope.size=12;
		
		$interval(function(){$scope.numero=Math.random();}  ,2000);
	}
);


//controller    <--(área de memoria, se llama $scope)--->   vista(html) 