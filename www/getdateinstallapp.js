var exec = require('cordova/exec');

var Gdia = {
    getdate: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Getdateinstallapp", "getdate", [name]);
    }
};
module.exports = Gdia;
