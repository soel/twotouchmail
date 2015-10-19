package com.example.kanbara.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoDinnerActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_dinner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnSend = (Button) this.findViewById(R.id.button3);
        btnSend.setOnClickListener(this);
        btnSend.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edit01 = (EditText) findViewById(R.id.editText2);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, "遅くなるので食事いらない");
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View v) {
        EditText edit01 = (EditText) findViewById(R.id.editText2);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, "遅くなるので食事いりません" + "連絡が遅くなってごめんなさい。" +
                "いつもありがとう");
        startActivity(intent);
        return true;
    }


}
