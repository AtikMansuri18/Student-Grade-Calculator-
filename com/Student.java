package com;
import calculate.*;
import java.io.*;

public class Student
{
    public static void main(String[] args) 
    {
        gradecalculater c = new gradecalculater();
        c.calculate();

        System.out.println();
        System.out.println("Giving the Details of Student Marks and Grade:\n");
        c.display();

        System.out.println("Your Student Data is Saved in txt File");
        System.out.println();
        System.out.println("Reading File Data...");

        try
        {
            Thread.sleep(5000);

            FileInputStream fis = new FileInputStream("a1.txt");
            int r;

            while((r = fis.read()) != -1)
            {
                char ch = (char) r;
                System.out.print(ch);
            }

            fis.close();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
