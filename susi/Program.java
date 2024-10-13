import java.util.ArrayList;
import java.util.List;

public class Program 
{
    public static void main(String[] args) 
    {   // Test Scenario;
        String discrete_structures = "Discrete Structures";
        String discrete_structure_conspectus = "D:\\\\Dji\\\\3_education\\\\university_1-4_course\\\\course_3\\\\semester_5\\\\design_patterns_for_reusable_software_design\\\\week-02\\\\susi\\\\Conspectus\\\\DS.txt";
        Subject subject_1 = new Subject(discrete_structures, 8, SubjectType.COMPULSORY, ElectiveType.NOT_ELECTIVE, discrete_structure_conspectus);

        String object_oriented = "Object Oriented Programming";
        String object_oriented_conspectus = "D:\\Dji\\3_education\\university_1-4_course\\course_3\\semester_5\\design_patterns_for_reusable_software_design\\week-02\\susi\\Conspectus\\OOP.txt";
        Subject subject_2 = new Subject(object_oriented, 5, SubjectType.COMPULSORY, ElectiveType.NOT_ELECTIVE, object_oriented_conspectus);

        String data_structures = "Data Structures & Algorithms";
        String data_structures_conspectus = "D:\\\\Dji\\\\3_education\\\\university_1-4_course\\\\course_3\\\\semester_5\\\\design_patterns_for_reusable_software_design\\\\week-02\\\\susi\\\\Conspectus\\\\DSA.txt";
        Subject subject_5 = new Subject(data_structures, 3.5, SubjectType.COMPULSORY, ElectiveType.NOT_ELECTIVE, data_structures_conspectus);

        String descriptive_geometry = "Descriptive Geometry";
        String descriptive_geometry_conspectus = "D:\\\\Dji\\\\3_education\\\\university_1-4_course\\\\course_3\\\\semester_5\\\\design_patterns_for_reusable_software_design\\\\week-02\\\\susi\\\\Conspectus\\\\DG.txt";
        Subject subject_3 = new Subject(descriptive_geometry, 7, SubjectType.ELECTIVE, ElectiveType.MATHEMATICS, descriptive_geometry_conspectus);

        String higher_algebra = "Higher Algebra";
        String higher_algebra_conspectus = "D:\\\\Dji\\\\3_education\\\\university_1-4_course\\\\course_3\\\\semester_5\\\\design_patterns_for_reusable_software_design\\\\week-02\\\\susi\\\\Conspectus\\\\HA.txt";
        Subject subject_4 = new Subject(higher_algebra, 4, SubjectType.COMPULSORY_ELECTIVE, ElectiveType.KERNELS, higher_algebra_conspectus);

        Tuple<String> stoyan_name = new Tuple<String>("Stoyan", "Stoyanov", "Ivanov");
        String stoyan_fn = "9MI0400132";
        String stoyan_email = "sustoyanivanov2@gmail.com";
        String stoyan_password = "password12345";
        Student stoyan = new Student(stoyan_name, stoyan_fn, 3, 1,Area.INFORMATICS, stoyan_email, stoyan_password, true);

        stoyan.addExam(subject_1, 2.0);
        stoyan.addExam(subject_2, 4.0);
        stoyan.addExam(subject_3, 6.0);

        // System.out.println(stoyan.getInfo());

        Tuple<String> jessica_name = new Tuple<String>("Jessica", "Sami", "Bidjerano");
        String jessica_fn = "0MI0400167";
        String jessica_email = "jessica_bidj@abv.bg";
        String jessica_password = "stupiiiid";
        Student jessica = new Student(jessica_name, jessica_fn, 3, 1, Area.INFORMATICS, jessica_email, jessica_password, true);

        jessica.addExam(subject_1, 4.0);
        jessica.addExam(subject_2, 4.0);
        jessica.addExam(subject_3, 4.0);

        // System.out.println(jessica.getInfo());

        Tuple<String> kris_name = new Tuple<String>("Kristiyan", "Rumenov", "Stoimenov");
        String kris_fn = "3MI0400121";
        String kris_email = "kris_stoimenov@fmi-uni.bg";
        String kris_password = "wnkrgiuwqrhagnoirh";
        Student kris = new Student(kris_name, kris_fn, 3, 2, Area.COMPUTER_SCIENCE, kris_email, kris_password, true);

        kris.addExam(subject_1, 5.5);
        kris.addExam(subject_2, 6.0);
        kris.addExam(subject_4, 3.5);

        // System.out.println(kris.getInfo());

        Tuple<String> armqnov_name = new Tuple<String>("Petar", "Ruslanov", "Armqnov");
        List<Subject> armqnov_subjects = new ArrayList<Subject>();
        armqnov_subjects.add(subject_5);
        armqnov_subjects.add(subject_2);
        String armqnov_email = "parmqnov@gmail.bg";
        String armqnov_password = "dmvoihwruogbrwojg";
        Lector armqnov = new Lector(armqnov_name, Department.PROGRAMMING, armqnov_subjects, armqnov_email, armqnov_password);

        List<Student> armqnov_students_oop = new ArrayList<Student>();
        List<Student> armqnov_students_sda = new ArrayList<Student>();
        armqnov_students_oop.add(stoyan);
        armqnov_students_oop.add(jessica);
        armqnov_students_oop.add(kris);
        armqnov.addStudents(subject_2, armqnov_students_oop);
        armqnov.addStudents(subject_5, armqnov_students_sda);

        // System.out.println(armqnov.getInfo());
        // armqnov.generateProtocols();
        // armqnov.generateGradesBySubject();

        Tuple<String> markov_name = new Tuple<String>("Minko", "Marinov", "Markov");
        List<Subject> markov_subjects = new ArrayList<Subject>();
        markov_subjects.add(subject_1);
        String markov_email = "mmarkov@gmail.bg";
        String markov_password = "shte_skusam_vseki";
        Lector markov = new Lector(markov_name, Department.LOGIC, markov_subjects, markov_email, markov_password);

        List<Student> markov_students_ds = new ArrayList<Student>();
        markov_students_ds.add(stoyan);
        markov_students_ds.add(jessica);
        markov_students_ds.add(kris);
        markov.addStudents(subject_1, markov_students_ds);

        // System.out.println(markov.getInfo());
        // markov.generateProtocols();
        // markov.generateGradesBySubject();

        markov.gradeIndivStudent(subject_1, stoyan, 3.0);

        Tuple<String> ruseva_name = new Tuple<String>("Asya", "Inatova", "Ruseva");
        List<Subject> ruseva_subjects = new ArrayList<Subject>();
        ruseva_subjects.add(subject_3);
        String ruseva_email = "geometry_high@gmail.bg";
        String ruseva_password = "gpjrwoghwrbhu";
        Lector ruseva = new Lector(ruseva_name, Department.GEOMETRY, ruseva_subjects, ruseva_email, ruseva_password);

        List<Student> ruseva_students_dg = new ArrayList<Student>();
        ruseva_students_dg.add(stoyan);
        ruseva_students_dg.add(jessica);
        ruseva.addStudents(subject_3, ruseva_students_dg);

        // System.out.println(ruseva.getInfo());
        // ruseva.generateProtocols();
        // ruseva.generateGradesBySubject();

        Tuple<String> bojilov_name = new Tuple<String>("Asen", "NULL", "Bojilov");
        List<Subject> bojilov_subjects = new ArrayList<Subject>();
        bojilov_subjects.add(subject_4);
        String bojilov_email = "algebra_drunk@gmail.bg";
        String bojilov_password = "gpjrwoghwrbhu";
        Lector bojilov = new Lector(bojilov_name, Department.MATHEMATICS, bojilov_subjects, bojilov_email, bojilov_password);

        List<Student> bojilov_students_ha = new ArrayList<Student>();
        bojilov_students_ha.add(kris);
        bojilov.addStudents(subject_4, bojilov_students_ha);

        // System.out.println(bojilov.getInfo());
        // bojilov.generateProtocols();
        // bojilov.generateGradesBySubject();

        List<Lector> lectors = new ArrayList<Lector>();
        lectors.add(armqnov);
        lectors.add(markov);
        lectors.add(ruseva);

        List<Student> students = new ArrayList<Student>();
        students.add(stoyan);
        students.add(jessica);

        Susi<Lector, Student> susi = new Susi<Lector, Student>(lectors, students);

        susi.addLector(bojilov);
        susi.addStudents(kris);

        for(Lector l : susi.getLectors())
        {
            System.out.println(l.getInfo());
            l.generateProtocols();
            l.generateGradesBySubject();
        }

        for(Student s : susi.getStudents())
        {
            System.out.println(s.getInfo());
            System.out.println("All Credits: ");
            System.out.println(s.getAllCredits());
        }

        String msg = "No 3!";
        susi.sendMessage(markov, stoyan, msg);
        susi.saveMessagesToFile("D:\\Dji\\3_education\\university_1-4_course\\course_3\\semester_5\\design_patterns_for_reusable_software_design\\week-02\\susi\\Messages\\Messages.txt");

    }
}
