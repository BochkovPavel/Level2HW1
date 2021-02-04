package HW1;

import java.util.Random;

public class Wall implements Obstacles {
    private int height;

    public Wall() {
        Random random = new Random();
        height = random.nextInt(5)+ 1;
    }

    @Override
    public boolean move(Members member) {
        return member.jump(height);
    }
    @Override
    public String toString (){
        System.out.println("\nСтена высотой: " + height + " метров. \n" );
        return null;
    }
}
