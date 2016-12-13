var exec = require('cordova/exec');

var Gdia = {
    getdatetime: function (name, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "Getdateinstallapp", "getdatetime", [name]);
    }
};
module.exports = Gdia;
