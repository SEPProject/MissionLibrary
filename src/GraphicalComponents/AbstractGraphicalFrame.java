package GraphicalComponents;

import MainComponents.Mission;

/**
 * Created by julescantegril on 07/03/2015.
 */
public interface AbstractGraphicalFrame {

    public abstract void refreshFrame();
    public abstract void refreshWidth();
    public abstract void addMissionToFrame(Mission mission);

}
