package dog;

public class UnKnownDog {
    public UnKnownDog(){
    }
    @Override
    public String toString(){
        return "черный пудель";
    }
    public class DogOwner{
        String name = "владелица собаки";
        public DogOwner(){
        }
        public DogOwner(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            return "DOGOWNER " + name;
        }
    }
}
