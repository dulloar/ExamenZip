package com.davidulloa.examendavidantonioulloarodriguez.data.repository;

import android.widget.MultiAutoCompleteTextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.davidulloa.examendavidantonioulloarodriguez.AppExecutors;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.dao.EmployeesDao;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.Employee;

import java.util.List;

import javax.inject.Inject;

public class EmployeeRepository {
    private AppExecutors appExecutors;
    private EmployeesDao employeesDao;

    @Inject
    public EmployeeRepository(AppExecutors appExecutors, EmployeesDao employeesDao) {
        this.appExecutors = appExecutors;
        this.employeesDao = employeesDao;
    }

    public void saveEmploye(Employee employee){
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                employeesDao.saveEmploye(employee);
            }
        });
    }

    public MutableLiveData<List<Employee>> getEmployees(){
        MutableLiveData<List<Employee>>  listMutableLiveData = new MutableLiveData<>();

        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                LiveData<List<Employee>> employes = employeesDao.getEmployes();
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        listMutableLiveData.setValue(employes.getValue());
                    }
                });
            }
        });

        return listMutableLiveData;
    }

    public MutableLiveData<Employee> getEmployee(int id){
        MutableLiveData<Employee>  listMutableLiveData = new MutableLiveData<>();

        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                LiveData<Employee> employeeLiveData = employeesDao.getEmployes(id);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        listMutableLiveData.setValue(employeeLiveData.getValue());
                    }
                });
            }
        });

        return listMutableLiveData;
    }
}
