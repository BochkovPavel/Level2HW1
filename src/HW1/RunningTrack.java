package HW1;

import java.util.Random;

public class RunningTrack implements Obstacles {
    private int length;

    public RunningTrack() {
        Random random = new Random();
        length = random.nextInt(1200)+ 1;
    }

    @Override
    public boolean move(Members member) {
        return member.run(length);
    }
    @Override
    public String toString (){
        System.out.println("\nДистанция: " + length  + " метров. \n");
        return null;
    }
}
