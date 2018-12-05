angular.module('demo')
.controller('graficoController',function($scope,$rootScope,wsService,$log,graphService){
	$scope.graphOptions = {
			demo : {
				options : {},
				data : {}
			}
	};

	$scope.procesaDatosGraph=function(datos){
		var labels=[];
		var data=[];
		datos.forEach(function(o,i){
			labels.push(o.label);
			data.push(o.value);
		});
		$scope.graphOptions.demo.data={data:data,labels:labels};
	};
	
	$scope.iniciaWS = function() {
		$log.log("Iniciando WS");
		wsService.initStompClient('/reedcons/graph',function(payload, headers, res){
			$log.log(payload);
			if(payload.type=='GRAPH_DATA_BAR') {
				$scope.procesaDatosGraph(payload.payload);
			}
			$scope.$apply();
		});
	};
	
	$rootScope.authInfo( $scope.iniciaWS );
	
	
	$scope.$on("$destroy", function() {
		 wsService.stopStompClient();
	});
	
	
	$scope.refrescar=function() {
		graphService.requestPushGraphData();
	};
});