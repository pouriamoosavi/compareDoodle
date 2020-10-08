import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Student {
    private int ID;
    private String name;
    private ArrayList<Integer> preferences;
    private String TAName;

    public Student(int ID, String name, ArrayList<Integer> preferences) {
        this.ID = ID;
        this.name = name;
        this.preferences = preferences;
        this.TAName = "";
    }

    public Student(String jsonStringStudent) {
        try {
            JSONObject obj = new JSONObject(jsonStringStudent);
            this.ID = obj.getInt("id");
            this.name = obj.getString("name");
            this.TAName = "";

            JSONArray preferencesJsonArr = obj.getJSONArray("preferences");
            this.preferences = new ArrayList<Integer>();
            for (int i = 0; i < preferencesJsonArr.length(); i++) {
                this.preferences.add(preferencesJsonArr.getInt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Integer> getPreferences() {
        return preferences;
    }

    public void setTAName(String TAName) {
        this.TAName = TAName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + "'" +
                ", TAName='" + TAName + "'" +
                '}';
    }
}
