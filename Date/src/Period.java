public class Period {

    private int minutes;

    public Period(int min){
        if (min >= 0)
            minutes = min;
        else minutes = 0;
    }

    public Period(int min, int h){
        if (min >= 0 && h >= 0)
            minutes = min + h*60;
        else minutes = 0;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours(){
        return (minutes - (minutes % 60)) / 60;
    }

    public int getMinorMinutes(){
        return minutes % 60;
    }

    public String toString(){
        if (this.getHours() < 10 && this.getMinorMinutes() < 10)
            return "0" + this.getHours() + " : 0 " + this.getMinorMinutes();
        else if (this.getHours() < 10 && this.getMinorMinutes() > 10)
            return "0" + this.getHours() + " : " + this.getMinorMinutes();
        else if (this.getMinorMinutes() < 10)
            return this.getHours() + " : 0 " + this.getMinorMinutes();
        else return this.getHours() + " : " + this.getMinorMinutes();
    }

    public Period clone(){
        return new Period(minutes);
    }

    public void change(int n){
        if (n > 0)
            minutes = minutes + n;
    }
}
