angular.module('JWTDemoApp').config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/page-not-found');
    $stateProvider.state('nav', {
        abstract: true,
        url: '',
        views: {
            'nav@': {
                templateUrl: 'app/views/nav.html',
                controller: 'NavController'
            }
        }
    }).state('login', {
        parent: 'nav',
        url: '/login',
        views: {
            'content@': {
                templateUrl: 'app/views/login.html',
                controller: 'LoginController'
            }
        }
    }).state('home', {
        parent: 'nav',
        url: '/',
        views: {
            'content@': {
                templateUrl: 'app/views/home.html',
                controller: 'HomeController'
            }
        }
    }).state('page-not-found', {
        parent: 'nav',
        url: '/page-not-found',
        views: {
            'content@': {
                templateUrl: 'app/views/page-not-found.html',
                controller: 'PageNotFoundController'
            }
        }
    }).state('products', {
        parent: 'nav',
        url: '/products',
        views: {
            'content@': {
                templateUrl: 'app/views/products.html',
                controller: 'ArticleController'
            }
        }
    }).state('orders', {
        parent: 'nav',
        url: '/orders',
        views: {
            'content@': {
                templateUrl: 'app/views/orders.html',
                controller: 'OrderController'
            }
        }
    }).state('articles', {
        parent: 'nav',
        url: '/articles',
        views: {
            'content@': {
                templateUrl: 'app/views/articles.html',
                controller: 'AdminArticleController'
            }
        }
    }).state('register', {
        parent: 'nav',
        url: '/register',
        views: {
            'content@': {
                templateUrl: 'app/views/register.html',
                controller: 'RegisterController'
            }
        }
    });
});
