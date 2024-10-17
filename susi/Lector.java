
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lector 
{
    private Tuple<String> name;
    private Department department;
    
    private List<Pair<Subject, List<Student>>> toTeach;
    private List<Subject> canTeach;

    private String email;
    private String password;

    // private List<Message> inbox;

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
        this.toTeach = new ArrayList<Pair<Subject, List<Student>>>();

        this.email = "";
        this.password = "";
    }

    Lector(Tuple<String> a, Department b, List<Subject> c, String d, String e)
    {   // TO::DO changeNames;
        this.name = a;
        this.department = b;

        this.canTeach = c;
        this.toTeach = new ArrayList<Pair<Subject, List<Student>>>();

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

    public boolean addStudents(Subject s, List<Student> students)
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

        this.toTeach.add(new Pair<Subject, List<Student>>(s, students));

        return true;
    }

    public boolean gradeIndivStudent(Subject s, Student a, Double grade)
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

        int jndex = -1;

        for(int i = 0; i < this.toTeach.get(index).second.size(); ++i)
        {
            if(a == this.toTeach.get(index).second.get(i))
            {
                jndex = i;
            }
        }

        if(jndex == -1)
        {
            return false;
        }

        if(!this.toTeach.get(index).second.get(jndex).gradeExam(s, grade))
        {
            return false;
        }

        return true;
    }

    public boolean generateProtocols()
    {
        Random random = new Random();
        
        for (Pair<Subject, List<Student>> pair : this.toTeach) 
        {
            Subject subject = pair.first;
            List<Student> students = pair.second;

            int randomNumber = random.nextInt(10000);
            String fileName = "D:\\Dji\\3_education\\university_1-4_course\\course_3\\semester_5\\design_patterns_for_reusable_software_design\\week-02\\susi\\Protocols\\Protocol_" + subject.getName() + "_" + randomNumber + ".txt";

            try (FileWriter writer = new FileWriter(fileName)) 
            {
                for (Student student : students) 
                {
                    writer.write(student.getFacultyNumber() + "\n");
                }
            } 
            catch (IOException e) 
            {
                return false;
            }
        }

        return true;
    }

    public String getInfo()
    {
        String fullName = this.name.first + " " + this.name.second + " " + this.name.third;

        StringBuilder subjects = new StringBuilder();

        for (Subject subject : this.canTeach)
        {
            subjects.append(subject.getName()).append(", ");
        }

        if (subjects.length() > 0) 
        {
            subjects.setLength(subjects.length() - 2);
        }

        return "Name: " + fullName + "\n" +
               "Department: " + this.department.toString() + "\n" +
               "Subjects: " + subjects.toString() + "\n" +
               "Email: " + this.email;
    }

    public boolean generateGradesBySubject() 
    {
        for (Pair<Subject, List<Student>> pair : this.toTeach) 
        {
            Subject subject = pair.first;
            List<Student> students = pair.second;
    
            String fileName = "D:\\Dji\\3_education\\university_1-4_course\\course_3\\semester_5\\design_patterns_for_reusable_software_design\\week-02\\susi\\Grades\\Subject_Grades_" + subject.getName() + ".txt";
    
            try (FileWriter writer = new FileWriter(fileName)) 
            {
                for (Student student : students) 
                {
                    double grade = -1;
                    for (Pair<Subject, Double> exam : student.getExams()) 
                    {
                        if (exam.first.equals(subject)) 
                        {
                            grade = exam.second;
                            break;
                        }
                    }
                    
                    writer.write("Name: " + student.getName().first + " " + student.getName().second + " " + student.getName().third + "\n");
                    writer.write("Faculty Number: " + student.getFacultyNumber() + "\n");
                    writer.write("Grade: " + (grade >= 0 ? grade : "Not graded") + "\n\n");
                }
            } 
            catch (IOException e) 
            {
                return false;
            }
        }
        
        return true;
    }

}
