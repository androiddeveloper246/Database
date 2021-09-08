package com.firstapp.database.mydatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {


    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "enroll_no")
    public int enrollNo;



    public Student(String firstName, String lastName, int enrollNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollNo = enrollNo;
    }
}
