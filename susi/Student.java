
import java.util.ArrayList;
import java.util.List;

public class Student 
{
    private Tuple<String> name; 
    private String facultyNumber;  

    private Area specialty;
    private int group;
    private int course;

    private String email;
    private String password;
    
    private List<Pair<Subject, Double>> exams;
    private boolean hasHealthInsurance;

    private static final int MIN_COURSE = 1;
    private static final int MAX_COURSE = 4;

    private static final double MIN_GRADE = 2.0;
    private static final double MAX_GRADE = 6.0;

    private static final double GRADE_TO_CHANGE = 4.50;

    private double getAverageOfExams()
    {
        double sum = 0;

        for(Pair<Subject, Double> exam : this.exams)
        {
            sum += exam.second;
        }

        return sum / this.exams.size();
    }

    private boolean canChangeArea()
    {
        return getAverageOfExams() >= GRADE_TO_CHANGE;
    }

    private boolean canSetCourse(int c)
    {
        return MIN_COURSE <= c && c <= MAX_COURSE;
    }

    private boolean isValidGrade(double i)
    {
        return MIN_GRADE <= i && i <= MAX_GRADE;
    }

    private boolean isLogInfoCorrect(String e, String p)
    {
        return this.email == e && this.password == p;
    }

    public Student()
    {
        this.name.first = "";
        this.name.second = "";
        this.name.third = "";
        this.facultyNumber = "";

        this.specialty = Area.UNDEFINED;
        this.group = 0;
        this.course = 0;

        this.email = "";
        this.password = "";

        this.exams = new ArrayList<Pair<Subject, Double>>();

        this.hasHealthInsurance = false;
    }

    public Student(Tuple<String> a, String b, int h, int g, Area c, String d, String e, boolean f)
    {   // TO::DO changeNames;
        this.name = a;
        this.facultyNumber = b;

        this.specialty = c;

        this.course = h;
        this.group = g;

        this.email = d;
        this.password = e;

        this.exams = new ArrayList<Pair<Subject, Double>>();

        this.hasHealthInsurance = f;
    }

    public Tuple<String> getName()
    {
        return this.name;
    }

    // Cannot change name after creation i.e. no setName();

    public String getFacultyNumber()
    {
        return this.facultyNumber;
    }

    // Cannot change faculty number after creation i.e. no setFacultyNumber();

    public String getSpecialty()
    {
        return this.specialty.toString();
    }

    public boolean setSpecialty(Area a)
    {
        if(!canChangeArea())
        {
            return false;
        }
        this.specialty = a;
        return true;
    }

    public int getGroup()
    {
        return this.group;
    }

    public boolean setGroup(int g)
    {
        this.group = g;
        return true;
    }

    public int getCourse()
    {
        return this.course;
    }

    public boolean setCourse(int c)
    {
        if(!canSetCourse(c))
        {
            return false;
        }
        this.course = c;
        return true;
    }

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

    public List<Subject> getFailedExams()
    {
        List<Subject> temp = new ArrayList<Subject>();

        for(Pair<Subject, Double> exam : this.exams)
        {
            if(exam.second == MIN_GRADE)
            {
                temp.add(exam.first);
            }
        }

        return temp;
    }

    public List<Subject> getTakenExams()
    {
        List<Subject> temp = new ArrayList<Subject>();

        for(Pair<Subject, Double> exam : this.exams)
        {
            if(exam.second > MAX_GRADE)
            {
                temp.add(exam.first);
            }
        }

        return temp;
    }

    public List<Subject> getAllExams()
    {
        List<Subject> temp = new ArrayList<Subject>();

        for(Pair<Subject, Double> exam : this.exams)
        {
            temp.add(exam.first);
        }

        return temp;
    }

    public List<Pair<Subject, Double>> getExams() 
    {
        return this.exams;
    }

    public boolean addExam(Subject s, double i)
    {
        if(!isValidGrade(i))
        {
            return false;
        }
   
        this.exams.add(new Pair<Subject, Double>(s, i));
        return true;
    }

    public boolean gradeExam(Subject s, double i)
    {
        if(!isValidGrade(i))
        {
            return false;
        }

        int index = -1;

        for(int j = 0; j < this.exams.size(); ++j)
        {
            if(s == this.exams.get(j).first)
            {
                index = j;
            }
        }

        if(index == -1)
        {
            return false;
        }

        this.exams.get(index).second = i;

        return true;
    }

    public boolean getInsurance()
    {
        return this.hasHealthInsurance;
    }

    public boolean setInsurance()
    {
        this.hasHealthInsurance = true;
        return true;
    }

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

    public double getAllCredits()
    {
        double sum = 0;

        for(Pair<Subject, Double> s : this.exams)
        {
            if(s.second > MIN_GRADE)
            {
                sum += s.second;
            }
        }

        return sum;
    }

    public double getCompulsoryCredits()
    {
        double sum = 0;

        for(Pair<Subject, Double> s : this.exams)
        {
            if(s.first.getSubjectType() == SubjectType.COMPULSORY.toString())
            {
                sum += s.second;
            }
        }

        return sum;
    }

    public double getElectiveCredits()
    {
        double sum = 0;

        for(Pair<Subject, Double> s : this.exams)
        {
            if(s.first.getSubjectType() != SubjectType.COMPULSORY.toString())
            {
                sum += s.second;
            }
        }

        return sum;
    }

    public String getInfo() 
    {
        String fullName = this.name.first + " " + this.name.second + " " + this.name.third;
    
        StringBuilder examsInfo = new StringBuilder();
        for (Pair<Subject, Double> exam : this.exams) 
        {
            examsInfo.append(exam.first.getInfo())
                      .append("\nGrade: ")
                      .append(exam.second)
                      .append("\n");
        }
    
        return "Name: " + fullName + "\n" +
               "Faculty Number: " + this.facultyNumber + "\n" +
               "Specialty: " + this.specialty.toString() + "\n" +
               "Course: " + this.course + "\n" +
               "Group: " + this.group + "\n" +
               "Email: " + this.email + "\n" +
               "Exams:\n" + examsInfo.toString();
    }
}
