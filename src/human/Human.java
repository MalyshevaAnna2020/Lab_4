package human;

public abstract class Human implements Person {

    private String name = "noname";
    private int age = 20;
    private Gender gender = Gender.MALE;
    private Personality personality = Personality.BAD;
    private Status status = Status.HUMAN;
    private boolean activity = false;
    private boolean fear = false;

    // Human
    public Human (String var1, int var2, boolean a) {
        this.name = var1;
        try {
            setAge(var2);
        }catch(AgeException e){
            System.err.println(e.getMessage());
        }
        this.activity = a;
    }

    public Human (String var1, int var2) throws AgeException {
        this.name = var1;
        try {
            setAge(var2);
        }catch(AgeException e){
            System.err.println(e.getMessage());
        }
    }

    public Human(){
    }

    public Human(String var1){
        this.name = var1;
    }

    public Human(String var1, boolean a){
        this.name = var1;
        this.activity = a;
    }

    public Human(int var1){
    }

    public Human(String name, Gender gender) {
        this.setGender(gender);
        this.name = name;
    }

    public Human(Gender gender) {
        this.setGender(gender);
    }

    // из интерфейса Person
    public void setAge(int var1) throws AgeException {
        if ((var1 < 0) || (var1 > 99)){
            throw new AgeException("Age of " + this.name + " is incorrect: " + var1 + ". The corrected age: " + this.age);
        }
        this.age = var1;
    }

    public void setGender(Gender var1){
        if (var1 == null){
            var1 = Gender.MALE;
        }
        this.gender = var1;
    }

    public void setPersonality(Personality var1){
        if (var1 == null){
            var1 = Personality.BAD;
        }
        this.personality = var1;
    }

    public void setStatus(Status var1){
        if (var1 == null){
            var1 = Status.CHILD;
        }
        this.status = var1;
    }

    public boolean getActivity(){
        return(this.activity);
    }

    public Status getStatus(){ return this.status; }

    public Gender getGender(){ return this.gender;}

    public Personality getPersonality(){
        return this.personality;
    }

    public int getAge(){ return this.age; }

    public void setFear(boolean b){
        this.fear = b;
    }

    public boolean getFear(){
        return this.fear;
    }

    public String good(){
        return "хороший";
    }

    public String bad(){
        return "плохой";
    }

    @Override
    public int hashCode(){
        int a = this.age;
        if (this.gender == Gender.FEMALE){
            a += 100;
        }
        if (this.gender == Gender.MALE){
            a += 200;
        }
        if (this.status == Status.CHILD){
            a += 1000;
        }
        if (this.status == Status.PARENT){
            a += 2000;
        }
        return a;
    }

    public boolean equals(Human h){
        return (this.hashCode() != h.hashCode());
    }

    @Override
    public String toString(){
        String stringstatus = String.valueOf(this.status);
        return (stringstatus + " " + this.name);
    }

    public void setActivity(boolean activity){
        this.activity = activity;
    }
}
