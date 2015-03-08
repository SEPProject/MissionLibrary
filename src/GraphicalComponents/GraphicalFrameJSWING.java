package GraphicalComponents;

import MainComponents.Mission;
import MainComponents.Submission;
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
            missionDescription.setBounds(20, 60, 400, 50);//x y w h
            utils.setDescription(missionDescription);
            jf.getContentPane().add(missionDescription);
        }
        if(mission.hasSubmission()){
            int xBase = 20;
            int yBase = 100;
            for(int i = 0;i < mission.getSubmissions().size();i++){
                Submission sub = mission.getSubmissions().get(i);
                JLabel missionSubmission = new JLabel(sub.getName());
                missionSubmission.setBounds(xBase, yBase, 400, 50);//x y w h
                utils.setSubtitle(missionSubmission);
                jf.getContentPane().add(missionSubmission);
                if(sub.hasDescription()){
                    yBase = yBase + 40;
                    JLabel missionSubDescription = new JLabel(sub.getDescription());
                    missionSubDescription.setBounds(xBase, yBase, 400, 50);//x y w h
                    utils.setSubdescription(missionSubDescription);
                    jf.getContentPane().add(missionSubDescription);
                }
                yBase = yBase + 40;
            }
        }

        jf.revalidate();
    }
}
