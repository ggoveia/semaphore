angular.module("timer", []).factory("timerFactory", factory);

function factory() {

    return {
        createTimerFactory: createTimerFactory
    }

    function createTimerFactory(time) {
        return new TimerFactory(time)
    }

    function TimerFactory(time) {

        var interval = null;

        return {
            startTimerCallback: startTimerCallback,
            stopTimer: stopTimer
        }

        function startTimerCallback(callback) {
            interval = setInterval(() => callback(arguments[1]), time)
        }

        function stopTimer() {
            clearInterval(interval);
        }
    }
}

