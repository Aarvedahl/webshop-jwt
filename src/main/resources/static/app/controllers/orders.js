angular.module('JWTDemoApp')

    .controller('OrderController', function($http, $scope, AuthService) {

        $http.get('api/users').then(function (response) {
            $scope.users = response.data;
        });

        $scope.removeUser = function (user) {
            $http({
                url: 'api/users',
                method: "DELETE",
                data: user,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        // success
                        $scope.showAlert = true;
                        $scope.users = response.data;

                    },
                    function (response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };

        $scope.cancelOrder = function (user, order) {
            delete order.articleList;
            order.userid = user.userid;
            order.canceled = !order.canceled;
            $http({
                url: 'api/orders',
                method: "PATCH",
                data: order,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        // success
                        $http.get('http://localhost:8080/api/users').then(function (response) {
                            $scope.users = response.data;
                        });
                    },
                    function (response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };


    });