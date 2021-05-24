package com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.Employee;
import com.davidulloa.examendavidantonioulloarodriguez.data.repository.EmployeeRepository;

import java.util.List;

import javax.inject.Inject;

public class EmployeViewModel extends ViewModel {
    private EmployeeRepository employeeRepository;

    @Inject
    public EmployeViewModel(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public LiveData<List<Employee>> getEmployess(){
        return this.employeeRepository.getEmployees();
    }

    public LiveData<Employee> getEmployess(int id){
        return this.employeeRepository.getEmployee(id);
    }

    public void getEmployess(Employee employee){
        this.employeeRepository.saveEmploye(employee);
    }


}
