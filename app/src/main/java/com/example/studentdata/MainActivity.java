package com.example.studentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databasehlpr mydb;
    EditText editname,editsurname,editmarks;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new databasehlpr(this);
        editname = findViewById(R.id.name);
        editsurname = findViewById(R.id.surname);
        editmarks = findViewById(R.id.marks);
        add = findViewById(R.id.adds);
        additems();
    }
   public void additems (){
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isinserted =mydb.insertData(editname.getText().toString(),editmarks.getText().toString(),editmarks.getText().toString());
                        if (isinserted){
                            Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"data not inserted",Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu);
    }*/

}
