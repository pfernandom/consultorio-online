var app = angular.module('main');

$(function() {
	$(".sortable").sortable({
		revert : true
	});
	$(".draggable").draggable({
		// connectToSortable: "#sortable",
		// helper: "clone",
		revert : "invalid"
	});
	$("ul, li").disableSelection();
});

app.directive('sortable', function() {
	return {
		/*
		 * scope: { name: '=' }, controller: function () { this.name = 'Pascal'; },
		 * controllerAs: 'ctrl', bindToController: true, template: '<div>{{ctrl.name}}</div>'
		 */
		link : function($scope, element, attrs) {
			element.sortable({
				revert : true,
				cursor : "move"

			});
		}
	};
});

app.directive('navigation', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'navigationController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/navigation.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('navigationController', [ 'UserService', function(UserService) {
	var ctrl = this;
	ctrl.user = UserService.getLoggedUser();
} ]);

app.directive('idCard', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'idCardController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/identification.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('idCardController', [ 'PatientService', function(PatientService) {
	var ctrl = this;
	ctrl.person = PatientService.getPerson();
} ]);

app.directive('idStatus', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'idStatusController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/status.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('idStatusController', [ 'PatientService',
		function(PatientService) {
			var ctrl = this;
			ctrl.person = PatientService.getPerson();
		} ]);

app.directive('idAppointments', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'idAppointmentsController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/appointments.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('idAppointmentsController',['PatientService', function(PatientService) {
	var ctrl = this;
	ctrl.person = PatientService.getPerson();
	ctrl.previousDiagnostic = ctrl.person.appointments.previous.diagnostic;

	var isToday = function() {
		var inputDate = new Date(
				ctrl.person.appointments.next.date);
		var todaysDate = new Date();
		var tomorrow = new Date();

		tomorrow.setDate(todaysDate.getDate() + 1);

		if (inputDate.setHours(0, 0, 0, 0) == todaysDate
				.setHours(0, 0, 0, 0)) {
			ctrl.today = true;
		} else if (inputDate.setHours(0, 0, 0, 0) == tomorrow
				.setHours(0, 0, 0, 0)) {
			ctrl.tomorrow = true;
		}
	};

	isToday();
} ]);

app.directive('medicalHistory', [ '$window', function($window) {
	return {
		scope : {
		// name: '='
		},
		controller : 'medicalHistoryController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/medical-history.html',
		link : function($scope, element, attrs) {
			var w = angular.element($window);

			w.bind('resize', function(e) {
				console.log(w.width());
				if (w.width() == 768) {
					// Do something
				}
				// scope.$apply();
			});
		}
	};
} ]);

app.controller('medicalHistoryController', [ 'PatientService', '$window',
		function(PatientService, $window) {
			var ctrl = this;
			ctrl.person = PatientService.getPerson();
			ctrl.medicalHistory = ctrl.person.medicalHistory;
			ctrl.status = {
				alergies : true
			};

			var w = angular.element($window);
			console.log(w.width());
			if (w.width() <= 768) {
				ctrl.mobile = true;
			}

			w.bind('resize', function(e) {
				console.log(w.width());
				if (w.width() <= 768) {
					ctrl.mobile = true;
				}
				// scope.$apply();
			});
		} ]);

app.directive('familyHistory', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'familyHistoryController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/family-history.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('familyHistoryController', [ 'PatientService',
		function(PatientService) {
			var ctrl = this;
			ctrl.person = PatientService.getPerson();
		} ]);

app.directive('footer', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'footerController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/footer.html',
		link : function($scope, element, attrs) {

		}
	};
});

app.controller('footerController', [ 'UserService', function(UserService) {
	var ctrl = this;
	ctrl.user = UserService.getLoggedUser();
} ]);

app.directive('patientList', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'patientController',
		controllerAs : 'ctrl',
		bindToController : true,
		templateUrl : 'html/directives/patientList.html',
		link : function($scope, element, attrs) {

		}
	};
}).controller('patientController', [ 'PatientService', function(PatientService) {
	var ctrl = this;
	responsePromise = PatientService.getPromiseAllPatients();
	
    responsePromise.success(function(data, status, headers, config) {
    	ctrl.users = data;
    });
    responsePromise.error(function(data, status, headers, config) {
        alert("AJAX failed!");
    });
	
} ]);



app.directive('patientForm', function() {
	return {
		scope : {
		// name: '='
		},
		controller : 'patientFormController',
		controllerAs : 'ctrl',
		bindToController : true,
		template : '<hr><formly-form model="ctrl.user" fields="ctrl.patientFields"  form="ctrl.patientForm">'+
			  '<button type="submit" class="btn btn-default" ng-click="ctrl.submit(ctrl.user)" ng-disabled="ctrl.patientForm.$invalid || ctrl.patientForm.$pristine">Submit</button>'+
			  '</formly-form>',
		link : function($scope, element, attrs) {

		}
	};
}).controller('patientFormController', [ 'PatientService', function(PatientService) {
	var ctrl = this;
	ctrl.patientFields = [{
    	    "className": "display-flex",
    	    "fieldGroup": [
    	      {
    	        "className": "flex-1",
    	        "type": "input",
    	        "key": "firstName",
    	        "templateOptions": {
    	          "label": "First Name",
    	          "required": true
    	        },
    	        "validation": {
    	            "messages": {}
    	          }
    	      },
    	      {
      	        "className": "flex-1",
      	        "type": "input",
      	        "key": "middleName",
      	        "templateOptions": {
      	          "label": "Middle Name"
      	        }
      	      },
    	      {
    	        "className": "flex-1",
    	        "type": "input",
    	        "key": "lastName",
    	        "templateOptions": {
    	          "label": "Last Name"
    	        }/*,
    	        "expressionProperties": {
    	          "templateOptions.disabled": "!model.firstName"
    	        }*/
    	      },
    	      {
    	    	"className": "flex-1",
				"key": "gender",
				"type": "select",
				
				"templateOptions": {
					"label": "Gender",
					"options": [{
			                "name": "Male",
			                "value": "MALE"
			            },
			            {
			                "name": "Female",
			                "value": "FEMALE"
			            }
			        ],
    	        }
    	      },
    	      {
      	    	"className": "flex-1",
  				"key": "bloodType",
  				"type": "select",
  				
  				"templateOptions": {
  					"label": "Blood Type",
  					"options": [{
  			                "name": "A+",
  			                "value": "A_POSITIVE"
  			            },
  			            {
  			                "name": "A-",
  			                "value": "A_NEGATIVE"
  			            },
  			            {
  			                "name": "B+",
  			                "value": "B_POSITIVE"
  			            },
  			          {
  			                "name": "B-",
  			                "value": "B_NEGATIVE"
  			            },
  			          {
  			                "name": "AB+",
  			                "value": "AB_POSITIVE"
  			            },
  			          {
  			                "name": "AB-",
  			                "value": "AB_NEGATIVE"
  			            },
  			          {
  			                "name": "O+",
  			                "value": "O_POSITIVE"
  			            },
  			          {
  			                "name": "O-",
  			                "value": "O_NEGATIVE"
  			            }
  			        ],
      	        }
      	      }
    	    ]
    	  },
    	  {
    	    "template": "<hr /><div><strong>Address:</strong></div>"
    	  },
    	  {
    	    "className": "display-flex",
    	    "fieldGroup": [
    	      {
    	        "className": "flex-2",
    	        "type": "input",
    	        "key": "street",
    	        "templateOptions": {
    	          "label": "Street"
    	        }
    	      },
    	      {
    	        "className": "flex-1",
    	        "type": "input",
    	        "key": "cityName",
    	        "templateOptions": {
    	          "label": "City"
    	        }
    	      },
    	      {
    	        "className": "flex-1",
    	        "type": "input",
    	        "key": "zip",
    	        "templateOptions": {
    	          "type": "number",
    	          "label": "Zip",
    	          "max": 99999,
    	          "min": 0,
    	          "pattern": "\\d{5}"
    	        }
    	      }
    	    ]
    	  },
    	  {
    	    "template": "<hr />"
    	  },
    	  {
    	    "type": "input",
    	    "key": "otherInput",
    	    "templateOptions": {
    	      "label": "Other Input"
    	    }
    	  },
    	  {
    	    "type": "checkbox",
    	    "key": "otherToo",
    	    "templateOptions": {
    	      "label": "Other Checkbox"
    	    }
    	  }
    	];
	ctrl.submit = function(user){
		console.log(user);
	};
} ]);