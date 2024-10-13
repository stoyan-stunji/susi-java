package People.Lector;

import java.util.List;

import People.Pair;
import People.Subject;
import People.Tuple;
import People.Student.Student;

public class Lector 
{
    private Tuple<String> name;
    private Department department;
    
    private List<Pair<People.Subject, List<Student>>> toTeach;
    private List<Subject> canTeach;

    private String email;
    private String password;

    private boolean isLogInfoCorrect(String e, String p)
    {
        return this.email == e && this.password == p;
    }

    private final static double DEFAULT_GRADE = 2.0;

    Lector()
    {
        this.name.first = "";
        this.name.second = "";
        this.name.third = "";

        this.department = Department.UNDEFIEND;

        this.email = "";
        this.password = "";
    }

    Lector(Tuple<String> a, Department b, List<People.Subject> c, String d, String e)
    {   // TO::DO changeNames;
        this.name = a;
        this.department = b;

        this.canTeach = c;

        this.email = d;
        this.password = e;
    }

    public Tuple<String> getName()
    {
        return this.name;
    }

    // Cannot change name after creation i.e. no setName();

    public Department getDepartment()
    {
        return this.department;
    }

    // Cannot change name after creation i.e. no setDepartment();

    public String getEmail()
    {
        return this.email;
    }

    public boolean setEmail(String e)
    {   // i.e. change Email;
        this.email = e;
        return true;
    }

    // Should not have acsess to password i.e. no getPassword();

    public boolean logIn(String e, String p)
    {
        if(!isLogInfoCorrect(e, p))
        {
            return false;
        }

        // Log In Logic;
        return true;
    }

    public boolean logOut()
    {
        // Log Out Logic;
        return true;
    }

    public boolean addStudents(People.Subject s, List<Student> students)
    {
        int index = -1;
        for(int i = 0; i < canTeach.size(); ++i)
        {
            if(s == canTeach.get(i))
            {
                index = i;
                break;
            }
        }

        if(index == -1)
        {
            return false;
        }

        for(int i = 0; i < students.size(); ++i)
        {
            if(!(students.get(i).addExam(s, DEFAULT_GRADE)))
            {
                return false;
            }
        }

        this.toTeach.add(new Pair<People.Subject, List<Student>>(s, students));

        return true;
    }

    public boolean gradeIndivStudent(People.Subject s, Student a, Double grade)
    {

        return true;
    }

}
