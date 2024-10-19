import java.util.ArrayList;
import java.util.List;

public class Runner
{
    private Logger logger;
    private List<Runnable> functions;

    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    private Runnable createCourse() 
    {
        return () -> this.courses.add(new Course());
    }

    public List<Course> getCourses()
    {
        return this.courses;
    }

    private Runnable createTeacher() 
    {
        return () -> this.teachers.add(new Teacher());
    }

    public List<Teacher> getTeachers()
    {
        return this.teachers;
    }

    private Runnable createStudent() 
    {
        return () -> this.students.add(new Student());
    }

    public List<Student> getStudents()
    {
        return this.students;
    }

    private List<Runnable> getAdminFuncs()
    {
        List<Runnable> temp = new ArrayList<Runnable>();
        temp.add(createCourse());
        temp.add(createTeacher());
        temp.add(createStudent());
        return temp;
    }

    private List<Runnable> getTeacherFuncs()
    {
        List<Runnable> temp = new ArrayList<Runnable>();
        return temp;
    }

    private List<Runnable> getStudentFuncs()
    {
        List<Runnable> temp = new ArrayList<Runnable>();
        return temp;
    }

    public List<Runnable> getAccessableFuncs()
    {
        return this.functions;
    }

    public Runner(Logger log)
    {
        this.logger = log;
        this.functions = new ArrayList<>();

        Role role = this.logger.getRole();

        if(role == Role.ADMIN)
        {
            this.functions.addAll(getAdminFuncs());
        }
        else if(role == Role.TEACHER)
        {
            this.functions.addAll(getTeacherFuncs());
        }
        else if(role == Role.STUDENT)
        {
            this.functions.addAll(getStudentFuncs());
        }
        else
        {
            throw new IllegalAccessError("System::Ctor::Role");
        }

        this.courses = new ArrayList<Course>();
        this.teachers = new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();
    }
}