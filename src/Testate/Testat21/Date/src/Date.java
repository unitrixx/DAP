package Testate.Testat21.Date.src;

public class Date {

    private String name;
    private PointInTime date;
    private Period time;

    public Date (String n, PointInTime d, Period t){
        name = n;
        date = d;
        time = t;
    }

    public Date clone(){
        return new Date(name, date, time);
    }

    public String getName() {
        return name;
    }

    public PointInTime getDate() {
        return date;
    }

    public Period getTime() {
        return time;
    }

    public void set (PointInTime d, Period t){
        date = d;
        time = t;
    }

    public void change(int h){
        if (date != null){
            date.change(h);
        }
    }

    public String toString() {
        return name + ", Beginn: " + date.toString() + ", Dauer: " + time.toString();
    }
}
