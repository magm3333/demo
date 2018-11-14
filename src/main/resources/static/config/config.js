angular.module('demo')
.config(function($routeProvider,$httpProvider){
	
	$httpProvider.interceptors.push('APIInterceptor');
	$httpProvider.defaults.withCredetials=true;
	
	$routeProvider
		.when('/main',{
			templateUrl: 'views/main.html',
			controller: 'mainController'
		})
		.when('/productos',{
			templateUrl: 'views/productos.html',
			controller: 'productosController'
		})
		.when('/c1',{
			templateUrl: 'views/vista1.html',
			controller: 'primeroController'
		})
		.when('/c2',{
			templateUrl: 'views/vista2.html',
			controller: 'segundoController'
		})
		.otherwise({
			redirectTo: '/main'
		});
});