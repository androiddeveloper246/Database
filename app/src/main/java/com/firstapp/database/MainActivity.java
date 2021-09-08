package com.firstapp.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firstapp.database.mydatabase.AppDatabase;
import com.firstapp.database.mydatabase.DatabaseQuery;
import com.firstapp.database.mydatabase.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // bottom sheet : using layout inflator
    // room library
    // task and backstack

    private Button insertData, deleteData, updateData, getAllData;
    private EditText enrollNo1, enrollNo2, newName;

    private DatabaseQuery myDbQueries;

    int a = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AppDatabase myDatabase = Room.databaseBuilder(this, AppDatabase.class, "student_details_database").build();
//         myDbQueries = myDatabase.myDbQueries();

        AppDatabase a = Room.databaseBuilder(this, AppDatabase.class, "student_database").allowMainThreadQueries().build();
        myDbQueries = a.myDbQueries();


        insertData = findViewById(R.id.insert_data);
        deleteData = findViewById(R.id.delete_data);
        updateData = findViewById(R.id.update_data);
        getAllData = findViewById(R.id.get_all_data);

        insertData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        getAllData.setOnClickListener(this);

        enrollNo1 = findViewById(R.id.d_name);
        enrollNo2 = findViewById(R.id.u_enroll_no);
        newName = findViewById(R.id.u_new_name);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.insert_data:
                a++;
                Student s1 = new Student("student one", "s last name", a);

                myDbQueries.insertStudentDetials(s1);
                break;
            case R.id.delete_data:
                String e1 = enrollNo1.getText().toString();
                myDbQueries.deleteStudentWithName(Integer.parseInt(e1));
                break;
            case R.id.update_data:

                String newN = newName.getText().toString();
                String entrol = enrollNo2.getText().toString();

                myDbQueries.updateStudentDetails(newN, Integer.parseInt(entrol));
                break;
            case R.id.get_all_data:
               List<Student> s = myDbQueries.getAll();

                for (int i = 0; i < s.size(); i++) {

                    Log.d("TAG", "onClick: "+s.get(i).firstName + " "+ s.get(i).lastName + " "+s.get(i).enrollNo);
                }


                break;
        }

    }
}