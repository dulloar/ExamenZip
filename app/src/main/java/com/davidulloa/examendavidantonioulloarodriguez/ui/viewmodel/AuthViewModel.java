package com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.User;
import com.davidulloa.examendavidantonioulloarodriguez.data.repository.UserRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {
    private UserRepository userRepository;
    LiveData<User> createdUserLiveData;
    LiveData<Boolean> authenticatedUserLiveData;

    @Inject
    public AuthViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<Boolean> auth(Activity activity, User user){
            if(validatePassword(user)){
               return this.authenticatedUserLiveData = this.userRepository.auhtUser(user);
            }else{
                return null;
            }
    }

    public LiveData<User> registerUser(User user){
        if(validatePassword(user)){
            return this.createdUserLiveData = this.userRepository.createUser(user);
        }else{
            return null;
        }
    }

    private boolean validatePassword(User user){
        if(user.getName() !=null && !user.getName().isEmpty()
                && user.getEmail() != null && !user.getEmail().isEmpty()
                && user.getPassword() != null && !user.getPassword().isEmpty()){
            if(user.getPassword().length()>6){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }
}
