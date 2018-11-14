angular.module('demo')
.service('APIInterceptor',function($rootScope){
	var self=this;
	self.responseError=function(response) {
		console.log(response)
		if(response.status==401) {
			$rootScope.openLoginForm();
		} else {
			$rootScope.authInfo();
		}
		return response;
	}
});