package utils;

import models.Student;

import java.io.FileInputStream;
import java.util.Scanner;

public class DataReader
{

    public static void readFromFile(String filePath, List outputData)
    {
        FileInputStream fileStream = null;
        Scanner scanner = null;

        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                outputData.add(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), lines[3]));
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
    }
    public static void readForStack(String filePath, Stack SData)
    {
        FileInputStream reader = null;
        Scanner scanner = null;

        try {
            reader = new FileInputStream(filePath);
            scanner = new Scanner(reader, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                SData.push(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), lines[3]));
            }
            reader.close();
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
    }
    public static void readForQueue(String filePath, Queue QData)
    {
        FileInputStream reader = null;
        Scanner scanner = null;

        try {
            reader = new FileInputStream(filePath);
            scanner = new Scanner(reader, "UTF-8");

            while (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(";");
                QData.Enqueue(new Student(lines[0], lines[1], Integer.parseInt(lines[2]), lines[3]));
            }
            reader.close();
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
    }


}
