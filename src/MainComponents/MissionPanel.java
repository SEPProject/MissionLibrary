package MainComponents;

import GraphicalComponents.GraphicalFrameJSWING;

import javax.swing.*;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class MissionPanel {

    private GraphicalFrameJSWING gp;

    /**
     * Instatiate a new mission Panel
     */
    private  int X_PANEL_SIZE = 800;
    private  int Y_PANEL_SIZE = 520 ;
    public MissionPanel(int xPanelSize,int yPanelSize,String title){
        this.gp = new GraphicalFrameJSWING(xPanelSize,yPanelSize,title);
    }

    public MissionPanel(String title){
        this.gp = new GraphicalFrameJSWING(X_PANEL_SIZE,Y_PANEL_SIZE,title);
    }

    /**
     * Permit to add a mission to the panel
     * @param mission mission to add in the panel
     */

    public void addMission(Mission mission){
        gp.addMissionToFrame(mission);
    }

    /**
     * Permit the user to get the frame after the add
     * of mission and submission
     * @return the frame associated with every missions added
     */

    public JScrollPane getPannelFrame(){
        return this.gp.getScrollPane();
    }
    

    /*public static void main(String [] args){
            MissionPanel mp = new MissionPanel("SQL Mission");
            Mission mission = new Mission("Premier mission","Premiere description");
            mission.addSubmission(new Submission("Premier sub","Premiere sub desc"));
            mission.addSubmission(new Submission("Deux sub","Deux sub desc"));
            mission.addSubmission(new Submission("Trois sub","Trois sub desc"));
            mission.addSubmission(new Submission("Quatre sub","Quatre sub desc"));

        Mission mission2 = new Mission("Premier mission","Premiere description");
        mission2.addSubmission(new Submission("Premier sub","Premiere sub desc mega longue descirptioo ntout las rd"));
        mission2.addSubmission(new Submission("Deux sub","Deux sub desc"));
        mission2.addSubmission(new Submission("Trois sub","Trois sub desc"));
        mission2.addSubmission(new Submission("Quatre sub","Quatre sub desc"));

        mp.addMission(mission);
        mp.addMission(mission2);
        mp.addMission(mission2);
        mp.getPannelFrame();

    }*/

}
