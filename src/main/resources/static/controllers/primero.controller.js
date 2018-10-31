angular.module('demo')
.controller('primeroController',function($scope,$rootScope,$sce){
	$scope.titulo="Productos";
	
	$scope.data=[
		{id:1, descripcion:'Leche', precio: 25.80, enStock:true, enOferta:true},
		{id:2, descripcion:'Arroz', precio: 18.70, enStock:true, enOferta:false},
		{id:3, descripcion:'Vino', precio: 105, enStock:false, enOferta:false},
		{id:4, descripcion:'Chupetín', precio: 5.30, enStock:true, enOferta:false}
	];
	
	$scope.ponerEnOferta=function() {
		$scope.data.forEach(function(o,i){
			if(o.id==$scope.id) {
				o.enOferta=true;
			}
		});
	};
});