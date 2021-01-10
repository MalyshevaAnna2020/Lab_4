package dog;

import human.Gender;
import human.Human;
import human.Status;

public class Dog extends Human{

    public Dog(){
        this.setGender(Gender.ANIMAL);
        this.setStatus(Status.DOG);
    }
    public Dog(String name){
        super(name);
        this.setGender(Gender.ANIMAL);
        this.setStatus(Status.DOG);
    }

}
