var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {
 
    $routeProvider
        .when('/nota', {
            templateUrl: 'app/notas/notas.html',
            controller: 'NotaCtrl',
        }).otherwise({ redirectTo:'/nota' }
                );

    });
        
        

