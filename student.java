import java.util.ArrayList;
import java.util.List;

public class student 
{
    private tuple<String> name;
    private String faculty_number;

    private int course;
    private int group;

    private specialty area;

    private boolean has_health_insurance;
    private String email;

    private List<subject> all_exams;
    private List<subject> taken_exams;
    private List<subject> failed_exams;

    private static final int MIN_COURSE = 1;
    private static final int MAX_COURSE = 4;

    student()
    {
        String temp = "UNDEFINED";

        this.name = new tuple<String>(temp);
        this.faculty_number = temp;
        this.course = 0;
        this.group = 0;
        this.area = specialty.UNDEFINED;
        this.has_health_insurance = false;
        this.email = temp;
    }

    student(String f, String s, String t, String fn, int c, int g, specialty sp, boolean b, String e, List<subject> ss)
    {
        if(c < MIN_COURSE || c > MAX_COURSE)
        {
            throw new IllegalArgumentException("student::ctor::course");
        }

        this.name = new tuple<String>(f, s, t); 
        this.faculty_number = fn;   
        this.course = c;
        this.group = g;
        this.area = sp;
        this.has_health_insurance = b;
        this.email = e;

        this.all_exams = new ArrayList<>();
        this.taken_exams = new ArrayList<>();
        this.failed_exams = new ArrayList<>();

        for(subject a : ss)
        {
            if(a.is_taken())
            {
                this.taken_exams.add(a);
            }
            else
            {
                this.failed_exams.add(a);
            }
            this.all_exams.add(a);
        }
    }

    public void change_course(int course) // setter;
    {
        if(course < MIN_COURSE || course > MAX_COURSE)
        {
            throw new IllegalArgumentException("student::chnage_course::course");
        }

        this.course = course;
    }

    public void change_group(int group) // setter;
    {
        this.group = group;
    }

    public void change_specialty(specialty area) // setter;
    {
        // if() // condition;
        this.area = area;
    }

    public void update_health_insurance() // setter;
    {
        this.has_health_insurance = true;
    }

    // name cannot be changed;

    public void change_email(String email) // setter;
    {
        this.email = email;
    }

    public void take_exam(subject s) 
    {
        if(s.is_taken())
        {
            if(failed_exams.contains(s))
            {
                failed_exams.remove(s);
            }
            taken_exams.add(s);
        }
        else
        {
            throw new IllegalStateException("student::take_exam::subject");
        }
    }

    public String get_first_name()
    {
        return this.name.first;
    }

    public String get_second_name()
    {
        return this.name.second;
    }

    public String get_third_name()
    {
        return this.name.third;
    }

    public String get_faculty_number()
    {
        return this.faculty_number;
    }

    public int get_course()
    {
        return this.course;
    }

    public int get_group()
    {
        return this.group;
    }

    public boolean get_health_insurence()
    {
        return this.has_health_insurance;
    }

    public String get_email()
    {
        return this.email;
    }

    public List<subject> get_taken_exams()
    {
        return this.taken_exams;
    }

    public List<subject> get_failed_exams()
    {
        return this.failed_exams;
    }

    public List<subject> get_all_exams()
    {
        return this.all_exams;
    }

    public String get_specialty()
    {
        return this.area.toString();
    }

    public String to_string() 
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(this.name.first).append(" ")
          .append(this.name.second).append(" ")
          .append(this.name.third).append("\n")
          .append("Faculty Number: ").append(this.faculty_number).append("\n")
          .append("Course: ").append(this.course).append("\n")
          .append("Group: ").append(this.group).append("\n")
          .append("Specialty: ").append(this.area).append("\n")
          .append("Health Insurance: ").append(this.has_health_insurance ? "Yes" : "No").append("\n")
          .append("Email: ").append(this.email).append("\n")
          .append("Taken Exams: ").append(get_exam_list(this.taken_exams)).append("\n")
          .append("Failed Exams: ").append(get_exam_list(this.failed_exams)).append("\n");
          
        return sb.toString();
    }
    
    private String get_exam_list(List<subject> exams) 
    {
        if(exams.isEmpty()) 
        {
            return "None";
        }

        StringBuilder sb = new StringBuilder();

        for(subject s : exams) 
        {
            sb.append(s.to_string()).append(", ");
        }

        return sb.substring(0, sb.length() - 2).toString();
    }
}
