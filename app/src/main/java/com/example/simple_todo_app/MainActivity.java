package com.example.simple_todo_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter array_adapter;
    ListView list_view;
    EditText new_user_txt;
    Button add_button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String user_todo_list = "key";
    Toast toast;


    String SH_USERNAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> usertexts = new ArrayList<>();

        add_button = findViewById(R.id.button2);

        list_view = findViewById(R.id.listview);

        new_user_txt = findViewById(R.id.txtbox);
        array_adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,usertexts);

        sharedPreferences = getSharedPreferences(SH_USERNAME,Context.MODE_PRIVATE);



        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_text_string =  new_user_txt.getText().toString();
                usertexts.add(user_text_string);
                list_view.setAdapter(array_adapter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(user_todo_list,user_text_string);
                editor.commit();

                toast.makeText(MainActivity.this,"saved successfully",Toast.LENGTH_SHORT).show();





            }
        });





    }
}