angular.module('JWTDemoApp')

    .controller('ArticleController', function($http, $scope, AuthService) {

        $scope.checked = false;
        $scope.showAlert = false;

        var shoppingBasket = [];

        $http.get('api/articles').success(function(res) {
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

        // Först behöver vi ta reda på vilken user som är inloggad så ordern kan sätta rätt userid innan vi kan checka ut en order

        $scope.checkOut = function () {
            $scope.showAlert = true;
            console.log(shoppingBasket);
            shoppingBasket = [];
            console.log("Successful purchase");
            /*$http({
                url: '../api/orders',
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
                    }); */

        };
    });