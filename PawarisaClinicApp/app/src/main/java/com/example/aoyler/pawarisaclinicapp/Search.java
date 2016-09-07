package com.example.aoyler.pawarisaclinicapp;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by aoyler on 1/9/2559.
 */
public class Search extends AppCompatActivity {

    OkHttpClient okHttpClient = new OkHttpClient();
    String key, data, detail, sql;
    EditText editText;
    Button _serach;
    private static final int REQUEST_SEARCH = 0;
    private List<FeedItem> feedsList;
    String tempKeyword;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        textView = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.search);

        System.out.println("KEY" + tempKeyword);



        final ImageView search1 = (ImageView) findViewById(R.id.imageView11);
        search1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tempKeyword = editText.getText().toString();
                AsyncTaskGetData asyncTaskGetData = new AsyncTaskGetData();
                asyncTaskGetData.execute(tempKeyword);
            }
        });

    }

    public class AsyncTaskGetData extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            // Initialize Builder (not RequestBody)
            FormBody.Builder builder = new FormBody.Builder();
            // Add Params to Builder
            builder.add("key", params[0]);
            RequestBody body = builder.build();
            Request request = new Request.Builder().url("http://172.19.46.43/search.php").post(body).build();
            Response response;
            try {
                response = okHttpClient.newCall(request).execute();
                String result = response.body().string();
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(result);
                    // Query JSON tag: State
                    data = jsonObject.getString("data");
                    //detail = jsonObject.getString("detail");
                    sql = jsonObject.getString("sql");
                    System.out.println("@title: " + data);
                    //System.out.println("@detail: " + detail);
                    System.out.println("@detail: " + sql);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Perform action on click
            textView.setText((Html.fromHtml(data.toString())));
        }
    }

}

