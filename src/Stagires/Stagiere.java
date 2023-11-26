package Stagires;

public class Stagiere {
    protected int id;
    protected String name;
    protected String lastname;

    protected int age;
    protected String login;
    protected String password;
    public Stagiere(String name, String lastname, int age, String login, String password) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public Stagiere(){}

    public int getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
