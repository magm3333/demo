var app=angular.module('demo',['ngRoute']);

app.filter(
		'highlight',
		function($sce) {
			return function(text, phrase) {
				if (phrase && text) {
					text += '';
					text = text.replace(new RegExp('(' + phrase + ')', 'gi'),
							'<span style="background-color: yellow">$1</span>');
				}

				return $sce.trustAsHtml(text);
			}
		});

app.run(['$rootScope','$log','$location',function($rootScope,$log,$location){
	$log.log('Iniciando aplicación');
	$rootScope.titulo="Valor por defecto";
	$rootScope.relocate=function(loc){
		$location.path(loc);
	};
}]);

app.controller('ctrl-div1',function($scope,$interval){
		$scope.titulo="Este es el título real";
		$scope.numero=Math.random();
		$scope.size=12;
		
		$scope.cantidad=0;
		
		$scope.intervalo=$interval(
			function(){
				$scope.cantidad++;
				$scope.numero=Math.random();
				if($scope.cantidad==3)
					$interval.cancel($scope.intervalo);
			}  
			,2000);
	}
);

app.controller('ctrl-div2',function($scope){
	
});


//controller    <--(área de memoria, se llama $scope)-->   vista(html) 