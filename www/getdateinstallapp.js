var exec = require('cordova/exec');

var Gdia = {
    getdate: function (name, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "Getdateinstallapp", "getdate", [name]);
    }
};
module.exports = Gdia;
