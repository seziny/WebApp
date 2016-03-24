/**
 * Created by sezin on 3/22/16.
 */
angular.module('hello', ['ngRoute', 'ngResource', 'ngCookies'])
    .config(function($routeProvider, $httpProvider){
        $routeProvider.when('/', {
            templateUrl : 'home.html',
            controller : 'home',
            controllerAs: 'controller'
        }).when('/login', {
            templateUrl : 'login.html',
            controller : 'navigation',
            controllerAs: 'controller'
        }).when('/register', {
            templateUrl : 'register.html',
            controller : 'register',
            controllerAs: 'controller'
        }).when('/mybooks', {
            templateUrl : 'mybooks.html',
            controller : 'books',
            controllerAs: 'controller'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('home', function($http, $cookies) {
        var self = this;
        $http.get('/resource/').success(function(data){
            self.greeting = data;
        });
        self.currentUserName = $cookies.get("username");

        //self.messages = [];
        self.saveBook = function(){
            //var BookRecord = $resource('/account/', {username : self.currentUserName});
            //BookRecord.save(self.book);
            $http.put('/account/' + self.currentUserName , self.book).success(function(data){
                self.success = true;
                //self.messages.push({type:'success', msg: 'Book Saved!'});
            });
        };


    })
    .controller('books', function($http, $cookies){
        var self = this;
        self.messages = [];
        self.currentUserName = $cookies.get("username");
        $http.get('/account/' + self.currentUserName).success(function(data){

            self.messages = data;
        })

    })
    .controller('navigation', function($rootScope, $http, $location, $cookies) {
        var self = this;
        var authenticate = function(credentials, callback) {
            var headers = credentials ? {authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)} :{};

            $http.get('/user/', {headers : headers}).success(function(data){
                if(data.name){
                    $rootScope.authenticated = true;
                    $rootScope.username = data.username;
                } else{
                    $rootScope.authenticated = false;
                }
                callback() && callback();
            }).error(function(){
                $rootScope.authenticated = false;
                callback() && callback();
            });
        };

        authenticate();
        self.credentials = {};
        self.login = function(){
            authenticate(self.credentials, function () {
                if($rootScope.authenticated){
                    $location.path("/");
                    $rootScope.username = self.credentials.username;
                    $cookies.put("username", $rootScope.username);
                    self.error = false;
                } else{
                    $location.path("/login");
                    self.error = true;
                }

            });
        };

        self.logout = function(){
            $http.post('logout', {}).finally(function(){
                $rootScope.authenticated = false;
                $location.path("/");
            });
        }
    })
    .controller('register', function($resource, $rootScope, $location){
        var self = this;
        self.register = function(){
            var User = $resource('/account');
            User.save(self.user, function(data){
                self.success = true;
            });
        };

    });