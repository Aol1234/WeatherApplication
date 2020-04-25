package REST_API;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class OpenWeatherClass {
    @SerializedName("list") public ArrayList<Inner_K_V> _list;

    public String toString() { return _list.toString(); }
    public ArrayList<Inner_K_V> get_Main(){
        return _list;
    }



    public static class Inner_K_V {
        @SerializedName("main") public  Map<String, Number> _main;
        @SerializedName("weather") public  ArrayList<weather> weather;
        @SerializedName("dt") public long datetime;


        public String toString() { return _main.toString(); }

        public Map<String, Number> get_Main(){
            return _main;
        }

        public String getTemp(){ return _main.get("temp").toString(); }

        public String getDateTime(Long datetime){
            Date date = new Date(datetime*1000L);
            SimpleDateFormat jdf = new SimpleDateFormat("HH:mm");
            jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            return jdf.format(date);
        }

        public int getDate(Long datetime){
            Date date = new Date(datetime*1000L);
            // TODO: Make TimeZone local to user
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Dublin"));
            cal.setTime(date);
            return cal.get(Calendar.DAY_OF_WEEK);
        }
        public String getDay(){
            String[] dayNames = new DateFormatSymbols().getWeekdays();
            Date date = new Date(datetime*1000L);
            // TODO: Make TimeZone local to user
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Dublin"));
            cal.setTime(date);
            return dayNames[cal.get(Calendar.DAY_OF_WEEK)];
        }
    }



    public static class weather{
        @SerializedName("description") public String description;
        public String getWeatherDesc(){ return description; }
    }

}
