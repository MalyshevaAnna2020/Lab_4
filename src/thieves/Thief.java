package thieves;

import human.Gender;
import human.Human;
import human.Personality;
import human.Status;

public class Thief extends Human implements attributesofthieves {

    private int number = 0;

    public Thief(){
        setThief();
    }
    public Thief(String name){
        super(name);
        setThief();
    }
    public Thief(String name, Gender Gender){
        super(name, Gender);
        setThief();
    }
    public Thief(Gender Gender){
        super(Gender);
        setThief();
    }
    public Thief(boolean fear){
        this.setFear(fear);
        setThief();
    }
    public Thief(String name, boolean fear){
        super(name);
        setThief();
        this.setFear(fear);
    }
    public Thief(String name, Gender Gender, boolean fear){
        super(name, Gender);
        setThief();
        this.setFear(fear);
    }
    public Thief(Gender Gender, boolean fear){
        super(Gender);
        setThief();
        this.setFear(fear);
    }

    public void setThief(){
        setPersonality(Personality.BAD);
        setStatus(Status.THIEF);
    }


    public void setNumber(int number){
        this.number = number;
        if (number > 1){
            this.setGender(Gender.IT);
        }
    }

    public String rush(){
        if (this.getFear()) {
            if (this.number == 1) {
                if (this.getGender() == Gender.FEMALE) {
                    return "бросилась к двери, ";
                } else {
                    return "бросился к двери, ";
                }
            }
            return "бросились к двери, ";
        }else{
            if (this.number == 1) {
                if (this.getGender() == Gender.FEMALE) {
                    return "пошла к двери, ";
                } else {
                    return "пошел к двери, ";
                }
            }
            return "пошли к двери, ";
        }
    }

    public String checkFear(){
        if (this.getFear()){
            if (this.number == 1) {
                if (this.getGender() == Gender.FEMALE) {
                    return "Не помня себя от страха, она выскочила в прихожую, а оттуда на лестничную площадку. ";
                } else {
                    return "Не помня себя от страха, он выскочил в прихожую, а оттуда на лестничную площадку. ";
                }
            }
            return "Не помня себя от страха, они выскочили в прихожую, а оттуда на лестничную площадку. ";
        }
        if (this.number == 1) {
            if (this.getGender() == Gender.FEMALE) {
                return "Это ее насторожило и она решили выйти из квартиры как можно скорее. ";
            } else {
                return "Это его насторожило и он решили выйти из квартиры как можно скорее. ";
            }
        }
        return "Это их насторожило и они решили выйти из квартиры как можно скорее. ";
    }

    public String drop(){
        if (this.getGender() == Gender.FEMALE){
            return "которые уронила " + this.toString() + ", когда она металась между кухней и столовой. ";
        }else{
            return "которые уронил " + this.toString() + ", когда он метался между кухней и столовой. ";
        }
    }

}
