public class Logger 
{
    private String email;
    private String password;

    private Role role;
    private Data data;

    public Logger(Data data)
    {
        this.email = "";
        this.password = "";

        this.data = data;
        
        this.role = Role.UNDEFINED;
    }

    public boolean logIn(String e, String p)
    {
        this.email = e;
        this.password = p;

        for(Tuple<String, String, Role> tuple : this.data.getlID())
        {
            if(tuple.first == e && tuple.second == p)
            {
                this.role = tuple.third;
                return true;
            }
        }

        return false;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Role getRole()
    {
        return this.role;
    }
}
