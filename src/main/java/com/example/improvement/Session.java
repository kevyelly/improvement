package com.example.improvement;

import java.io.*;

public class Session {
    private static final String file = "session.text";
    private static User curr_user;

    public static void save(User user) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            curr_user = (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
        return curr_user;
    }

    public static void clear() {
        File file = new File(Session.file);
        if (file.exists()) {
            file.delete();
        }
    }

    public static User getUser() {
        return curr_user;
    }

    public static void setUser(User user) {
        curr_user = user;
    }
}