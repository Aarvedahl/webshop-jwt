angular.module('JWTDemoApp')

    .controller('OrderController', function($http, $scope, AuthService) {

        var init = function() {
            $http.get('api/users').success(function(res) {
                $scope.users = res;
                $scope.message='';

            }).error(function(error) {
                $scope.message = error.message;

            });
        };


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
                        init();
                    },
                    function (response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };

        init();
    });