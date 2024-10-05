public class subject 
{
    private String name;
    private double grade;

    public static final double MIN_GRADE = 2.0;
    public static final double MIN_PASS_GRADE = 3.0;
    public static final double MAX_GRADE = 6.0;

    subject()
    {
        this.name = "UNDEFINED";
        this.grade = MIN_GRADE;
    }

    subject(String name, double grade)
    {   
        if(grade < MIN_GRADE || grade > MAX_GRADE)
        {
            throw new IllegalArgumentException("subject::ctor::grade");
        }
        
        this.name = name;
        this.grade = grade;
    }

    public boolean is_taken()
    {
        return this.grade >= MIN_PASS_GRADE;
    }

    public double get_grade()
    {
        return this.grade;
    }

    public String get_name()
    {
        return this.name;
    }

    public void change_grade(double grade)
    {
        if(grade < MIN_GRADE || grade > MAX_GRADE)
        {
            throw new IllegalArgumentException("subject::change_grade::grade");
        }

        this.grade = grade;
    }

    public String to_string()
    {
        return this.name + " - " + this.grade;
    }
}
