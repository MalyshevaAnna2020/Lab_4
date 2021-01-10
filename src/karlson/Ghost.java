package karlson;

public interface Ghost {
    default String round(){
        return "а приведение вилось вокруг ";
    }
    default String kickOut(){
        return "Привидение преследовало по пятам, гнало вниз по лестнице и выкрикивало время от времени глухим, страшным голосом: ";
    }
    default String tired(){
        return "Но потом привидение устало и вернулось в столовую. ";
    }
}
