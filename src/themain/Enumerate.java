package themain;

import human.Human;

public interface Enumerate {
    void enumerate(Human[] people, int count);
    void enumerateWithout(Human h, Human[] people, int count);
}
