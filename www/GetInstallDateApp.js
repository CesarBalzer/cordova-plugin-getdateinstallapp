var exec = require('cordova/exec');

var DateAPP = {
    fodase: function (name, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "GetInstallDateApp", "greet", [name]);
    },
    fodasedenovo: function (name, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "GetInstallDateApp", "mame", [name]);
    }
};
module.exports = DateAPP;
