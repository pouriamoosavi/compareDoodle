import org.json.*;

public class Main {
    private static int StudentCountLimit = 3;
    public static void main(String[] args) {
        ReadPropertyFile config = new ReadPropertyFile();
        String StudentsDoodleUrl = config.getProperty("studentDoodleUrl");
        String tAsDoodleUrl = config.getProperty("taDoodleUrl");
        String studentsDoodleRes = Doodle.geRes(StudentsDoodleUrl);
        String tasDoodleRes = Doodle.geRes(tAsDoodleUrl);

        StudentManager stdManager = new StudentManager(studentsDoodleRes);
        TAManager taManager = new TAManager(tasDoodleRes);

        assignTaToStudent(stdManager, taManager);
        System.out.println("================students=============");
        for(Student st: stdManager.getStudents()) {
            System.out.println(st.toString());
        }
        System.out.println("==================tas================");
        for(TA ta: taManager.getTas()) {
            System.out.println(ta.toString());
        }
    }

    public static void assignTaToStudent(StudentManager stdManager, TAManager taManager) {
        loopOverStudents: for(Student std: stdManager.getStudents()) {
            for(int i=0; i< std.getPreferences().size(); i++) {
                int thisStdPref = std.getPreferences().get(i);
                if(thisStdPref == 1) {
                    for(TA ta: taManager.getTas()) {
                        if(ta.getStudentCount() >= StudentCountLimit) continue;
                        for(int j=0; j< ta.getPreferences().size(); j++) {
                            int thisTAPref = ta.getPreferences().get(i);
                            if(thisTAPref == 1 && i==j) {
                                std.setTAName(ta.getName());
                                ta.increaseStudentCount();
                                continue loopOverStudents;
                            }
                        }
                    }
                }
            }
        }

    }

    public static void parseJson(String jsonString) {
        try{
            JSONObject obj = new JSONObject(jsonString);
            JSONArray options = obj.getJSONArray("options");
            for (int i = 0; i < options.length(); i++) {
                System.out.println(options.getJSONObject(i).toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
