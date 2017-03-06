angular.module("semaphore-component-module").controller("semaphoreController", semaphoreController);

semaphoreController.inject = ["semaphoreService", "timerFactory"];

function semaphoreController(semaphoreService, timerFactory) {
    var vm = this;

    vm.start = start;


    function start(idSemaphore) {
        getLightOn(idSemaphore);

        var timer = timerFactory.createTimerFactory(5000)
        timer.startTimerCallback(getLightOn, idSemaphore);
    }

    function getLightOn(idSemaphore) {
        semaphoreService.getLightOn(idSemaphore).then((light) => vm.lamp = light);
    }
}