var exec = require('cordova/exec');
var GetInstallDateApp = {
    fodase: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "GetInstallDateApp", "greet", [name]);
    },
    fodasedenovo: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "GetInstallDateApp", "mame", [name]);
    }
}
module.exports = GetInstallDateApp;
