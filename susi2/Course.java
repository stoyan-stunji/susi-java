import java.util.Scanner;

public class Course 
{
    private String name;

    public Course()
    {
        this.name = readName();
    }

    public String getName()
    {
        return this.name;
    }

    private String readName()
    {
        Scanner scanner = new Scanner(System.in);  
        String temp = "";   

        System.out.print("Course name: ");
        temp = scanner.nextLine(); 

        scanner.close();
        return temp;
    }
}
