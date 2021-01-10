package parents;

import human.AgeException;
import human.Gender;

public class Mother extends Parent {

    public Mother(String name, int age) throws AgeException {
        super(name, age);
        setGender(Gender.FEMALE);
    }

    public Mother(String name) {
        super(name);
        setGender(Gender.FEMALE);
    }

    public Mother(String name, boolean b) {
        super(name, b);
        setGender(Gender.FEMALE);
    }

    @Override
    public String good(){
        return "хорошая.";
    }

    @Override
    public String bad(){
        return "плохая.";
    }

}