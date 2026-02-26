import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
    public static void main(String[] args) {
        String[] firstNames = {"Tharindu", "Kasun", "Nimal", "Saman", "Kamal", "Ruwan", "Lahiru", "Nuwan", "Chathura", "Ishara"};
        String[] lastNames = {"Perera", "Silva", "Bandara", "Fernando", "de Silva", "Jayakody", "Gunawardena", "Weerasinghe", "Dissanayake", "Jayasinghe"};
        String[] courses = {"CS101", "SE202", "IT303", "IS404", "DS505", "ENG101", "MAT201"};
        String[] districts = {"Colombo", "Gampaha", "Kalutara", "Kandy", "Matale", "Galle", "Matara", "Kurunegala", "Anuradhapura", "Ratnapura"};
        
        Random rand = new Random();
        
        try (FileWriter writer = new FileWriter("enroll records.txt")) {
            writer.write("Student ID\tFull Name\tNIC Number\tCourse Code\tGPA\tDistrict\tIs Enrolled\tDate of Birth\n");
            
            for (int i = 1; i <= 150; i++) {
                String studentId = "STU" + (1000 + i);
                String fullName = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
                String nic = (90 + rand.nextInt(10)) + "" + rand.nextInt(4) + "" + (100 + rand.nextInt(265)) + "" + (1000 + rand.nextInt(9000)) + "v";
                String course = courses[rand.nextInt(courses.length)];
                double gpa = 2.0 + (4.0 - 2.0) * rand.nextDouble();
                String district = districts[rand.nextInt(districts.length)];
                String isEnrolled = rand.nextBoolean() ? "TRUE" : "FALSE";
                String dob = (1 + rand.nextInt(12)) + "/" + (1 + rand.nextInt(28)) + "/199" + rand.nextInt(10);
                
                String record = String.format("%s\t%s\t%s\t%s\t%.2f\t%s\t%s\t%s\n", studentId, fullName, nic, course, gpa, district, isEnrolled, dob);
                writer.write(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
