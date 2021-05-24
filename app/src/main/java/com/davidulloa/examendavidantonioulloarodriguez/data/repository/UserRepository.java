package com.davidulloa.examendavidantonioulloarodriguez.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.davidulloa.examendavidantonioulloarodriguez.HelperClass.logErrorMessage;

public class UserRepository {
    private DatabaseReference db;
    private FirebaseAuth auth;


    public UserRepository() {
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    public MutableLiveData<User> createUser(User user){
        MutableLiveData<User> authenticatedUserMutableLiveData = new MutableLiveData<>();
        auth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    user.setId(auth.getCurrentUser().getProviderId());
                    authenticatedUserMutableLiveData.setValue(user);
                }else{
                    logErrorMessage(task.getException().getMessage());
                }
            }
        });
        return authenticatedUserMutableLiveData;
    }

    public MutableLiveData<Boolean> auhtUser(User user){
        MutableLiveData<Boolean> authResponse = new MutableLiveData<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name",user.getName());
        map.put("email",user.getEmail());
        map.put("password",user.getPassword());
        db.child("Users").child(user.getId()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                   authResponse.setValue(true);
                }else{
                    authResponse.setValue(false);
                }
            }
        });
        return authResponse;
    }
}
