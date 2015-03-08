package GraphicalComponents;

import MainComponents.Mission;
import MainComponents.Submission;
import UtilsComponent.UtilsJSWING;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class GraphicalFrameJSWING extends JFrame implements AbstractGraphicalFrame{

    JFrame jf;
    JPanel jpLittle;
    JPanel jp;
    JScrollPane jsp;

    UtilsJSWING utils;
    int Y_BASE = 20;
    int DELTA_MISSION = 30;
    int DELTA_SUBMISSION = 40;
    int DELTA_DESCRIPTION = 15;
    int X_TITRE = 20;
    int X_DESCRIPTION = 25;
    int X_SUBMISSION = 25;
    int X_SUBDESCRIPTION = 30;


    public GraphicalFrameJSWING(){
        utils = new UtilsJSWING();
        jf = new JFrame();
        jf.setSize(800, 500);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp = new JPanel();
        jp.setSize(800, 500);
        jp.setLayout(new GridLayout(30,0));

        jsp = new JScrollPane(jp);
        jsp.setSize(800, 500);

        jf.add(jsp);

    }

    @Override
    public void refreshFrame() {

    }

    @Override
    public void addMissionToFrame(Mission mission) {
        JLabel missionTitle = new JLabel(mission.getName());
        missionTitle.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION, X_TITRE, 0, 0));
        utils.setTitle(missionTitle);
        jp.add(missionTitle);
        if(mission.hasDescription()){
            JLabel missionDescription = new JLabel(mission.getDescription());
            missionDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION, X_DESCRIPTION, 0, 0));

            utils.setDescription(missionDescription);
            jp.add(missionDescription);
        }
        if(mission.hasSubmission()){
            for(int i = 0;i < mission.getSubmissions().size();i++){
                Submission sub = mission.getSubmissions().get(i);
                JLabel missionSubmission = new JLabel(sub.getName());
                missionSubmission.setBorder(BorderFactory.createEmptyBorder(DELTA_SUBMISSION,X_SUBMISSION , 0, 0));

                utils.setSubtitle(missionSubmission);
                jp.add(missionSubmission);
                if(sub.hasDescription()){
                    JLabel missionSubDescription = new JLabel(sub.getDescription());
                    missionSubDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION,X_SUBDESCRIPTION , 0, 0));

                    utils.setSubdescription(missionSubDescription);
                    jp.add(missionSubDescription);
                }
                Y_BASE = Y_BASE + DELTA_SUBMISSION;
            }
        }

        Y_BASE = Y_BASE + DELTA_MISSION;
    }
}
