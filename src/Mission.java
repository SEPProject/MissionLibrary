import java.util.ArrayList;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class Mission {

    /**
     * This class is the Mission object
     * A mission is referenced by at least his name and often a description
     * It also has submissions but it is not necessary
     */

    private String name;
    private String description;
    private ArrayList<Submission> submissions;

    public Mission(String name){
        this.name = name;
        submissions  = new ArrayList<Submission>();
    }

    public Mission(String name,String description){
        this.name = name;
        this.description = description;
        submissions  = new ArrayList<Submission>();
    }

    public void addSubmission(Submission sub){
        this.submissions.add(sub);
    }

    public ArrayList<Submission> getSubmissions(){
        return this.submissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
