package edu.wpi.cs528.lzzz.carpooling_mobile.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.google.gson.Gson;

import edu.wpi.cs528.lzzz.carpooling_mobile.LoginActivity;
import edu.wpi.cs528.lzzz.carpooling_mobile.R;
import edu.wpi.cs528.lzzz.carpooling_mobile.connection.HttpRequestMessage;
import edu.wpi.cs528.lzzz.carpooling_mobile.model.AppContainer;
import edu.wpi.cs528.lzzz.carpooling_mobile.model.User;

/**
 * Created by QZhao on 12/6/2017.
 */

public class CommonUtils {

    public static HttpRequestMessage createHttpPOSTRequestMessage(String jsonString, String apiName){
        HttpRequestMessage request = new HttpRequestMessage();
        request.setMethod("POST");
        request.setBody(jsonString);
        request.setUrl(CommonConstants.BASE_URL + apiName);
        return request;
    }

    public static HttpRequestMessage createHttpPOSTRequestMessageWithToken(String jsonString, String apiName){
        HttpRequestMessage request = new HttpRequestMessage();
        request.setMethod("POST");
        request.setBody(jsonString);
        request.setUrl(CommonConstants.BASE_URL + apiName);
        request.setToken(AppContainer.getInstance().getToken());
        return request;
    }

    public static HttpRequestMessage createHttpGETRequestMessage(String apiName){
        HttpRequestMessage request = new HttpRequestMessage();
        request.setMethod("GET");
        request.setUrl(CommonConstants.BASE_URL + apiName);
        return request;
    }

    public static HttpRequestMessage createHttpGETRequestMessageWithToken(String apiName){
        HttpRequestMessage request = new HttpRequestMessage();
        request.setMethod("GET");
        request.setToken(AppContainer.getInstance().getToken());
        request.setUrl(CommonConstants.BASE_URL + apiName);
        return request;
    }

    public static ProgressDialog createProgressDialog(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static void showAlert(Context context, boolean success, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        if (!success){
            alertDialog.setTitle("Failure");
        }else{
            alertDialog.setTitle("Results");
        }

        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
