package models;

import jdk.jfr.Timespan;

public class CallsData implements utils.Parsable<CallsData>{
    public String City;
    public double connectionprice;
    public double dayprice;
    public double nightprice;



    public CallsData()
    {

    }
    public CallsData(String City,double connectionprice,double dayprice,double nightprice)
    {
        this.City=City;
        this.connectionprice=connectionprice;
        this.dayprice=dayprice;
        this.nightprice=nightprice;
    }

    @Override
    public String toString()
    {
        return String.format("| %10s  | %10f   |     %5.2f        |     %5.2f    |",City,connectionprice,dayprice,nightprice);
    }

    @Override
    public int compareTo(CallsData o) {
        return 0;
    }
}
