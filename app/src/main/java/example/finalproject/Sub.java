package example.finalproject;

/**
 * Created by user on 09/01/2017.
 */

public class Sub {
    private int color;
    private int day;
    private int month;
    private int year;
    private String name;

    public Sub(){}

    public Sub(int color, int day, int month, int year,String name){
        this.color = color;
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.day + "/" + this.month + "/" + this.year;
    }

}
