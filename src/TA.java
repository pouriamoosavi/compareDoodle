import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TA {
    private int ID;
    private String name;
    private ArrayList<Integer> preferences;
    private int studentCount;

    public TA(int ID, String name, ArrayList<Integer> preferences) {
        this.ID = ID;
        this.name = name;
        this.preferences = preferences;
        this.studentCount = 0;
    }

    public TA(String jsonStringStudent) {
        try {
            JSONObject obj = new JSONObject(jsonStringStudent);
            this.ID = obj.getInt("id");
            this.name = obj.getString("name");
            this.studentCount = 0;

            JSONArray preferencesJsonArr = obj.getJSONArray("preferences");
            this.preferences = new ArrayList<Integer>();
            for (int i = 0; i < preferencesJsonArr.length(); i++) {
                this.preferences.add(preferencesJsonArr.getInt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void increaseStudentCount() {
        this.studentCount = this.studentCount+1;
    }

    @Override
    public String toString() {
        return "TA{" +
                "ID=" + ID +
                ", name='" + name + "'" +
                ", studentCount=" + studentCount +
                '}';
    }
}
