package com.davidulloa.examendavidantonioulloarodriguez.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.Employee;

import java.util.List;

@Dao
public interface EmployeesDao {

    @Query("SELECT * FROM employee")
    LiveData<List<Employee>> getEmployes();

    @Query("SELECT * FROM employee WHERE id = :id")
    LiveData<Employee> getEmployes(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveEmploye(Employee employee);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveEmployes(Employee ...employee);
}
