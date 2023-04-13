package com.example.usinginternalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class Credits extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main3);
        }
        public boolean onCreateOptionsMenu(Menu menu){
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }

        public void Finish(View view) {
                finish();
        }
}