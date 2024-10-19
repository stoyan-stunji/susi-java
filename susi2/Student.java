import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.Subject;

public class Student
{
    private Tuple<String, String, String> name;
    private String facultyNumber;

    private Area area;
    private int group;
    private int course;

    private List<Subject> exams;

    private static final int MIN_COURSE = 1;
    private static final int MAX_COURSE = 4;

    Student() 
    {
        readInfo();
    }

    private void readInfo()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Second name: ");
        String secondName = scanner.nextLine();
        System.out.print("Third name: ");
        String thirdName = scanner.nextLine();
        this.name = new Tuple<String, String, String>(firstName, secondName, thirdName);

        System.out.print("Faculty number: ");
        this.facultyNumber = scanner.nextLine();

        System.out.print("Enter area of study: ");
        String areaInput = scanner.nextLine();
        this.area = Area.valueOf(areaInput);

        System.out.print("Group number: ");
        this.group = scanner.nextInt();

        do 
        {
            System.out.print("Course (1-4): ");
            this.course = scanner.nextInt();
        } 
        while (this.course < MIN_COURSE || this.course > MAX_COURSE);

        this.exams = new ArrayList<>();

        scanner.close();
    }

    public String getFirstName() 
    {
        return name.first;
    }

    public String getSecondName() 
    {
        return name.second;
    }

    public String getThirdName() 
    {
        return name.third;
    }

    public String getFacultyNumber() 
    {
        return facultyNumber;
    }

    public Area getArea() 
    {
        return area;
    }

    public int getGroup() 
    {
        return group;
    }

    public int getCourse() 
    {
        return course;
    }

    public List<Subject> getExams() 
    {
        return exams;
    }

}
