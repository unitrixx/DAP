package Testate.Testat21.Date.src;

public class PointInTime {

    private int year;
    private int day;
    private int hour;

    public PointInTime(int y, int d, int h) {
        if ((y > 999 && y < 10000) && (d > 0 && d < 366) && (h >= 0 && h <= 23)) {
            year = y;
            day = d;
            hour = h;
        }
        else System.out.println("Input out of bounds!");
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public String toString() {
        String string = "" + year + "/";
        if (day > 100)
            string += day;
        else if (day > 10)
            string += "0" + day;
        else string += "00" + day;

        string += "/";

        if (hour < 10)
            string += "0" + hour;
        else string += hour;

        return string;
    }

    public PointInTime clone(){
        return new PointInTime(year, day, hour);
    }

    public void change(int h){
        if (year == 9999){
            System.out.println("Result out of bounds!");
        }
        else {
            if (hour + h > 23) {
                hour = hour + h - 23;
                day++;
            }
            else hour = hour + h;

            if (day > 365) {
                day = day - 365;
                year++;
            }
        }
    }
}
