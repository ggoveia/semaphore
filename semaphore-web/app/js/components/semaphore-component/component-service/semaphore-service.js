angular.module("semaphore-component-module").service("semaphoreService", semaphoreService);

var teste = 0;

semaphoreService.$inject = ["$q", "$http"];
function semaphoreService($q, $http) {
    var self = this;

    self.getLightOn = getLightOn;

    function getLightOn(idSemaphore) {

        var defer = $q.defer();
        
        var arrayColor = ["G","Y","R"]
        defer.resolve(arrayColor[teste]);
        teste = teste + 1;
        if (teste == 3) teste = 0;

        // $http.get("path/to/url?idSemaphore=" + idSemaphore)
        //     .success(function (lightOn) {
        //         defer.resolve(lightOn);
        //     })
        //     .error(function (data) {
        //         defer.reject(data);
        //     })
        return defer.promise;
    };

}