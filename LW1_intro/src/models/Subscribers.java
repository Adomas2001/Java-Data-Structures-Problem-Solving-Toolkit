package models;

//mport jdk.jfr.Timespan;

import jdk.jfr.Timespan;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;
import java.util.Iterator;
import java.util.Comparator;

public class Subscribers implements utils.Parsable<Subscribers> {
    public String Subsurname;
    public String Subname;
    public long Telephone;
    public String City;
    public LocalTime time;
    public Double duration;


    public Subscribers()
    {
        this.Subsurname="zalal";
        this.Subname="Youssef";
    }
    public Subscribers(String Subsurname,String Subname,long Telephone,String City,LocalTime time,Double duration)
    {
        this.Subsurname=Subsurname;
        this.Subname=Subname;
        this.Telephone=Telephone;
        this.City=City;
        this.time=time;
        this.duration=duration;
    }

    @Override
    public String toString()
    {
        return String.format("| %10s  | %10s   |     %15d        |     %10s    | %10s | %10.2f |",Subsurname,Subname,Telephone,City,time,duration);
    }


    public boolean Equals(Subscribers col)
    {
        return ((col.Subsurname== Subsurname) &&
                (col.Subname == Subname)) ;
    }
    public String  GetSurName()
    {
        return this.Subsurname;
    }

    public String  GetName()
    {
        return this.Subname;
    }

    public long Getphone()
    {
        return this.Telephone;
    }

    public String GetCity()
    {
        return this.City;
    }
    public LocalTime GetTime(){ return this.time;}
    public double GetDuration(){ return this.duration;}

    @Override
    public int compareTo(Subscribers other) {
        int ip1 = Subname.compareTo(other.Subname) ;
        if (ip1 < 0)
            return 1;
        else if (ip1 > 0 )
            return -1;
        return 0;
    }
}
