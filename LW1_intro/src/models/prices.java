package models;

public class prices implements utils.Parsable<prices> {
    public String surname;
    public String name;
    public double price;

    public prices(){

    }
    public prices(String surname,String name,double price)
    {
        this.surname=surname;
        this.name=name;
        this.price=price;
    }
    public String toString()
    {
        return String.format("| %10s  | %10s   |   %10.2f   |",surname,name,price);
    }


    @Override
    public int compareTo(prices o) {
        return 0;
    }
}
