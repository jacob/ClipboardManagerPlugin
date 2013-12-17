This version of the plugin is for Phonegap versions >= 3.0.0

## Adding the Plugin to your project ##
1. Clone this repository
2. At the root of your project, run : 

    phonegap local plugin add /path/to/plugin/ClipboardManagerPlugin/v3.0.0


## Using the plugin ##
The plugin creates a clipboard object.

`clipboard.copy(str, success, fail)` that copies the given string into the clipboard
`clipboard.paste(success, fail)` that returns the text from the clipboard

`success` and `fail` are callback functions. 

An example for copy:

	clipboard.copy(
		"the text to copy",
		function(r){alert("copy is successful")},
		function(e){alert(e)}
	);

An example for paste:

    clipboard.paste(
        function(r){alert("The text in the clipboard is " + r)},
        function(e){alert(e)}
    );

## Plugin developer notes ##

Android API Levels 7+ are supported.

