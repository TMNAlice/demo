var app = angular.module('devices', []);

app.controller("deviceController", function ($scope, $http) {

    window.onload = function getJager() {
        var src = "resources/static/img/0_0_orig.jpg";
        show_image("resources/static/img/0_0_orig.jpg", 596,1400, "jager");
    }
    function show_image(src, width, height, alt) {
        var img = document.createElement("img");
        img.src = src;
        img.width = width;
        img.height = height;
        img.alt = alt;
        document.body.appendChild(img);
    }
    }
);
/*
    $scope.successDeleteSchoolCallback = function (response) {
        for (var i = 0; i < $scope.schoolsList.length; i++) {
            var j = $scope.schoolsList[i];
            if (j.id === $scope.deletedId) {
                $scope.schoolsList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage="";
    };

    $scope.errorDeleteSchoolCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete school; check if there are any related records exist. Such records should be removed first";
    };

    $scope.deleteSchool = function (id) {
        $scope.deletedId = id;
        $http.delete('/public/rest/schools/' + id).then($scope.successDeleteSchoolCallback, $scope.errorDeleteSchoolCallback);
    };


    $scope.successGetSchoolCallback = function (response) {
        $scope.schoolsList.splice(0, 0, response.data);
        $scope.errormessage="";
    };

    $scope.errorGetSchoolCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on school number "+$scope.inputnumber;
    };

    $scope.successAddSchoolCallback = function (response) {
        $http.get('/public/rest/schools/' + $scope.inputnumber).then($scope.successGetSchoolCallback, $scope.errorGetSchoolCallback);
        $scope.errormessage="";
    };

    $scope.errorAddSchoolCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to add new school; check if it's number is unique";
    };

    $scope.addSchool = function () {
        $http.post('/public/rest/schools/' + $scope.inputnumber + "/" + $scope.inputname).then($scope.successAddSchoolCallback, $scope.errorAddSchoolCallback);
    };

});*/
