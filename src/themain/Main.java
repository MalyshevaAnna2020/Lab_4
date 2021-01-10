package themain;

import children.Boy;
import children.Girl;
import dog.Dog;
import human.AgeException;
import karlson.Man;
import parents.Father;
import parents.Mother;
import thieves.Thief;

public class Main {

    public static void main(String[] args) throws AgeException, HumanDoesNotExistException {
        Play p = new Play();
        Thief thief1 = new Thief("Рулле");
        Thief thief2 = new Thief("Филле");
        Mother mother = new Mother("Мама", true);
        Father father = new Father("Папа");
        Boy junior = new Boy("Малыш", 20, true);
        Girl Gunilla = new Girl("Гунилла");
        Boy Krister = new Boy("Кристер");
        Dog dog = new Dog("Бимбо");
        Boy Bosse = new Boy("Боссе");
        Girl Betan = new Girl("Бетан");
        Man.Karlson Karlson = new Man.Karlson("Карлсон, который живет на крыше");

        p.addthieves(thief1);
        p.addthieves(thief2);
        p.addfamily(mother);
        p.addfamily(father);
        p.addfamily(junior);
        p.addfamily(Bosse);
        p.addfamily(Betan);
        p.addfamily(dog);
        p.addFriends(Gunilla);
        p.addFriends(Krister);
        p.theothermen(Karlson);

        p.play();
    }
}
