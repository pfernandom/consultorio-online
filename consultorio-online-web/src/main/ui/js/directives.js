var app = angular.module('main');

 $(function() {
    $( ".sortable" ).sortable({
      revert: true
    });
    $( ".draggable" ).draggable({
      //connectToSortable: "#sortable",
      //helper: "clone",
      revert: "invalid"
    });
    $( "ul, li" ).disableSelection();
  });


app.directive('sortable', function () {
  return {
  /*
    scope: {
      name: '='
    },
    controller: function () {
      this.name = 'Pascal';
    },
    controllerAs: 'ctrl',
    bindToController: true,
    template: '<div>{{ctrl.name}}</div>'
	*/
	link: function($scope, element, attrs){
		element.sortable({
			revert: true,
			cursor: "move"
			
		});
	}
  };
});

app.directive('navigation', function () {
  return {
    scope: {
     // name: '='
    },
    controller: 'navigationController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/navigation.html',
	link: function($scope, element, attrs){

	}
  };
});

app.controller('navigationController',['UserService',function(UserService){
	var ctrl = this;
	ctrl.user = UserService.getLoggedUser();
}]);


app.directive('idCard', function () {
  return {
    scope: {
     // name: '='
    },
    controller: 'idCardController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/identification.html',
	link: function($scope, element, attrs){

	}
  };
});

app.controller('idCardController',['PersonService',function(PersonService){
	var ctrl = this;
	ctrl.person = PersonService.getPerson();
}]);


app.directive('idStatus', function () {
  return {
    scope: {
     // name: '='
    },
    controller: 'idStatusController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/status.html',
	link: function($scope, element, attrs){

	}
  };
});

app.controller('idStatusController',['PersonService',function(PersonService){
	var ctrl = this;
	ctrl.person = PersonService.getPerson();
}]);


app.directive('idAppointments', function () {
  return {
    scope: {
     // name: '='
    },
    controller: 'idAppointmentsController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/appointments.html',
	link: function($scope, element, attrs){

	}
  };
});

app.controller('idAppointmentsController',['PersonService',function(PersonService){
	var ctrl = this;
	ctrl.person = PersonService.getPerson();
	ctrl.previousDiagnostic = ctrl.person.appointments.previous.diagnostic;
	
	var isToday = function(){
		var inputDate = new Date(ctrl.person.appointments.next.date);
		var todaysDate = new Date();
		var tomorrow = new Date();
		
		tomorrow.setDate(todaysDate.getDate() + 1);

		if(inputDate.setHours(0,0,0,0) == todaysDate.setHours(0,0,0,0)){
			ctrl.today = true;
		}
		else if(inputDate.setHours(0,0,0,0) == tomorrow.setHours(0,0,0,0)){
			ctrl.tomorrow = true;
		}
	};
	
	isToday();
}]);




app.directive('medicalHistory', ['$window',function ($window) {
  return {
    scope: {
     // name: '='
    },
    controller: 'medicalHistoryController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/medical-history.html',
	link: function($scope, element, attrs){
		var w = angular.element($window);
				
		 w.bind('resize', function (e) {
			console.log(w.width());
			if(w.width()==768){
				//Do something
			}
            //scope.$apply();
        });
	}
  };
}]);

app.controller('medicalHistoryController',['PersonService','$window',function(PersonService,$window){
	var ctrl = this;
	ctrl.person = PersonService.getPerson();
	ctrl.medicalHistory = ctrl.person.medicalHistory;
	ctrl.status = {
		alergies: true
	};
	
	var w = angular.element($window);
	console.log(w.width());
		if(w.width()<=768){
			ctrl.mobile = true;
		}
		
		 w.bind('resize', function (e) {
			console.log(w.width());
			if(w.width()<=768){
				ctrl.mobile = true;
			}
            //scope.$apply();
        });
}]);


app.directive('familyHistory', function () {
  return {
    scope: {
     // name: '='
    },
    controller: 'familyHistoryController',
    controllerAs: 'ctrl',
    bindToController: true,
    templateUrl: 'html/family-history.html',
	link: function($scope, element, attrs){

	}
  };
});

app.controller('familyHistoryController',['PersonService',function(PersonService){
	var ctrl = this;
	ctrl.person = PersonService.getPerson();
}]);



app.directive('footer', function () {
	  return {
	    scope: {
	     // name: '='
	    },
	    controller: 'footerController',
	    controllerAs: 'ctrl',
	    bindToController: true,
	    templateUrl: 'html/footer.html',
		link: function($scope, element, attrs){

		}
	  };
	});

	app.controller('footerController',['UserService',function(UserService){
		var ctrl = this;
		ctrl.user = UserService.getLoggedUser();
	}]);