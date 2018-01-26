angular.module('JWTDemoApp')

    .controller('AdminArticleController', function ($http, $scope, AuthService) {

        $scope.checked = false;
        $scope.showAlert = false;


        $http.get('api/articles').success(function(res) {
            $scope.articles = res;
            $scope.message='';

        }).error(function(error) {
            $scope.message = error.message;

        });

        $scope.editArticle = function (article) {
            $scope.checked = true;
            $scope.tempArticleData = {
                articleid: article.articleid,
                articlename: article.articlename,
                brand: article.brand,
                price: article.price,
                description: article.description
            };
        };

        $scope.addArticle = function (articleToAdd) {
            $http({
                url: 'api/articles',
                method: "POST",
                data: articleToAdd,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        // success
                        $scope.showAlert = true;
                        $scope.articles = response.data;
                        $scope.checkedFalse();
                    },
                    function (response) {
                        // failed
                        console.error(response);
                    });

        };

        $scope.deleteArticle = function (articleToDelete) {
            $http({
                url: 'api/articles',
                method: "DELETE",
                data: articleToDelete,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        $scope.showAlert = true;
                        $scope.articles = response.data;
                    },
                    function (response) {
                        // failed
                        console.error(response);
                    });
        };

        $scope.updateArticle = function (articleToUpdate) {
            $http({
                url: 'api/articles',
                method: "PATCH",
                data: articleToUpdate,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        // success
                        $scope.showAlert = true;
                        $scope.articles = response.data;
                        $scope.checkedFalse();
                    },
                    function (response) {
                        // failed
                        console.error(response);
                    });
        };

        $scope.checkedFalse = function () {
            $scope.checked = false;
            $scope.tempArticleData = {};
        };

        $scope.checkedTrue = function () {
            $scope.checked = true;
        };

    });