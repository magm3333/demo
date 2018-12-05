angular.module('demo')
.factory('graphService',
	function($http,URL_API_BASE){
		return {
			requestPushGraphData:function(){
				return $http.get(URL_API_BASE+'graph/push');
			}
			
		}
	}
);