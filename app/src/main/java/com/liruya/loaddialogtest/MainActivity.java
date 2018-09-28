package com.liruya.loaddialogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liruya.loaddialog.LoadDialog;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        LoadDialog.Builder builder = new LoadDialog.Builder( this ).setMessage( "text" );
        builder.show();
    }
}
