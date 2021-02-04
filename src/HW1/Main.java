package HW1;

public class Main {
    public static void main(String[] args) {
        Person pavel = new Person("Pavel");
        Obstacles[] obstacles = {new Wall(),new RunningTrack(), new Wall(),new RunningTrack(), new Wall(),
                new RunningTrack(), new Wall()};
        Members[] members = {new Person("Pavel"), new Cat("Tomas"), new Robot("Sherman"), new Person("Olga")};

        for (Obstacles o : obstacles) {
            o.toString();
            for (int i = 0; i <= members.length -1; i++) {
                if (members[i] != null){
                    if(!o.move(members[i])){
                        members[i] = null;
                    }
                }
            }
        }

    }
}
