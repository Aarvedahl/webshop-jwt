angular.module('JWTDemoApp', [ 'ui.router' ])



.run(function(AuthService, $rootScope, $state) {
	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
		if (!AuthService.user) {
			if (toState.name != 'login' && toState.name != 'register') {
				event.preventDefault();
				$state.go('login');
			}
		}
	});
});