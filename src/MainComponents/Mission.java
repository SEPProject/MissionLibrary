package MainComponents;

import GraphicalComponents.DropDownPanelJSWING;
import java.util.ArrayList;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class Mission {

    /**
     * This class is the Mssion object
     * A mission is referen ced by at least his name and often a description
     * It also has submissions but it is not necessary
     */

   
    private String name;
    private String description;
    private ArrayList<Submission> submissions;
    private DropDownPanelJSWING missionDropDownPanel;

    public Mission(String name){
        this.name = name;
        submissions  = new ArrayList<Submission>();
    }

    public Mission(String name,String description){
        this.name = name;
        this.description = description;
        submissions  = new ArrayList<Submission>();
    }

    /**
     * Add a submission to the current mission
     * @param sub the submission to add
     */

    public void addSubmission(Submission sub){
        this.submissions.add(sub);
    }
    
    /**
     *
     * @return  the submission list of the msision
     */

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
    
    public DropDownPanelJSWING getMissionDropDownPanel(){
        return this.missionDropDownPanel;
    }
    
    public void setMissionDropDownPanel(DropDownPanelJSWING ddpj){
        this.missionDropDownPanel = ddpj;
    }

    public boolean hasSubmission(){
        if(submissions.size() != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean hasDescription(){
        if(description == null){
            return false;
        }else{
            return true;
        }
    }
}
