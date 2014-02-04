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
import android.content.ClipboardManager;


import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;


public class ClipboardManagerPlugin extends CordovaPlugin {
	private static final String actionCopy = "copy";
	private static final String actionPaste = "paste";
	private static final String errorParse = "Couldn't get the text to copy";
	private static final String errorUnknown = "Unknown Error";

	private ClipboardManager mClipboardManager;


	@Override
	  public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
	  {
	
		// If we do not have the clipboard
		if(mClipboardManager == null) {
			mClipboardManager = (ClipboardManager) cordova.getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
		}
		
	
		// Copy
		if (action.equals(actionCopy)) {
			String arg = "";
			try {
				arg = (String) args.get(0);
				mClipboardManager.setText(arg);
			} catch (JSONException e) {
			      callbackContext.error( errorParse);
			} catch (Exception e) {
			      callbackContext.error( errorUnknown);
			}
			callbackContext.success();
		// Paste
		} else if (action.equals(actionPaste)) {
			String arg = (String) mClipboardManager.getText();
			if (arg == null) {
				arg = "";
			}
			PluginResult copy_ret = new PluginResult(PluginResult.Status.OK, arg);
			callbackContext.sendPluginResult(copy_ret);
			callbackContext.success();
			
		} else {
		      callbackContext.error("invalid action");
		      return false;
		}

		return true;
	 }
}


