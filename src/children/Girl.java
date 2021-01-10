package children;

import human.AgeException;
import human.Gender;

public class Girl extends Child {
    public Girl(String name, int age) throws AgeException {
        super(name, age);
        setGender(Gender.FEMALE);
    }

    public Girl(String name) {
        super(name);
        setGender(Gender.FEMALE);
    }

    public Girl(String name, int i, boolean b) throws AgeException {
        super(name, i, b);
        this.setGender(Gender.FEMALE);
    }

    @Override
    public String sigh() {
        return "Ну, тогда я ни за кого не выйду замуж, - вздохнула " + this.toString() + ".\n";
    }

    @Override
    public void husbandWife(){
        System.out.print(", а не с каким-то там мужем. ");
    }

    @Override
    public String disheveled(){
        return "взъерошенная девчушка";
    }

    @Override
    public String good(){
        return "хорошая";
    }

    @Override
    public String bad(){
        return "плохая";
    }
    @Override
    public String writeChild(){
        return "девочка";
    }
    @Override
    public String sighelse(Child couple) {
        return "- Ну, тогда я выйду замуж за " + couple.toString() + ", - вздохнула " + this.toString() + ". – Ведь надо же мне будет выйти замуж за кого-нибудь!\n";
    }
    @Override
    public String naughty(){
        return "озорница";
    }
    @Override
    public String school(){
        if (getAge() < 7){
            return this.toString() + " еще ходила в детский садик, и это было очень кстати, потому что ";
        }else{
            if (getAge() < 13){
                return "У " + this.toString() + " уроки начинались позже, и это было очень кстати, потому что ";
            }
            else{
                return this.toString() + "обычно вставала раньше, чем надо было, потому что ";
            }
        }
    }
}
