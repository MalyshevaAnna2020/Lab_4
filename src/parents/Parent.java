package parents;

import human.AgeException;
import human.Human;
import human.Personality;
import human.Status;

public class Parent extends Human implements Love {
    private int love = 0;

    //Parent
    public Parent(String name, int age) throws AgeException {
        super(name, age);
        this.setStatus(Status.PARENT);
    }
    public Parent(String name){
        super(name);
        this.setStatus(Status.PARENT);
    }

    public Parent(String name, boolean b) {
        super(name, b);
        this.setStatus(Status.PARENT);
        this.setPersonality(Personality.GOOD);
    }
    public void tolove(int countfamily1, Human[] family1){
        for (int j = 0; j < countfamily1; j++) {
            if (((family1[j].hashCode() > 2000) && (family1[j].getGender() != this.getGender())) || ((family1[j].getStatus() == Status.CHILD) && ((family1[j].getPersonality() == Personality.GOOD) || (family1[j].getActivity())))) {
                love += 1;
            }
        }
    }
    public String ifthen() {
        String s = "";
        if (this.getActivity()) {
            switch (love) {
                case 1:
                    s = "- Раз ты меня любишь, значит я ";
                    s += this.good();
                    break;
                case 2:
                    s = "- Раз вы оба меня любите, значит я ";
                    s += this.good();
                    break;
                case 0:
                    s = "- Раз никто меня не любит, значит я ";
                    s += this.bad();
                    break;
                default:
                    s = "- Раз много людей меня любят, значит я ";
                    s += this.good();
                    break;
            }
        }
        return s;
    }
}