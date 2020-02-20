var app = angular.module('app', ['ngRoute']);
app.config(function ($routeProvider) {
    $routeProvider

        .when('/', {
            templateUrl : 'app/views/home.html',
            controller  : 'HomeCtrl',
        })
    
        .when('/cadastro', {
            templateUrl : 'app/views/cadastro.html',
            controller  : 'CadastroCtrl',
        })
    
        .when('/boletim', {
            templateUrl : 'app/views/boletim.html',
            controller  : 'BoletimCtrl',
        })
    
        .otherwise ({ redirectTo: '/' });
    });
