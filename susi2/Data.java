import java.util.ArrayList;
import java.util.List;

public class Data 
{
    private List<Tuple<String, String, Role>> logInData;
                    // email, password, role

    public Data()
    {   
        this.logInData = new ArrayList<Tuple<String, String, Role>>();
    }

    public List<Tuple<String, String, Role>> getlID()
    {
        return this.logInData;
    }

    public void addAdmin(String e, String p)
    {
        if(!this.logInData.add(new Tuple<String, String, Role>(e, p, Role.ADMIN)))
        {
            throw new IllegalArgumentException("Data::addAdmin::tuple");
        }
    }

    public void addTeacher(String e, String p)
    {
        if(!this.logInData.add(new Tuple<String, String, Role>(e, p, Role.TEACHER)))
        {
            throw new IllegalArgumentException("Data::addTeacher::tuple");
        }
    }

    public void addStudent(String e, String p)
    {
        if(!this.logInData.add(new Tuple<String, String, Role>(e, p, Role.STUDENT)))
        {
            throw new IllegalArgumentException("Data::addStudent::tuple");
        }
    }
}
