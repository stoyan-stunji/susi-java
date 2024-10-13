public class Message<T, N> 
{
    private T sender; 
    private N recipient; 
    private String content;
    
    public Message(T sender, N recipient, String content) 
    {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }
    
    public T getSender() 
    {
        return this.sender;
    }
    
    public N getRecipient() 
    {
        return this.recipient;
    }
    
    public String getContent() 
    {
        return this.content;
    }
}
