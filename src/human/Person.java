package human;

public interface Person {
    void setAge(int var1) throws AgeException;
    void setGender(Gender var1);
    void setPersonality(Personality var1);
    void setStatus(Status var1);
    boolean getActivity();
    Status getStatus();
    Gender getGender();
    Personality getPersonality();
    int getAge();
    String good();
    String bad();
    void setActivity(boolean activity);
    void setFear(boolean b);
    boolean getFear();
}
