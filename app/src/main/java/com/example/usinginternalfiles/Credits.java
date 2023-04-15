package com.example.usinginternalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;


/**
 * Credits
 */
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

        /**
         * Finish.
         *
         * @param view the view
         */
        public void Finish(View view) {
                finish();
        }
}