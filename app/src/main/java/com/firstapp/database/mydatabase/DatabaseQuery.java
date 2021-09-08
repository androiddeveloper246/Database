package com.firstapp.database.mydatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DatabaseQuery {


        @Query("SELECT * FROM student")
        List<Student> getAll();

        @Insert
        void insertStudentDetials(Student s);

        @Query("DELETE FROM student WHERE enroll_no =:enroll")
        void deleteStudentWithName(int enroll);

        @Query("UPDATE student SET first_name = :fName WHERE enroll_no = :enroll")
        void updateStudentDetails(String fName,int enroll);



}
