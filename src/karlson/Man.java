package karlson;

import human.*;

public class Man extends Human implements Ghost {
    public Man() throws AgeException {
        this.setMan();
    }
    public Man(String name) throws AgeException {
        super(name);
        this.setMan();
    }
    public void setMan() throws AgeException {
        this.setAge(30);
        if (this.getActivity()) {
            this.setPersonality(Personality.GOOD);
        }
        this.setGender(Gender.MALE);
    }
    public static class Karlson extends Man{
        public Karlson(String name) throws AgeException {
            super(name);
            this.setAge(30);
            if (this.getActivity()) {
                this.setPersonality(Personality.GOOD);
            }
            this.setGender(Gender.MALE);
            this.setStatus(Status.KARLSON);
        }
    }
}
