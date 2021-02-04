package HW1.Item5;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(new DayOfWeekMain().getWorkingHours(DayOfWeek.SUNDAY));
    }
    public String getWorkingHours(DayOfWeek day){
        String workingDay = "До конца недели осталось %s рабочих часов.";
        String weekend = "Сегодня выходной!";
        if (day.getHours() == 0 ){
            return weekend;
        }else if(day.getHours() > 0 ){
            return String.format(workingDay, hoursOfWeek() - hoursOfWeek(day));
        }
        return "Ошибка";
    }
    private int hoursOfWeek(){
        DayOfWeek[] days = DayOfWeek.values();
        int sum = 0;
        for (DayOfWeek day: days) {
            sum += day.getHours();
        }
        return sum;
    }
    private int hoursOfWeek(DayOfWeek day){
        DayOfWeek[] days = DayOfWeek.values();
        int sum = 0;
        for (DayOfWeek d: days) {
            if (d == day){
                return sum;
            }
            sum += d.getHours();
        }
        return sum;
    }
}

