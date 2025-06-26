package utils;
import models.CallsData;
import models.Subscribers;
import models.prices;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.lang.String;
import java.util.Locale;
public class IOUtils {
    public static LinkedList<models.Subscribers> ReadSubscribers(String filename)
    {
        LinkedList<models.Subscribers> selectedSubscribers = new LinkedList<Subscribers>();
        FileInputStream fileStream ;
        Scanner scanner = null;
        try {
            fileStream = new FileInputStream(filename);
            scanner = new Scanner(fileStream, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                selectedSubscribers.add(new Subscribers(lines[0],lines[1], Long.parseLong(lines[2]),lines[3],LocalTime.parse(lines[4]),
                        Double.parseDouble(lines[5])));
            }
            fileStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
        return selectedSubscribers ;
    }

    public static LinkedList<models.CallsData> ReadCallsData(String filename)
    {
        LinkedList<models.CallsData> selectedCollectors = new LinkedList<CallsData>();
        FileInputStream fileStream2 = null;
        Scanner scanner = null;
        try {
            fileStream2 = new FileInputStream(filename);
            scanner = new Scanner(fileStream2, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                selectedCollectors.add(new CallsData(lines[0],Double.parseDouble(lines[1]),Double.parseDouble(lines[2]),Double.parseDouble(lines[3])));
            }
            fileStream2.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
        return selectedCollectors;
    }


    public static void DisplayCallsData(String Header,LinkedList<CallsData> C)
    {
        System.out.println("\n"+Header);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|    City   |   Connection Price |     Day price      |    Night price  |");
        System.out.println("-------------------------------------------------------------------");
        for(CallsData c: C)
        {
            System.out.println(c.toString());
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void DisplaySubscribers(String Header,LinkedList<Subscribers> S)
    {
        System.out.println("\n"+Header);
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("|  Surname    |  Name        |     Telephone              |    City       |     Time Call | Duration |");
        System.out.println("------------------------------------------------------------------------------------------------------");
        for(int i=0;i<S.Count;i++)
        {
            Subscribers s=S.get(i);
            System.out.println(s.toString());
        }
        System.out.println("----------------------------------------------------");
    }
    public static void DisplayPrices(String Header,LinkedList<prices> C)
    {
        System.out.println("\n"+Header);
        System.out.println("------------------------------------------------");
        System.out.println("|    Surname   |   Name      |          Prices |");
        System.out.println("------------------------------------------------");
        for(int i=0;i<C.Count;i++)
        {
            prices t=C.get(i);
            System.out.println(t.toString());
        }
        System.out.println("------------------------------------------------");
    }
    public static void DisplayResultCollector(String Header, LinkedList<CallsData> C, PrintWriter pw)
    {
        pw.println("\n"+Header);
        pw.println("-------------------------------------------------------------------");
        pw.println("|    City   |   Connection Price |     Day price      |    Night price  |");
        pw.println("-------------------------------------------------------------------");
        for(CallsData c: C)
        {
            pw.println(c.toString());
        }
        pw.println("-------------------------------------------------------------------");


    }
    public static void DisplayResultStamp(String Header, LinkedList<Subscribers> S, PrintWriter pw)
    {
        pw.println("\n"+Header);
        pw.println("------------------------------------------------------------------------------------------------------");
        pw.println("|  Surname    |  Name        |     Telephone              |    City       |     Time Call | Duration |");
        pw.println("------------------------------------------------------------------------------------------------------");
        for(int i=0;i<S.Count;i++)
        {
            Subscribers s=S.get(i);
            pw.println(s.toString());
        }
        pw.println("----------------------------------------------------");

    }
    public static void DisplayResultPrices(String Header, LinkedList<prices> C, PrintWriter pw)
    {
        pw.println("\n"+Header);
        pw.println("------------------------------------------------");
        pw.println("|    Surname   |   Name      |          Prices |");
        pw.println("------------------------------------------------");
        for(int i=0;i<C.Count;i++)
        {
            prices t=C.get(i);
            pw.println(t.toString());
        }
        pw.println("------------------------------------------------");

    }
}
