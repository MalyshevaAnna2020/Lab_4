package themain;

import children.Child;
import human.Human;
import karlson.Man;
import parents.Parent;

public interface Group {
    void addfamily(Human var1);
    void addFriends(Human var1);
    void addthieves(Human var1);
    void theothermen(Human var1);
    Child[] makechildren();
    void setParent(Parent parent1) throws HumanDoesNotExistException;
    void setKarlson(Man.Karlson Karlson) throws HumanDoesNotExistException;
    void setBeloved(Child child, Child[] children) throws HumanDoesNotExistException;
}
