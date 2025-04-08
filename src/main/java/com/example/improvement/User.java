package com.example.improvement;

import java.io.Serializable;

public class User implements Serializable {
    String username;
    String password;
    int role;
    int UID;

    public User(int UID, String u, String p, int role){
        this.UID = UID;
        username = u;
        password = p;
        this.role = role;
    }


}
