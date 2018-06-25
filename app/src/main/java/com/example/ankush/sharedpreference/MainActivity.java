package com.example.ankush.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGet,btnSave,btnClear;
    EditText etName,etAge;
    SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGet = (Button)findViewById(R.id.btnGet);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnClear = (Button)findViewById(R.id.btnClear);
        etAge = (EditText)findViewById(R.id.etAge);
        etName = (EditText)findViewById(R.id.etName);

        sp1 = getSharedPreferences("Myp1",MODE_PRIVATE);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                SharedPreferences.Editor editor = sp1.edit();
                editor.putString("n",name);
                editor.putInt("a",age);
                editor.commit();

                Toast.makeText(MainActivity.this, "Data saved succesfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etAge.setText("");
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = sp1.getString("n","");
                etName.setText(name);

                int age = sp1.getInt("a",0);
                String age1 = String.valueOf(age);
                etAge.setText(age1);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp1.edit();

                editor.remove("n");
                editor.remove("a");
                editor.clear();
                Toast.makeText(MainActivity.this, "All data removed succesfully", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
