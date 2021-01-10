package parents;

import human.AgeException;
import human.Gender;

public class Father extends Parent {
    public Father(String name, int age) throws AgeException {
        super(name, age);
        setGender(Gender.MALE);
    }

    public Father(String name) {
        super(name);
        setGender(Gender.MALE);
    }

    public Father(String name, boolean b) {
        super(name, b);
        setGender(Gender.MALE);
    }
}
