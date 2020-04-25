package REST_API;

public class DayClass {
    String day, date, desc;
    String temp;

    public DayClass(String day, String date, String temp, String desc){
        this.date = date;
        this.day = day;
        this.desc = desc;
        this.temp = temp;
    }

    public String getDate(){ return date; }
    public String getDay(){ return day; }
    public String getDesc(){ return desc; }
    public String getTemp(){ return temp.toString(); }

    @Override
    public String toString() {
        return "DayClass{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", temp=" + temp +
                '}';
    }
}
