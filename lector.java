public class lector
{
    private tuple<String> name;
    private faculty fac; // katedra;
    private String email;

    lector()
    {
        this.name = new tuple<String>("NULL");
        this.fac = faculty.UNDEFINED;
        this.email = "NULL";
    }

    lector(String f, String s, String t, faculty fc, String e)
    {
        this.name = new tuple<String>(f, s, t);
        this.fac = fc;
        this.email = e;
    }

    // name cannot be changed;

    public void change_email(String email) // setter;
    {
        this.email = email;
    }

    // faculty cannot be changed;

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

    public String get_email()
    {
        return this.email;
    }

    public String get_faculty()
    {
        return this.fac.toString();
    }

    public String to_string() 
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(this.name.first).append(" ")
          .append(this.name.second).append(" ")
          .append(this.name.third).append("\n")
          .append("Faculty: ").append(this.fac.toString()).append("\n")
          .append("E-Mail: ").append(this.email).append("\n");
          
        return sb.toString();
    }
}
