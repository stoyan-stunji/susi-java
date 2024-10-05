import java.util.ArrayList;
import java.util.List;

public class susi 
{
    private List<student> students;
    private List<lector> lectors;

    susi(List<student> students, List<lector> lectors)
    {
        this.students = students;
        this.lectors = lectors;
    }

    public List<student> get_students()
    {
        return this.students;
    }

    public List<lector> get_lectors()
    {
        return this.lectors;
    }

    public String to_string()
    {
        StringBuilder sb = new StringBuilder();

        for(student s : this.students)
        {
            sb.append(s.to_string());
        }

        for(lector s : this.lectors)
        {
            sb.append(s.to_string());
        }

        return sb.toString();
    }

    public void add_student(student s)
    {
        if(!this.students.contains(s))
        {
            this.students.add(s);
        }
        else
        {
            throw new IllegalArgumentException("susi::add_student::student_is_already_in_list");
        }
    }

    public void add_lector(lector s)
    {
        if(!this.lectors.contains(s))
        {
            this.lectors.add(s);
        }
        else
        {
            throw new IllegalArgumentException("susi::add_lector::lector_is_already_in_list");
        }
    }

    public void remove_student(student s)
    {
        if(this.students.contains(s))
        {
            this.students.remove(s);
        }
        else
        {
            throw new IllegalArgumentException("susi::remove_student::student_cannot_be_found");
        }
    }

    public void remove_lector(lector s)
    {
        if(this.lectors.contains(s))
        {
            this.lectors.remove(s);
        }
        else
        {
            throw new IllegalArgumentException("susi::remove_lector::lector_cannot_be_found");
        }
    }

    public student get_student(student s)
    {
        if(this.students.contains(s))
        {
            return s;
        }
        else
        {
            throw new IllegalArgumentException("susi::get_student::student_cannot_be_found");
        }
    }

    public lector get_lector(lector s)
    {
        if(this.lectors.contains(s))
        {
            return s;
        }
        else
        {
            throw new IllegalArgumentException("susi::get_lector::lector_cannot_be_found");
        }
    }

    public List<student> search_student_by_first_name(String name)
    {
        List<student> array = new ArrayList<student>();
        for(student a : this.students)
        {
            if(a.get_first_name() == name)
            {
                array.add(a);
            }
        }
        return array;
    }

    public List<lector> search_lector_by_first_name(String name)
    {
        List<lector> array = new ArrayList<lector>();
        for(lector a : this.lectors)
        {
            if(a.get_first_name() == name)
            {
                array.add(a);
            }
        }
        return array;
    }

    // TO:DO - all based on the seacrh_by_first_name;
    
    // public List<student> search_by_second_name(String name);
    // public List<student> search_by_third_name(String name);
    // public List<student> search_by_faculty_number_name(String fn);
    // by_course;
    // by_group;
    // by_health_insurance;
    // by_email;
    // by_(different_state_of)_exam;
}
