/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw1_intro;
import models.CallsData;
import models.Student;
import models.Subscribers;
import models.prices;
import utils.*;
import java.time.LocalTime;
import java.io.*;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.Objects;
public class Main
{

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "students_data.txt";
        String FileName1="U8a.txt";
        String FileName2="U8b.txt";

        Array<Student> students_arr = new Array<>();
        DataReader.readFromFile(filePath, students_arr);

        System.out.println("============Tests with array implementation============");
        performTests(students_arr);

        //LinkedList class implementations:
        LinkedList<Student> students_llist = new LinkedList<>();
         DataReader.readFromFile(filePath, students_llist);

        System.out.println("============Tests with linked list implementation============");
        performTests(students_llist);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();

        //Stack implementation using Array:
        System.out.println("============Stack implementation with Arrays============");
        ArrayStack<Student> student_stack =new ArrayStack<>();
        DataReader.readForStack(filePath,student_stack);
        performStackTests(student_stack,"ArrayStack");

        //Stack implementation using LinkedList:
        System.out.println("============Stack implementation with LinkedList============");
        LinkedListStack<Student> student_linkedstack = new LinkedListStack<>();
        DataReader.readForStack(filePath,student_linkedstack);
        performStackTests(student_linkedstack,"LinkedListStack");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();

        //Queue implementation using Array
        System.out.println("============Queue implementation with Arrays============");
        ArrayQueue<Student> student_Queue =new ArrayQueue<>();
        DataReader.readForQueue(filePath,student_Queue);
        performQueueTests(student_Queue,"ArrayQueue");
        System.out.println();

        //Queue implementation using LinkedList
        System.out.println("============Queue implementation with LinkedList============");
        LinkedListQueue<Student> LinkedList_Queue= new LinkedListQueue<>();
        DataReader.readForQueue(filePath,LinkedList_Queue);
        performQueueTests(LinkedList_Queue,"LinkedList Queue");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        LinkedList<Subscribers> s =IOUtils.ReadSubscribers(FileName1);
        LinkedList<CallsData> c =IOUtils.ReadCallsData(FileName2);
        IOUtils.DisplaySubscribers("Initial Data of Subscribers:",s);
        IOUtils.DisplayCallsData("Initial Data of CallsData:",c);
        LinkedList<prices> tt=task1(s,c);
        IOUtils.DisplayPrices("prices",tt);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter a city");
        String city1 = keyboard.nextLine();
        System.out.println("day or night?");
        String rate1=keyboard.nextLine();
        LinkedList<Subscribers> newwlist=task2(s,city1,rate1);
        newwlist.Sort();
        if((newwlist!=null))
        IOUtils.DisplaySubscribers("last list and sorted",newwlist);
        else System.out.println("empty list");
        PrintToResultFile(s,c,tt,newwlist);
        Subscribers sub=new Subscribers();
        s.add(1,sub);
        IOUtils.DisplaySubscribers("last methof",s);
        LinkedList<Subscribers> bad=newwlist.subList(0,0);
        IOUtils.DisplaySubscribers("lastttttt",newwlist);

    }

    private static void performTests(List<Student> students)
    {
        System.out.println("Initial students list:");

        for(Student student : students)
        {
            System.out.println(student);
        }


        System.out.println(students.remove(new Student("Tomas", "Tomaitis", 22, "IF-7/1")));
        System.out.println(students.remove(new Student("Jonas", "Jonaitis", 19, "IFF-9/3")));
        System.out.println(students.remove(new Student("Vardenis", "Pavardenis", 99, "XX-XX")));

        System.out.println("\nAfter removal:");

        for(Student student : students)
        {
            System.out.println(student);
        }

        students.add(new Student("Ona", "Onaite", 20,"IFF-8/1"));


        System.out.println("\nAfter addition at the end and insertion at the start:");

        for(Student student : students)
        {
            System.out.println(student);
        }

        System.out.println("\nTesting get() method:");

        for(int i = 0; i < 2; i++)
        {
            System.out.println(students.get(i));

        }


    }
    private static void performStackTests(Stack<Student> students,String header)
    {

        System.out.println("Initial students of"+header);


        System.out.println(students.isEmpty());
        System.out.println(students.peek());//Peek
        System.out.println(students.pop()); //Remove

        System.out.println(students.pop());
        System.out.println(students.pop());

        System.out.println(students.isEmpty());

        students.push(new Student("Ona", "Onaite", 20,"IFF-8/1"));
        System.out.println(students.peek());

    }
    private static void performQueueTests(Queue<Student> students,String header)
    {

        System.out.println("Initial students of "+header);
        System.out.println();
        System.out.println(students.peek());//Peek
        System.out.println(students.Dequeue()); //Remove

        System.out.println(students.Dequeue());
        students.Enqueue(new Student("Ona", "Onaite", 20,"IFF-8/1"));
        System.out.println(students.Dequeue());

        System.out.println(students.isEmpty());

        System.out.println(students.peek());





    }
    private static LinkedList<prices> task1(LinkedList<Subscribers>S,LinkedList<CallsData>C)
    {
        LinkedList<models.prices> newlist=new LinkedList<>();
        LocalTime morning=LocalTime.of(8,00);
        LocalTime night=LocalTime.of(22,00);
        for(Subscribers ss: S)
        {
            double price=0;
            for(CallsData cc: C)
            {

                if(Objects.equals(ss.City, cc.City))
                {
                    if((ss.time.compareTo(morning)>0)&&(ss.time.compareTo(night)<0))
                    {
                        price=cc.connectionprice+ss.duration*cc.dayprice;
                        prices p=new prices(ss.Subsurname,ss.Subname,price);
                        newlist.add(p);
                    }
                    else
                    {
                        price=cc.connectionprice+ss.duration*cc.nightprice;
                        prices p=new prices(ss.Subsurname,ss.Subname,price);
                        newlist.add(p);
                    }
                }
            }
        }return newlist;

    }
    private static LinkedList<Subscribers> task2(LinkedList<Subscribers>S,String city,String rate)
    {
        LinkedList<Subscribers> newlist=new LinkedList<>();
        LocalTime morning=LocalTime.of(8,00);
        LocalTime night1=LocalTime.of(22,00);
        for(Subscribers ss:S)
        {
            if(ss.City.equals(city))
            {
                if(Objects.equals(rate, "day"))
                {

                    if((ss.time.compareTo(morning)>0)&&(ss.time.compareTo(night1)<0))
                    {
                        newlist.add(ss);
                    }
                }
                if(Objects.equals(rate, "night"))
                {
                    if(!((ss.time.compareTo(morning)>0)&&(ss.time.compareTo(night1)<0)))
                    {
                        newlist.add(ss);
                    }
                }
            }
        }return newlist;
    }
    public static void PrintToResultFile(LinkedList<Subscribers> C,LinkedList<CallsData> S, LinkedList<prices> newC,
    LinkedList<Subscribers> last)
    {
        newC=new LinkedList<>();
        FileWriter fw = null;
        PrintWriter pw = null;
        File file = new File("Results.txt");
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            IOUtils.DisplayResultCollector("Callsdata", S, pw);
            IOUtils.DisplayResultStamp("Subscribers", C, pw);
            pw.println("\nPRICES OF THE SUBSCRIBERS TO BE PAID)");
            newC=task1(C,S);
            IOUtils.DisplayResultPrices("PRICES",newC,pw);
            IOUtils.DisplayResultStamp("last task",last,pw);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            pw.close();
        }
    }

}
