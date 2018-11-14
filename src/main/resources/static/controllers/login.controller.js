angular.module('demo')
.controller('LoginFormController', ['$rootScope', '$scope','$log', '$uibModalInstance', 'coreService',  LoginFormController]);
function LoginFormController($rootScope, $scope, $log, $uibModalInstance, coreService) {
	$scope.title="Ingreso";
	$scope.user=$rootScope.user;
	$scope.login = function () {
		coreService.login($scope.user).then(
			function(resp){ 
				if(resp.status===200) {
					$rootScope.loginOpen=false;
					$uibModalInstance.close(false);
					$rootScope.user.name=resp.data.name;
					$rootScope.user.mail=resp.data.mail;
					$rootScope.user.roles = resp.data.roles;
					$rootScope.autenticado=true;
					if($rootScope.cbauth)
						$rootScope.cbauth();
				}else{
					$rootScope.autenticado=false;					
					$rootScope.user.roles=[];
					$rootScope.openLoginForm();
				}
			},
			function(respErr){
				$log.log(respErr);
			}
		);
	  };
}