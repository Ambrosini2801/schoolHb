
app.controller('HomeCtrl', function($scope){
    $scope.title = 'Bem-vindo ao nosso gerador de boletim!';
});

app.controller('CadastroCtrl', function($scope){
    });

    app.controller('NotaCtrl', function ($scope, $http) {

        $scope.salvar = function (nome, data) {
            var data = {
                nomeAluno: nome,
                dataNascimento: data
            };

    app.controller('DisciplinasCtrl', function ($scope, $http){
        $scope.salvar = function (disciplinas){
            var disciplinas = disciplinas
        };
    })        

app.controller('BoletimCtrl', function($scope){
    $scope.title = 'Aqui você vai gerar o boletim!';
});


$http.post('http://localhost:8080/alunos', data)
};

});