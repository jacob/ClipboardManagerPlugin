/**
 * Phonegap ClipboardManager plugin
 * Omer Saatcioglu 2011
 * Guillaume Charhon - Smart Mobile Software 2011
 * Jacob Robbins - Phonegap 2.0 port 2013
 */


window.clipboardManagerCopy = function(str, success, fail) {
	cordova.exec(success, fail, "ClipboardManagerPlugin", "copy", [str]);
};

window.clipboardManagerPaste = function(success, fail) {
	cordova.exec(success, fail, "ClipboardManagerPlugin", "paste", []);
};


