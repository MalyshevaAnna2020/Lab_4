package themain;

import children.Child;
import dog.UnKnownDog;
import human.*;
import parents.Mother;
import thieves.Thief;
import karlson.Man;
import parents.Parent;

public class Play implements Group, Enumerate, Other {

    private final Human[] family1 = new Human[100];
    private final Thief[] thieves = new Thief[100];
    private final Child[] friends = new Child[100];
    private final Parent[] parents = new Parent[2];
    private final Human[] theothers = new Human[100];

    private int countfamily1 = 0;
    private int countthieves = 0;
    private int countfriends = 0;
    private int countparents = 0;
    private int countchildren = 0;
    private int counttheothers = 0;

    private Child themainchild = new Child("Малыш", 8, true);
    private Child badchild = new Child();
    private Parent parent = null;
    private Man.Karlson karlson = null;
    private Child beloved = null;

    public void addfamily(Human var1) {
        family1[countfamily1] = var1;
        if (family1[countfamily1].hashCode() > 2000){
            if (parents[0] == null) {
                parents[0] = (Parent) family1[countfamily1];
                countparents = 1;
            }else{
                if (family1[countfamily1].getGender() != parents[0].getGender()){
                    parents[1] = (Parent) family1[countfamily1];
                    countparents = 2;
                }
            }
        }
        countfamily1++;
    }

    public void addthieves(Human var1) {
        thieves[countthieves] = (Thief) var1;
        countthieves++;
    }

    public void addFriends(Human var1) {
        friends[countfriends] = (Child) var1;
        countfriends++;
    }
    public void theothermen(Human var1){
        theothers[counttheothers++] = var1;
    }

    public void play() {
        Child[] children = makechildren();
        // Главный герой
        for (int i = 0; i < countchildren; i++) {
            if (children[i].getActivity()) {
                themainchild = children[i];
                break;
            }
        }
        // Гунилла (первый плохой ребенок из массива детей)
        for (int i = 0; i < countchildren; i++) {
            if (friends[i].getPersonality() == Personality.BAD) {
                badchild = friends[i];
                break;
            }
        }
        // Главный родитель героя рассказа (по умолчанию - мама)
        Parent parent1 = null;
        for (int i = 0; i < countparents; i++) {
            if (parents[i].getActivity()) {
                parent1 = parents[i];
                break;
            }
        }
        try {
            setParent(parent1);
        }catch (HumanDoesNotExistException e){
            System.err.println(e.getMessage());
        }
        // Братья и сестры (только школьники)
        Child[] schoolchildren = new Child[100];
        int countsiblings = 0;
        for (int j = 0; j < countfamily1; j++) {
            if ((family1[j].getStatus() == Status.CHILD) && (family1[j].getAge() > 6) && ((themainchild.equals(family1[j])) || (! themainchild.toString().equals(family1[j].toString())))) {
                schoolchildren[countsiblings++] = (Child) family1[j];
            }
        }
        class GroupOfThieves extends Thief {
            public GroupOfThieves(boolean fearthieves, int countthieves){
                setFear(fearthieves);
                setNumber(countthieves);
                if (countthieves == 1){
                    setGender(thieves[0].getGender());
                }
            }
        }
        Man.Karlson Karlson = null;
        for (int i = 0; i < counttheothers; i++){
            if (theothers[i].getStatus() == Status.KARLSON){
                Karlson = (Man.Karlson)theothers[i];
            }
        }
        try {
            setKarlson(Karlson);
        }catch(HumanDoesNotExistException e){
            parents[0] = parent;
            System.err.println(e.getMessage());
        }
        Child Beloved = null;
        for (int i = 0; i < countfamily1; i++) {
            if ((family1[i].hashCode() < 2000) && (family1[i].equals(themainchild))) {
                if (family1[i].getGender() == Gender.FEMALE) {
                    Beloved = (Child)family1[i];
                }
            }
        }
        try {
            setBeloved(Beloved, children);
        }catch(HumanDoesNotExistException e){
            System.err.println(e.getMessage());
        }
        // Сцена с жуликами
        if (countthieves > 0) {
            GroupOfThieves groupofthieves = new GroupOfThieves(fear(thieves), countthieves);
            enumerate(thieves, countthieves);
            System.out.print(" " + groupofthieves.rush() + karlson.round() + "н" + theend(2, groupofthieves) + ". " + groupofthieves.checkFear());
            if (fear(thieves)) {
                System.out.print(karlson.kickOut() + karlson.tired() + themainchild.toString() + " собрал" + theend(1, themainchild) + " с пола деньги, кольца, брошки и положил" + theend(1, themainchild) + " все это обратно в секретер. ");
                enumerate(friends, countfriends);
                String s = "и";
                if (countfriends == 0){
                    System.out.print(themainchild.toString());
                    s = theend(1, themainchild);
                }
                if (countfriends == 1){
                    s = theend(1, friends[0]);
                }
                System.out.print(" подобрал" + s + " все вилки и ложки, " + groupofthieves.drop() + "Дети смеялись; они были счастливы. " + themainchild.toString() + " прыгал" + theend(1, themainchild) + " от радости, что все обернулось так хорошо. ");
            } else {
                System.out.print(karlson.tired() + "Все были расстроены произошедшим. ");
            }
        }else{
            System.out.print(karlson.toString() + " решил притвориться приведением. Для этого он взял простыню, нарисовал на ней \"лицо\" приведения и пошел пугать детей. Все смеялись. ");
        }
        System.out.println();
        // На следующее утро... до разговора
        System.out.print("На следующее утро, едва проснувшись, " + themainchild.disheveled() + " в полосатой голубой пижаме пришлепал" + theend(1, themainchild) + " босиком к " + parent.toString() + " на кухню. ");
        // Все ушли, кроме главного героя и parent
        if (countparents > 1) {
            System.out.print(parents[1].toString() + " уже уш" + theend(4, parents[1]) + " на службу. ");
        }
        enumerate(schoolchildren, countsiblings);
        if (countsiblings > 0) {
            System.out.print(" - в школу. ");
        }
        System.out.print(themainchild.school() + "он" + theend(1, themainchild) + " любил" + theend(1, themainchild) + " оставаться вот так по утрам вдвоем с " + parent.toString() + ", пусть даже ненадолго. В такие минуты хорошо разговаривать, вместе петь песни или рассказывать друг другу сказки. ");
        if (themainchild.getAge() < 7){
            System.out.print("Он" + theend(1, themainchild) + " еще маленьк" + theend(10, themainchild) + ", и поэтому с удовольствием сидит у " + parent.toString() + " на коленках.");
        }else{
            if (themainchild.getAge() < 13){
                System.out.print("Хотя " + themainchild.toString() + " уже больш" + theend(11, themainchild) + " " + themainchild.writeChild() + " и ходит в школу, он" + theend(1, themainchild) + " с удовольствием сидит у " + parent.toString() + " на коленях, но только если этого никто не видит. ");
            }
        }
        System.out.println();
        // Малыш вышел на кухню
        System.out.print("Когда " + themainchild.toString() + " вош" + theend(4, themainchild) + " в кухню, " + parent.toString() + ", примостившись у кухонного стола, пил" + theend(1, parent) + " кофе и читал" + theend(1, parent) + " газету. ");
        if (themainchild.getAge() < 13){
            System.out.print(themainchild.toString() + " молча влез" + theend(6, themainchild) + " на колени. " + parent.toString() + " обнял" + theend(1, parent) + " " + theend(2, themainchild) + " и нежно прижал" + theend(1, parent) + " к себе. Так они и сидели, пока " + themainchild.toString() + " окончательно не проснул" + theend(3, themainchild) + ". ");
        }else{
            System.out.print(themainchild.toString() + " сел" + theend(1, themainchild) + " рядом с " + parent.toString() + ", так они сидели, пока " + themainchild.toString() + " окончательно не проснул" + theend(3, themainchild) + ". ");
        }
        System.out.println();
        // Обнаружение последствий произошедшего
        enumerate(parents, countparents);
        if (countparents == 2) {
            System.out.print(" вернулись вчера с прогулки позже, чем предполагали. ");
        }else{
            System.out.print(" вернул" + theend(3, parent) + " вчера с прогулки позже, чем предполагал" + theend(1, parent) + ". ");
        }
        if (themainchild.getAge() < 13){
            System.out.print(themainchild.toString() + " уже лежал" + theend(1, themainchild) + " в своей кроватке и спал" + theend(1, themainchild) + ". Во сне он" + theend(1, themainchild) + " разметал" + theend(3, themainchild) + ". Укрывая " + theend(2, themainchild) + ", " + parent.toString() + " заметил" + theend(1, parent) + " дырки, прорезанные в простыне. А сама простыня была такая грязная, словно ее кто-то нарочно исчертил углем. И тогда " + parent.toString() + " подумал" + theend(1, parent) + ": \"Неудивительно, что " + themainchild.toString() + " поспешил" + theend(1, themainchild)+ " лечь спать. ");
        }else{
            System.out.print(themainchild.toString() + " еще не спал" + theend(1, themainchild) + ", но было уже очень поздно. Однако " + parent.toString() + " заметил" + theend(1, parent) + " дырки, прорезанные в простыне. А сама простыня была такая грязная, словно ее кто-то нарочно исчертил углем. ");
        }
        // Начало разговора
        if (themainchild.getAge() > 12) {
            System.out.print("А теперь, когда " + themainchild.naughty() + " приш" + theend(4, themainchild) + " на кухню, он" + theend(1, parent) + " твердо решил" + theend(1, parent) + " не отпускать " + theend(2, themainchild) + " без объяснений.");
        } else {
            System.out.print("А теперь, когда " + themainchild.naughty() + " сидел" + theend(1, themainchild) + " у н" + theend(2, parent) + " на коленях, он" + theend(1, parent) + " твердо решил" + theend(1, parent) + " не отпускать " + theend(2, themainchild) + " без объяснений.");
        }
        System.out.println();
        // Как ответить?
        System.out.print(themainchild.toString() + " молчал" + theend(1, themainchild) + " и напряженно думал" + theend(1, themainchild) + ". Как быть? ");
        System.out.print("Ведь дырки прорезал именно " + karlson.toString() + ", а " + parent.toString() + " запретил" + theend(1, parent) + " о нем говорить. ");
        if (countthieves > 0){
            String sthieves = "ах";
            if (countthieves == 1) {
                sthieves = "е";
            }
            System.out.print(themainchild.toString() + " решил" + theend(1, themainchild) + " также ничего не рассказывать и о вор" + sthieves + ", потому что " + parent.toString() + " все равно этому не поверит. ");
        }
        System.out.println();
        // Мама подумала, что это была Гунилла...
        if (!badchild.toString().equals("CHILD noname")) {
            System.out.print("\"А! Значит, это " + badchild.toString() + " разрезал" + theend(1, badchild) + " простыню\", - подумал" + theend(1, parent) + " " + parent.toString() + ". И еще он" + theend(1, parent) + " подумал" + theend(1, parent) + ", что " + theend(2, themainchild) + " " + themainchild.toString() + " - " + themainchild.good() + " " + themainchild.writeChild() + ", потому что он" + theend(1, themainchild) + " не желает наговаривать на других, а хочет, чтобы " + badchild.toString() + " сам" + theend(1, badchild) + " все рассказал" + theend(1, badchild) + ". " + parent.toString() + " обнял" + theend(1, parent) + " " + themainchild.toString() + " за плечи. Он" + theend(1, parent) + " решил" + theend(1, parent) + " сейчас больше ни о чем " + theend(2, themainchild) + " не расспрашивать, но при случае поговорить с " + badchild.toString() + ". " + parent.toString() + " вновь принял" + theend(3, parent) + " читать газету, ");
        } else {
            System.out.print("\"А! Не признается! Ничего... Потом как-нибудь спрошу еще раз, - подумал" + theend(1, parent) + " " + parent.toString() + ", ");
        }
        String where = "у н" + theend(2, parent) + " на коленях";
        if (themainchild.getAge() < 13) {
            where = "на кухне";
        }
        //а Малыш молча сидел у нее на коленях и думал
        System.out.print(" а " + themainchild.toString() + " молча сидел" + theend(1, themainchild) + " " + where + " и думал" + theend(1, themainchild) + ". ");
        // Кого же любит Малыш?
        System.out.print("Кого же, собственно говоря, он" + theend(1, themainchild) + " действительно любит? ");
        System.out.print("Прежде всего он" + theend(1, themainchild) + " любит " + parent.toString() + "... ");
        if (countparents == 2) {
            System.out.print(" и " + parents[1] + " тоже... ");
        }
        if (countchildren > 1) {
            System.out.print("Еще он" + theend(1, themainchild) + " любит ");
            enumerateWithout(themainchild, children, countchildren);
            System.out.print("... Ну да, чаще всего он их все-таки любит, особенно " + beloved.toString() + ". Но иногда он" + theend(1, themainchild) + " на н" + theend(2, beloved) + " так сердится, что вся любовь пропадает. ");
        }
        System.out.print(" Любит он" + theend(1, themainchild) + " и " + karlson.toString());
        if (!badchild.toString().equals("CHILD noname")) {
            String tomarry = "женится на ней";
            String tohavewifeorhusband = "жену иметь надо";
            String wanttomarry = "жениться на маме";
            if (themainchild.getGender() == Gender.FEMALE) {
                tomarry = "выйдет замуж за него";
                tohavewifeorhusband = "мужа иметь надо";
                wanttomarry = "выйти замуж за папу";
            }
            System.out.print(", и " + badchild.toString() + " тоже любит. Да, быть может, он" + theend(1, themainchild) + " " + tomarry + ", когда вырастет, потому что хочешь не хочешь, а " + tohavewifeorhusband + ". Конечно, больше всего он" + theend(1, themainchild) + " хотел" + theend(1, themainchild) + " бы " + wanttomarry + ", но ведь это невозможно. Вдруг " + themainchild.toString() + " пришла в голову мысль, которая его встревожила. " + parent.toString() + " подвинул" + theend(1, parent) + " к себе чашку и с удивлением взглянул" + theend(1, parent) + " на " + themainchild.toString() + ". " + themainchild.toString() + ", испугавшись, что сморозил" + theend(1, themainchild) + " глупость, решил" + theend(1, themainchild) + " не продолжать. Но " + parent.toString() + " настаивал" + theend(1, parent) + ": Да, это было так. ");
        }
        // Тут мама рассмеялась и сказала: Lab_3
        System.out.println("Тут " + parent.toString()+ " расмеял" + theend(3, parent) + " и сказал" + theend(1, parent) + ":");
        parent.tolove(countfamily1, family1);
        System.out.println(parent.ifthen());
        Child couple = themainchild.findcouple(countfriends, friends);
        if (couple == null) {
            System.out.print(themainchild.sigh() + "Да и вообще " + theend(7, themainchild) + "больше всего хотелось жить вмсете с ");
        } else {
            String s = "";
            if (couple.getPersonality() == Personality.BAD) {
                s = ", потому что с н" + theend(5, couple) + " трудно ладить. ";
            } else {
                s += ", хотя с н" + theend(5, couple) + " и дружу. ";
            }
            System.out.print(themainchild.sighelse(couple) + themainchild.toString() + " задумал" + theend(3, themainchild) + ". Он" + theend(1, themainchild) + " думал" + theend(1, themainchild) + " о том, что " + theend(7, themainchild) + themainchild.doubt() + " будет не очень приятно жить вместе с " + couple.toString() + s + "Да и вообще " + theend(7, themainchild) + " больше всего хотелось жить вмсете с ");
        }
        enumerateWithout(themainchild, family1, countfamily1);
        themainchild.husbandWife();
        // Мама вздохнула.
        if (checkDog(family1, countfamily1)) {
            System.out.print(parent.toString() + " вздохнул" + theend(1, parent) + ". Ну вот, опять " + themainchild.toString() + " заговорил" + theend(1, themainchild) + " о своей вожделенной собаке! Это было почти так же невыносимо, как и разговоры о " + karlson.toString() + ". ");
        }
        System.out.println();
        // Малыш с друзьями
        if (countfriends > 0) {
            System.out.print("В тот день " + themainchild.toString() + " было приятно идти в школу, потому что " + theend(7, themainchild) + " многое надо было обсудить с ");
            enumerate(friends, countfriends);
            System.out.print(". Домой они шли, как всегда, вместе. И " + themainchild.toString() + " это особенно радовало, потому что теперь ");
            enumerate(friends, countfriends);
            String s = "и";
            String s1 = "ы";
            if (countfriends == 1){
                s = theend(1, friends[0]);
                s1 = s;
            }
            System.out.println(" тоже был" + s + " знаком" + s1 + " с " + karlson + ". ");
        }else{
            System.out.println("Домой " + themainchild.toString() + "ш" + theend(4, themainchild) + "один. ");
        }
        // Появление собаки
        UnKnownDog Dog = new UnKnownDog();
        UnKnownDog.DogOwner dogOwner = Dog.new DogOwner();
        String himherthem = "ними";
        if (countfriends == 0) {
            himherthem = "ним";
            if (themainchild.getGender() == Gender.FEMALE){
                himherthem = "ней";
            }
        }
        System.out.print("Тут появилось еще одно существо, которое тоже захотело пойти вместе с " + himherthem + ". Когда ребята собрались перейти улицу, к " + themainchild.toString() + " подбежал маленький " + Dog.toString() + ". Он обнюхал коленки " + themainchild.toString() + " и дружески тявкнул. ");
        if (checkDog(family1, countfamily1)){
            System.out.print(themainchild.toString() + " был" + theend(1, themainchild) + " бы счастлив" + theend(1, themainchild) + " переводить щенка через все перекрестки города. Должно быть, щенок это почувствовал: он бежал вприпрыжку по мостовой, норовя прижаться к ноге " + themainchild.toString() + ". У маленького щенка был такой вид, будто он готов любить всех на свете, только бы его любили. И " + themainchild.toString() + " полюбил" + theend(1, themainchild) + " этого щенка. О, как он" + theend(1, themainchild) + " его полюбил" + theend(1, themainchild) + "! Он нагнул" + theend(3, themainchild) + " к щенку и принял" + theend(3, themainchild) + " его ласкать, и гладить, и тихонько присвистывать, и причмокивать. Все эти нежные звуки должны были означать, что " + Dog.toString() + " - самый симпатичный, самый распрекрасный пес на свете. Щенок вилял хвостом, всячески давая понять, что он тоже так думает. Он радостно прыгал и лаял, а когда дети свернули на свою улицу, побежал вслед за ними. ");
            if (countfriends > 0){
                String genderfriend2 = "го";
                if (friends[0].getGender() == Gender.FEMALE){
                    genderfriend2 = "й";
                }
                System.out.print("Разве мог" + theend(6, friends[0]) + " понять " + friends[0].toString() + ", у которо" + genderfriend2 + " был Еффа, что значит не иметь собаки - совсем никакой собаки! И щенок пошел за н" + theend(5, themainchild) + ". ");
            }
            // Малыш пришел домой
            System.out.print("Так он оказался у дверей дома, где жил " + themainchild.toString() + ". Тут " + themainchild.toString() + " взял" + theend(1, themainchild) + " его на руки и понес" + theend(6, themainchild) + " по лестнице. \"Сейчас я спрошу у " + parent.toString() + ", можно ли мне оставить его у себя\". ");
        }else{
            System.out.println("Однако собака была такой большой, что ее появление не обрадовало " + themainchild.toString() + ", а даже несколько испугала. К счастью, рядом была ее " + dogOwner.toString() + ". ");
            // Малыш пришел домой
            if (themainchild.getGender() == Gender.MALE){
                System.out.print("Вскоре " + themainchild.toString() + " пришел домой. ");
            }else {
                System.out.print("Вскоре " + themainchild.toString() + " пришла домой. ");
            }
        }
        // Записка от мамы
        System.out.print("Но " + parent.toString() + " не было дома. В записке, которую " + themainchild.toString() + " наш" + theend(4, themainchild) + " на кухонном столе, было сказано, что он" + theend(1, parent) + " в прачечной и что он" + theend(1, themainchild) + " может туда зайти, если " + theend(7, themainchild) + " что-нибудь понадобится. ");
        // Щенок в комнате Малыша
        if (checkDog(family1, countfamily1)){
            System.out.print("Тем временем щенок, как ракета, ворвался в комнату " + themainchild.toString() + ". ");
            if (countfriends > 0){
                System.out.print("Ребята помчались за ним. ");
            }else{
                System.out.print("Он" + theend(1, themainchild) + " помчалась за ним. ");
            }
        }else{
            System.out.print(themainchild.toString() + " вош" + theend(4, themainchild) + " в свою комнату. ");
        }
        System.out.print("В эту самую минуту в окно влетел " + karlson.toString() + ". ");
        if (checkDog(family1, countfamily1)){
            System.out.print(themainchild.toString() + " не слушал" + theend(1, themainchild) + " " + karlson.toString() + ". Тысячи летающих собак ничего не значили для н" + theend(2, themainchild) + " по сравнению с этим маленьким милым щенком. " + badchild.toString() + " склонил" + theend(3, badchild) + " над собакой. Но те лишь обидно рассмеялись в ответ. Щенок подскочил к " + karlson.toString() + " и весело залаял. " + badchild.toString() + " схватил" + theend(1, badchild) + " щенка.");
        }
    }
    public void setParent(Parent parent1) throws HumanDoesNotExistException {
        if (parent1 == null){
            if (parents[0] == null) {
                parent = new Mother("Мама", true);
                family1[0] = parent;
                throw new HumanDoesNotExistException("The main character has at least one parent. His name is \"" + parent.toString() + "\"");
            }else{
                parent = parents[0];
                parent.setActivity(true);
                throw new HumanDoesNotExistException("The \"main\" parent of the main character is " + parents[0].toString());
            }
        }else{
            parent = parent1;
        }
    }
    public void setKarlson(Man.Karlson Karlson) throws HumanDoesNotExistException {
        if (Karlson == null) {
            karlson = new Man.Karlson("Карлсон, который живет на крыше");
            throw new HumanDoesNotExistException("The name of the character with propeller is incorrect: null. The corrected name: \"Карлсон, который живет на крыше\"");
        }else{
            karlson = Karlson;
        }
    }
    public void setBeloved(Child child, Child[] children) throws HumanDoesNotExistException {
        if (child == null){
            if (countchildren > 1){
                if (!children[0].equals(themainchild)) {
                    beloved = children[0];
                }else{
                    beloved = children[1];
                }
            }else {
                throw new HumanDoesNotExistException(themainchild.toString() + " doesn't have brothers and sisters. It's so sad(");
            }
        }else {
            beloved = child;
        }
    }
    public boolean fear(Human[] humans) {
        int countnotfear = 0;
        int countfear = 0;
        for (int i = 0;i < countthieves; i++) {
            if (humans[i].getFear()) {
                countfear++;
            } else {
                countnotfear++;
            }
        }
        return countnotfear > countfear;
    }
    public Child[] makechildren() {
        Child[] makechildren = new Child [10];
        for (int i = 0; i< countfamily1; i++){
            if (family1[i].getStatus() == Status.CHILD) {
                makechildren[countchildren++] = (Child) family1[i];
            }
        }
        return makechildren;
    }
    public void enumerateWithout (Human h, Human[] people, int count) {
        if (count > 2) {
            Human[] l = new Human[--count];
            int k = 0;
            // Список всех, кого надо перечислить
            for (int j = 0; j < count; j++) {
                if (h.equals(people[j])) {
                    l[k] = people[j];
                    k += 1;
                }
            }
            enumerate(l, k);
        }else {
            if (count == 2) {
                if (h.equals(people[0])) {
                    System.out.print(people[0]);
                } else {
                    System.out.print(people[1]);
                }
            }
        }
    }
    public void enumerate(Human[] people, int count){
        //Само перечисление
        if (count > 1) {
            for (int j = 0; j < count - 2; j++) {
                System.out.print(people[j].toString());
                System.out.print(", ");
            }
            System.out.print(people[count - 2].toString() + " и " + people[count - 1].toString());
        }else{
            System.out.print(people[0]);
        }
    }
    public boolean checkDog(Human[] humans, int count){
        boolean b = false;
        for (int i = 0; i < count; i++){
            if (humans[i].getStatus() == Status.DOG){
                b = true;
                break;
            }
        }
        return !b;
    }
    public String theend(int time, Human human){
        switch (time){
            case 1:
                if (human.getGender() == Gender.MALE){
                    return "";
                }else{
                    if (human.getGender() == Gender.FEMALE){
                        return "а";
                    }
                    return "и";
                }
            case 2:
                if (human.getGender() == Gender.MALE){
                    return "его";
                }else{
                    if (human.getGender() == Gender.FEMALE){
                        return "ее";
                    }
                    return "их";
                }
            case 3:
                if (human.getGender() == Gender.MALE){
                    return "ся";
                }else{
                    return "ась";
                }
            case 6:
                if (human.getGender() == Gender.MALE){
                    return "";
                }
            case 4:
                if (human.getGender() == Gender.MALE){
                    return "ел";
                }else{
                    return "ла";
                }
            case 7:
                if (human.getGender() == Gender.MALE){
                    return "ему";
                }
            case 5:
                if (human.getGender() == Gender.MALE){
                    return "им";
                }else{
                    return "ей";
                }
            case 11:
                if (human.getGender() == Gender.MALE){
                    return "ой";
                }
            case 10:
                if (human.getGender() == Gender.MALE){
                    return "ий";
                }else{
                    return "ая";
                }
            default:
                return "";
        }
    }
}