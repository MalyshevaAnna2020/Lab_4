package children;

import human.*;

public class Child extends Human implements LoveChild, describe, say {
    // Child
    public Child(String name, int age) throws AgeException {
        super(name, age);
        this.setChild();
    }
    public Child(String name){
        super(name);
        this.setChild();
    }
    public Child(String name, boolean b) {
        super(name, b);
        this.setChild();
    }
    public Child(String name, int age, boolean b) throws AgeException {
        super(name, age, b);
        this.setChild();
    }

    public Child() {
        this.setChild();
    }

    public void setChild(){
        this.setStatus(Status.CHILD);
        this.setGender(Gender.MALE);
        if (this.getAge() < 13) {
            this.setPersonality(Personality.GOOD);
        }
    }
    public void husbandWife() {
        System.out.print(", а не с какой-то там женой. ");
    }
    public String sigh() {
        return "Ну, тогда я ни на ком не женюсь, - вздохнул " + this.toString() + ".\n";
    }
    public String doubt(){
        return ", наверное,";
    }
    public String disheveled(){
        return "взъерошенный мальчуган";
    }
    public String school(){
        if (getAge() < 7){
            return this.toString() + " еще ходил в детский садик, и это было очень кстати, потому что ";
        }else{
            if (getAge() < 13){
                return "У " + this.toString() + " уроки начинались позже, и это было очень кстати, потому что ";
            }
            else{
                return this.toString() + " обычно вставал раньше, чем надо было, потому что ";
            }
        }
    }
    public String writeChild(){
        return "мальчик";
    }
    public String sighelse(Child couple){
        return "- Ну, тогда я женюсь на " + couple.toString() + ", - вздохнул " + this.toString() + ". – Ведь надо же мне будет на ком-нибудь жениться!\n";
    }
    public String naughty(){
        return "озорник";
    }
    public Child findcouple(int countfriends, Child[] friends){
        Child abstract_human = null;
        for (int i = 0; i < countfriends; i++){
            if (friends[i].getGender() != this.getGender()){
                abstract_human = friends[i];
                break;
            }
        }
        return abstract_human;
    }

}
