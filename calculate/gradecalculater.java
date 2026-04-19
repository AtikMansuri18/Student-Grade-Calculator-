package calculate;
import java.util.*;
import java.io.*;

public class gradecalculater
{
    String name;
    String grade;
    int subject;
    int mark[];
    double average;
    int total = 0;

    public gradecalculater()
    {
        Scanner a = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        name = a.nextLine();

        System.out.print("Enter Total Subjects (Max 7): ");
        subject = a.nextInt();

        if (subject <= 0 || subject > 7)
        {
            System.out.println("Please select between 1 to 7 subjects.");
            System.exit(0);
        }

        mark = new int[subject];

        System.out.println("Enter Marks:");

        for (int i = 0; i < subject; i++)
        {
            try
            {
                System.out.print("Subject " + (i + 1) + ": ");
                mark[i] = a.nextInt();

                if (mark[i] < 0 || mark[i] > 100)
                {
                    System.out.println("Invalid marks! Enter between 0 to 100.");
                    i--;
                }
                else
                {
                    total += mark[i];
                }
            }
            catch (Exception e)
            {
                System.out.println("Error: Invalid input!");
                a.nextLine();
                i--;
            }
        }
    }

    public void calculate()
    {
        average = (double) total / subject;

        if (average >= 90)
            grade = "A";
        else if (average >= 80)
            grade = "B";
        else if (average >= 70)
            grade = "C";
        else if (average >= 60)
            grade = "D";
        else if (average >= 50)
            grade = "E";
        else
            grade = "F";
    }

    public void display()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("a1.txt");

            StringBuilder sb = new StringBuilder();

            sb.append("===== Student Report =====\n");
            sb.append("Name        : ").append(name.toUpperCase()).append("\n");
            sb.append("Subjects    : ").append(subject).append("\n");
            sb.append("Total Marks : ").append(total).append("\n");
            sb.append("Percentage  : ").append(average).append("%\n");
            sb.append("Grade       : ").append(grade).append("\n");

            System.out.println(sb);

            fos.write(sb.toString().getBytes());
            fos.close();
        }
        catch (IOException e)
        {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
