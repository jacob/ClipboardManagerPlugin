/**
 * Phonegap ClipboardManager plugin
 * Omer Saatcioglu 2011
 * enhanced by Guillaume Charhon - Smart Mobile Software 2011
 * ported to Phonegap 2.0 by Jacob Robbins
 */

package com.saatcioglu.phonegap.ClipboardManagerPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.text.ClipboardManager;


import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;


public class ClipboardManagerPlugin extends CordovaPlugin {
	private static final String actionCopy = "copy";
	private static final String actionPaste = "paste";

	private ClipboardManager mClipboardManager;


	@Override
	  public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
	  {
	
		// If we do not have the clipboard
		if(mClipboardManager == null) {
			mClipboardManager = (ClipboardManager) cordova.getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
		}
		
	
		// Copy
		if (actionCopy.equals(action)) {
			String arg = "";
			try {
				arg = (String) args.get(0);
				mClipboardManager.setText(arg);
				callbackContext.success();
			} catch (JSONException e) {
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION, e.getMessage()));
			} catch (Exception e) {
				callbackContext.error(e.getMessage());
			}
		// Paste
		} else if (actionPaste.equals(action)) {
			String arg = (String) mClipboardManager.getText();
			if (arg == null) {
				arg = "";
			}
			callbackContext.success(arg);	
		} else {
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION, action));
			return false;
		}

		return true;
	 }
}


