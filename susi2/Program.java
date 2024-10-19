public class Program 
{
    public static void main(String[] args) 
    {
        Data data = new Data();   
        data.addAdmin("admin", "123");
        data.addTeacher("teach", "123");
        data.addStudent("stud", "123");
        
        Logger logger = new Logger(data);
        logger.logIn("admin", "123");

        Runner runner = new Runner(logger);
        runner.getAccessableFuncs().get(2).run();
    }    
}
