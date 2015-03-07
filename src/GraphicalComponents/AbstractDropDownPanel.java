package GraphicalComponents;

import MainComponents.Mission;
import MainComponents.Submission;

/**
 * Created by julescantegril on 07/03/2015.
 */
public interface AbstractDropDownPanel {

    public abstract void setMission(Mission mission);
    public abstract void dropDown(boolean drop);
    public abstract void addSubmissionToPanel(Submission mission);
}
