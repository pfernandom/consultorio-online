var app = angular.module('main',['ui.bootstrap','formly', 'formlyBootstrap','ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  $urlRouterProvider.otherwise("/");
  //
  // Now set up the states 
  $stateProvider
    .state('home', {
    	url: "/",
    	templateUrl: "html/home.html"
    })
    .state('patients', {
        url: "/patient",
        template: "<h2>Patient list</h2><patient-list></patient-list>"
     })
     .state('newPatient', {
        url: "/patient/create",
        template: "<patient-form></patient-form>"
     })
     .state('patientDetail', {
        url: "/patient/detail",
        templateUrl: "html/patientDetail.html"
     });
});

app.controller('MainCtrl',function(){
	 var vm = this;

  vm.user = {};

  // note, these field types will need to be
  // pre-defined. See the pre-built and custom templates
  // http://docs.angular-formly.com/v6.4.0/docs/custom-templates
  vm.userFields = [
    {
      key: 'email',
      type: 'input',
      templateOptions: {
        type: 'email',
        label: 'Email address',
        placeholder: 'Enter email'
      }
    },
    {
      key: 'password',
      type: 'input',
      templateOptions: {
        type: 'password',
        label: 'Password',
        placeholder: 'Password'
      }
    },
    {
      key: 'checked',
      type: 'checkbox',
      templateOptions: {
        label: 'Check me out'
      }
    }
  ];
	
});