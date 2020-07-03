package com.example.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    //Button을 클릭했을 때 호출되는 callback 메소드

    public void mOnClick(View v){


        Intent i;
        switch(v.getId()){

            case R.id.btn_broadcast:
                i= new Intent(this, broadcastActivity.class);
                startActivity(i);
                break;

            case R.id.btn_watch:
                i= new Intent(this,watchActivity.class);
                startActivity(i);
                break;

        }

    }

}

