import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentManager {
   private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public StudentManager(String studentsJsonString) {
        students = new ArrayList<>();
        try{
            JSONObject obj = new JSONObject(studentsJsonString);
            JSONArray students = obj.getJSONArray("participants");
            for (int i = 0; i < students.length(); i++) {
                Student newStudent = new Student(students.getJSONObject(i).toString());
                this.students.add(newStudent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add(Student newStudent) {
        students.add(newStudent);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
