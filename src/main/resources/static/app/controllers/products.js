angular.module('JWTDemoApp')

    .controller('ArticleController', function($http, $scope, AuthService) {

        $scope.checked = false;
        $scope.showAlert = false;

        var shoppingBasket = [];

        $http.get('api/articles/user').success(function(res) {
            $scope.articles = res;

        }).error(function(error) {
            $scope.message = error.message;
        });


        $scope.addToCart = function (article) {
            shoppingBasket.push(article);
        };

        $scope.removeFromlist = function (article) {
            shoppingBasket.splice(shoppingBasket.indexOf(article), 1);
        };

        $scope.getShoppingCart = function () {
            return shoppingBasket;
        };

        $scope.checkOut = function () {
            $http({
                url: 'api/orders',
                method: "POST",
                data: shoppingBasket,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function(response) {
                        // success
                        $scope.showAlert = true;
                        shoppingBasket = [];

                    },
                    function(response) {
                        // failed
                        console.error(response);
                        console.log("Purchase not successfully made");
                    });

        };
    });