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
    JPanel jp;

    UtilsJSWING utils;
    int xBase = 20;
    int yBase = 20;
    int deltaMission = 30;
    int deltaSubmission = 40;
    int deltaDescription = 15;
    int xTitre = 20;
    int xDescription = 25;
    int xSubmission = 25;
    int xSubDescription = 30;


    public GraphicalFrameJSWING(){
        utils = new UtilsJSWING();
        jf = new JFrame();
        jf.setSize(800, 500);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp = new JPanel();
        jf.getContentPane().add(jp);

    }

    @Override
    public void refreshFrame() {

    }

    @Override
    public void addMissionToFrame(Mission mission) {
        JLabel missionTitle = new JLabel(mission.getName());
        missionTitle.setBounds(xTitre, yBase, 400, 50);//x y w h
        utils.setTitle(missionTitle);
        jf.getContentPane().add(missionTitle);
        yBase = yBase+deltaDescription;
        if(mission.hasDescription()){
            JLabel missionDescription = new JLabel(mission.getDescription());
            missionDescription.setBounds(xDescription, yBase, 400, 50);//x y w h
            utils.setDescription(missionDescription);
            jf.getContentPane().add(missionDescription);
        }
        yBase = yBase+deltaSubmission;
        if(mission.hasSubmission()){
            for(int i = 0;i < mission.getSubmissions().size();i++){
                Submission sub = mission.getSubmissions().get(i);
                JLabel missionSubmission = new JLabel(sub.getName());
                missionSubmission.setBounds(xSubmission, yBase, 400, 50);//x y w h
                utils.setSubtitle(missionSubmission);
                jf.getContentPane().add(missionSubmission);
                if(sub.hasDescription()){
                    yBase = yBase + deltaDescription;
                    JLabel missionSubDescription = new JLabel(sub.getDescription());
                    missionSubDescription.setBounds(xSubDescription, yBase, 400, 50);//x y w h
                    utils.setSubdescription(missionSubDescription);
                    jf.getContentPane().add(missionSubDescription);
                }
                yBase = yBase + deltaSubmission;
            }
        }
        yBase = yBase + deltaMission;
        jf.revalidate();
        jf.repaint();
    }
}
