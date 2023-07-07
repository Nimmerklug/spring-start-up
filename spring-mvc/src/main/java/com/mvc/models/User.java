package com.mvc.models;

public class User {
    private int id;
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public User(String username) {
        this.username = username;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        int result = id;
        result = 77 * result + (username != null ? username.hashCode() : 0);
        result = 77 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        if (id != user.getId()) {
            return false;
        } else if (username != null ? !username.equals(user.getUsername()) : user.getUsername() != null) {
            return false;
        } else if (role != null ? !role.equals(user.getRole()) : user.getRole() != null) {
            return false;
        } else {
            return true;
        }

    }
}
