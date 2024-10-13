import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TO:DO remake the message system, it is only one way;

public class Susi<T, N>
{
    private List<Lector> lectors;
    private List<Student> students;  

    private List<Message<T, N>> messages; 
    
    public Susi()
    {
        this.lectors = new ArrayList<Lector>();
        this.students = new ArrayList<Student>();
        this.messages = new ArrayList<Message<T, N>>();
    }

    public Susi(List<Lector> l, List<Student> s)
    {
        this.lectors = l;
        this.students = s;
        this.messages = new ArrayList<Message<T, N>>();
    }

    public List<Lector> getLectors()
    {
        return this.lectors;
    }

    public boolean addLector(Lector l)
    {
        int index = -1;

        for(int i = 0; i < lectors.size(); ++i)
        {
            if(lectors.get(i) == l)
            {
                index = i;
            }
        }

        if(index == -1)
        {
            this.lectors.add(l);
            return true;
        }

        return false;
    }

    public boolean removeLector(Lector l)
    {
        int index = -1;

        for(int i = 0; i < lectors.size(); ++i)
        {
            if(lectors.get(i) == l)
            {
                index = i;
            }
        }

        if(index == -1)
        {
            return false;
        }

        this.lectors.remove(index);
        return true;
    }

    public List<Student> getStudents()
    {
        return this.students;
    }

    public boolean addStudents(Student s)
    {
        int index = -1;

        for(int i = 0; i < students.size(); ++i)
        {
            if(students.get(i) == s)
            {
                index = i;
            }
        }

        if(index == -1)
        {
            this.students.add(s);
            return true;
        }

        return false;
    }

    public boolean removeStudent(Student s)
    {
        int index = -1;

        for(int i = 0; i < students.size(); ++i)
        {
            if(students.get(i) == s)
            {
                index = i;
            }
        }

        if(index == -1)
        {
            return false;
        }

        this.students.remove(index);

        // TO:DO - remove the student from all lectors;

        return true;
    }

    public boolean sendMessage(T sender, N recipient, String content) 
    {
        Message<T, N> message = new Message<T, N>(sender, recipient, content);
        messages.add(message);
        return true;
    }

    public List<Message<T, N>> getMessages() 
    {
        return this.messages;
    }

    public boolean saveMessagesToFile(String filePath) 
    {   // TO:DO fix names of sender and recipient;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
        {
            for (Message<T, N> message : messages) 
            {
                writer.write("Sender: " + message.getSender().toString() + "\n");
                writer.write("Recipient: " + message.getRecipient().toString() + "\n");
                writer.write("Content: " + message.getContent() + "\n");
                writer.write("---------------\n");
            }
        } 
        catch (IOException e) 
        {
            return false;
        }

        return true;
    }
}
