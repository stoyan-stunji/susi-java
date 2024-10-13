import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Subject 
{
    private String name;
    private double credits;

    private SubjectType subjectType;
    private ElectiveType electiveType;

    private FileInputStream conspectus;

    public Subject(String a, double b, SubjectType c, ElectiveType d, String e)
    {   // TO::DO changeNames;
        this.name = a;
        this.credits = b;

        this.subjectType = c;

        if(subjectType != SubjectType.COMPULSORY)
        {
            this.electiveType = d;
        }
        else
        {
            this.electiveType = ElectiveType.NOT_ELECTIVE;
        }

        try
        {
            this.conspectus = new FileInputStream(e);
        } 
        catch (FileNotFoundException fnfe) 
        {
            throw new IllegalArgumentException("Subject::Ctor::File_Not_Found");
        }
    }

    public String getName()
    {
        return this.name;
    }

    // Cannot change name after creation i.e. no setName();

    public double getCredits()
    {
        return this.credits;
    }

    public boolean setCredits(double c)
    {
        if(c < 0)
        {
            return false;
        }

        this.credits = c;
        return true;
    }

    public String getSubjectType()
    {
        return this.subjectType.toString();
    }

    public boolean setSubjectType(SubjectType s)
    {
        this.subjectType = s;
        return true;
    }

    public String getElectiveType()
    {
        return this.electiveType.toString();
    }

    public boolean setElectiveType(ElectiveType e)
    {
        if(this.subjectType == SubjectType.COMPULSORY)
        {
            return false;
        }

        this.electiveType = e;
        return true;
    }

    public String getConspectus() 
    {
        StringBuilder result = new StringBuilder();

        try 
        {
            int content;

            while ((content = conspectus.read()) != -1) 
            {
                result.append((char)content);
            }
        } 
        catch (IOException e) 
        {
            return "";
        } 
        finally 
        {
            if (this.conspectus != null) 
            {
                try 
                {
                    this.conspectus.close();
                } 
                catch (IOException e) 
                {
                    return "";
                }
            }
        }
        return result.toString();
    }

    public boolean setConspectus(String newFile) 
    {
        try 
        {
            if (this.conspectus != null) 
            {
                this.conspectus.close();
            }

            this.conspectus = new FileInputStream(newFile);
            return true;
        } 
        catch (IOException e) 
        {
            return false;
        }
    }

    public String getInfo() 
    {
        return "Name: " + this.name + "\n" +
               "Credits: " + this.credits + "\n" +
               "Subject Type: " + this.subjectType.toString() + "\n" +
               "Elective Type: " + this.electiveType.toString();
    }
}
