package MainComponents;

import GraphicalComponents.GraphicalFrameJSWING;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class MissionPanel {

    private GraphicalFrameJSWING gp;

    /**
     * Instatiate a new mission Panel
     */

    public MissionPanel(){
        this.gp = new GraphicalFrameJSWING();
    }

    /**
     * Permit to add a mission to the panel
     * @param mission mission to add in the panel
     */

    public void addMission(Mission mission){
    }

    /**
     * Permit the user to get the frame after the add of mission and submission
     * @return the frame associated with every missions added
     */

    public GraphicalFrameJSWING getPannelFrame(){
        return this.gp;
    }
    



}
