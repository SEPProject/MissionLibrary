package GraphicalComponents;

import MainComponents.Mission;
import UtilsComponent.UtilsJSWING;

import javax.swing.*;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class GraphicalFrameJSWING extends JFrame implements AbstractGraphicalFrame{

    JFrame jf;
    UtilsJSWING utils;
    public GraphicalFrameJSWING(){
        utils = new UtilsJSWING();
        jf = new JFrame();
        jf.setSize(800,500);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void refreshFrame() {

    }

    @Override
    public void addMissionToFrame(Mission mission) {
        JLabel missionTitle = new JLabel(mission.getName());
        missionTitle.setBounds(10, 10, 400, 50);//x y w h
        utils.setTitle(missionTitle);
        jf.getContentPane().add(missionTitle);

        if(mission.hasDescription()){
            JLabel missionDescription = new JLabel(mission.getDescription());
            missionDescription.setBounds(15, 60, 400, 50);//x y w h
            utils.setTitle(missionDescription);
            jf.getContentPane().add(missionDescription);
        }
        if(mission.hasSubmission()){

        }

        jf.revalidate();
    }
}
