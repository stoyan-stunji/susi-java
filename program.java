import java.util.ArrayList;
import java.util.List;

public class program 
{
    public static void main(String[] args) 
    {
        subject discrete_structures = new subject("Discrete Structures", 2);
        subject higher_algebra = new subject("Higher Algebra", 3);
        subject object_oriented = new subject("Object Oriented", 4);
        List<subject> s_exams = new ArrayList<subject>();

        s_exams.add(discrete_structures);
        s_exams.add(higher_algebra);
        s_exams.add(object_oriented);

        student stoyan = new student("Stoyan", "Stoyanov", "Ivanov", "9MI0400132", 3, 1, specialty.INFORMATICS, true, "htcstoyanivanov2@gmail.com", s_exams);

        subject linear_algebra = new subject("Linear Algebra", 4);
        subject structures_and_algorithms = new subject("Structures & Algorithms", 5);
        List<subject> j_exams = new ArrayList<subject>();

        j_exams.add(linear_algebra);
        j_exams.add(discrete_structures);
        j_exams.add(structures_and_algorithms);

        student jessica = new student("Jessica", "Sami", "Bidgerano", "0MI0400167", 2, 3, specialty.COMPUTER_SCIENCE, false, "jb@gmail.com", j_exams);

        List<subject> k_exams = new ArrayList<subject>();

        k_exams.add(object_oriented);
        k_exams.add(structures_and_algorithms);

        student kris = new student("Kristiyan", "NULL", "Stoimenov", "NULL", 1, 8, specialty.APPLIED_MATHS, true, "NULL", k_exams);

        List<student> students = new ArrayList<student>();
        students.add(stoyan);
        students.add(jessica);

        List<lector> lectors = new ArrayList<lector>();

        susi website = new susi(students, lectors);

        website.add_student(kris);

        lector armqnov = new lector("Petar", "Ruslanov", "Armqnov", faculty.LOGIC, "pe@abv.bg");
        // website.remove_student(stoyan)
        website.add_lector(armqnov);
        
        // website.remove_lector(armqnov);

        System.out.println(website.to_string());
        // System.out.println(website.get_student(stoyan).to_string());

        // website.get_student(stoyan).take_exam(structures_and_algorithms);
        // System.out.println(website.get_student(stoyan).to_string());

        // System.out.println(website.seacrh_by_first_name("Stoyan").get(0).to_string());

    }
}
