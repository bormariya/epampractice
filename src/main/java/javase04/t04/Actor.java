package javase04.t04;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class Actor  implements Serializable {

    private String name;
    private String lastName;
    private String middleName;

    public Actor(String name, String lastName, String middleName){
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Actor(String name, String lastName){
        this(name, lastName, "");
    }

    @Override
    public String toString() {
        return name + " "
                + (middleName.equals("") ? middleName : middleName + " ")
                + lastName;
    }
}
