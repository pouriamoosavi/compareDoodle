import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TAManager {
    private ArrayList<TA> tas;

    public TAManager() {
        tas = new ArrayList<>();
    }

    public TAManager(String tasJsonString) {
        tas = new ArrayList<>();
        try{
            JSONObject obj = new JSONObject(tasJsonString);
            JSONArray tas = obj.getJSONArray("participants");
            for (int i = 0; i < tas.length(); i++) {
                TA newTA = new TA(tas.getJSONObject(i).toString());
                this.tas.add(newTA);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add(TA newTA) {
        tas.add(newTA);
    }

    public void increaseStudentCount(int taID) {
        for(TA thisTA: tas) {
            if(thisTA.getID() == taID) {
                thisTA.setStudentCount(thisTA.getStudentCount()+1);
                break;
            }
        }
    }

    public ArrayList<TA> getTas() {
        return tas;
    }
}
