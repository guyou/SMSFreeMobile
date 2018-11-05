package fr.free.smsapi;

public class RawAccount implements Account {

    protected final String user;
    protected final String password;

    public RawAccount(String user, String password) {
        this.user = user;
        this.password = password;
    }


    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }
}