/*global cordova, module*/

module.exports = {
    getdate: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Getdateinstallapp", "getdate", [name]);
    }
};
