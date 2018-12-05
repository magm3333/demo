angular.module('demo')
.factory('wsService',
		[ '$rootScope', 'URL_WS', '$timeout', '$interval', '$log', function($rootScope, URL_WS, $timeout, $interval, $log) {

			var fnConfig = function(stomp, topic, cb) {
				//Dump de la información e crudo!
				//$log.info("Stomp: suscribiendo a " + topic);
				stomp.subscribe(topic, function(payload, headers, res) {
					cb(payload, headers, res);
				});
			};

			return {
				initStompClient : function(topic, cb) {
					$rootScope.stomp.setDebug(function(args) {
						$log.log(args);
						if ($rootScope.stomp.sock.readyState > 1 && $rootScope.autenticado) {
							$log.info("Intentando reconexión con WSocket");
							fnConnect();
						}
					});
					var fnConnect = function() {
						$rootScope.stomp.connect(URL_WS).then(function(frame) {
							$log.info("Stomp: conectado a " + URL_WS);
							fnConfig($rootScope.stomp, topic, cb);
						});
					};

					fnConnect();

				},
				stopStompClient: function() {
					if($rootScope.stomp) 
						$rootScope.stomp.disconnect();
				}
			}

		} ]);