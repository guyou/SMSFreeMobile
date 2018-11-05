package fr.free.smsapi;

public class NamedAccount extends RawAccount {

    protected final String name;

    public NamedAccount(String name, String user, String password) {
        super(user, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
