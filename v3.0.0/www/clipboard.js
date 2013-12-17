/**
 * Phonegap ClipboardManager plugin
 * Omer Saatcioglu 2011
 * Guillaume Charhon - Smart Mobile Software 2011
 * Jacob Robbins - Phonegap 2.0 port 2013
 * Guillaume Charhon - Smart Mobile Software - Phonegap 3.0 port - 2013
 */

var Clipboard = function () {};

Clipboard.prototype.copy = function(str, success, fail) {
    alert("copy called");
    return cordova.exec(success, fail, "ClipboardManagerPlugin", "copy", [str]);
};

Clipboard.prototype.paste = function(str, success, fail) {
    return cordova.exec(success, fail, "ClipboardManagerPlugin", "paste", []);
};

var clipboard = new Clipboard();
module.exports = clipboard;
