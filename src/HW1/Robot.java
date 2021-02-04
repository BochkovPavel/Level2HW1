package HW1;

public class Robot implements Members{
    private String name;
    private int maxlength;
    private int maxHeight;

    public Robot(String name, int maxlength, int maxHeight) {
        this.name = name;
        this.maxlength = maxlength;
        this.maxHeight = maxHeight;
    }

    public Robot(String name) {
        this.name = name;
        this.maxlength = 4000;
        this.maxHeight = 7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean jump(int height) {
        if (maxHeight >= height){
            System.out.println(name + " прыгнул(а).");
            return true;
        }else  System.out.println(name + "  не прыгнул(а).");
        return false;
    }

    @Override
    public boolean run(int length) {
        if (maxlength >= length){
            System.out.println(name + "  пробежал(а).");
            return true;
        }else  System.out.println(name + "  не пробежал(а).");
        return false;

    }
}