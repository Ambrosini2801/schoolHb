app.controller('NotaCtrl', function ($scope, $http) {



    $scope.salvar = function (nome, data) {
        var data = {
            nomeAluno: nome,
            dataNascimento: data
        };

        $http.post('http://localhost:8080/alunos', data)
    };







});