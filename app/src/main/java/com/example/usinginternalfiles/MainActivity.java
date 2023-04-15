package com.example.usinginternalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Main activity.

 *  @author    Nisim Doron Krief <nisimandroi@gmail.com>
 *  @version    1.1
 *  @since    27/02/2023 (the date of the package the class was added)
 *  @info Program that uses Internal Files, buttons and options menu to Write and save
 *        the text, show it and save it on a particular file when pressed save or exit . */
public class MainActivity extends AppCompatActivity {
    /**
     * The EditText eT.
     */
    EditText eT;
    /**
     * The N tv.
     */
    TextView nTv;
    /**
     * The Fos.
     */
    FileOutputStream fos;
    /**
     * The Osw.
     */
    OutputStreamWriter osw;

    /**
     * The Bw.
     */
    BufferedWriter bw;
    /**
     * The Fis.
     */
    FileInputStream fis;
    /**
     * The Isr.
     */
    InputStreamReader isr;

    /**
     * The Br.
     */
    BufferedReader br;
    /**
     * The Line.
     */
    String line;
    /**
     * The Text.
     */
    String Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nTv = (TextView) findViewById(R.id.nTv);
        eT = (EditText) findViewById(R.id.eT);
        try {
            fis = openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
                fis = openFileInput("test.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            sb.append(line+'\n');
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Text=sb.toString();
        try {
            isr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        nTv.setText(Text);


    }

    /**
     * Save.
     *
     * @param view the view
     */
    public void Save(View view) {
        Shomer();
        eT.setText("");
    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void Reset(View view) {
        nTv.setText("");
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            String reik = "";
            fos.write(reik.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Exit.
     *
     * @param view the view
     */
    public void Exit(View view) {
        Shomer();
        finish();
    }

    /**
     * Shomer.
     */
    public void Shomer() {
        String textsaved = eT.getText().toString();
        try {
            fos = openFileOutput("test.txt",MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        try {
            bw.write(nTv.getText()+textsaved);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nTv.setText(nTv.getText().toString() + eT.getText().toString());

        try {
            fis = openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(line != null){
            sb.append(line+'\n');
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Text = sb.toString();
        try {
            isr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nTv.setText(Text);
        eT.setText("");

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getTitle().toString().equals("Credits")){
            Intent Si = new Intent(this, Credits.class);
            startActivity(Si);

        }



        return true;
    }
}