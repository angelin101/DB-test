package myDBRealisation;

/**
 * Created by Ангелин on 07.10.2015.
 */
public class User {
    private int id;
    private String name;
    private int age;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User: "+name+"\nID user: "+id+"\nAge: "+age+"\nCity: "+city;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) return false;
        User user = (User) obj;
        if (this.age != user.age) return false;
        if (!this.name.equals(user.name)) return false;
        if (!this.city.equals(user.city)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 32;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + city.hashCode();
        return result;
    }
}
