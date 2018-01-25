angular.module('JWTDemoApp')

    .controller('TestController', function($http, $scope, AuthService) {

        $http.get('api/users/1').success(function(res) {
            $scope.users = res;
            console.log(res)
/*
            $scope.userForm.$setPristine();
            $scope.message='';
            $scope.appUser = null;
            $scope.buttonText = 'Create';
 */
        }).error(function(error) {
            $scope.message = error.message;
        });
  });