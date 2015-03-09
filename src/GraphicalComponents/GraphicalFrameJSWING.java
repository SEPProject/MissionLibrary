package GraphicalComponents;

import MainComponents.Mission;
import MainComponents.Submission;
import UtilsComponent.UtilsJSWING;
import edu.cmu.relativelayout.*;

import javax.swing.*;

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
    int X_DESCRIPTION = 35;
    int X_SUBMISSION = 35;
    int X_SUBDESCRIPTION = 40;

    int X_PANEL_SIZE = 800;
    int X_PREFERRED_SIZE = 795;
    int Y_PANEL_SIZE = 520 ;
    int Y_PREFERRED_SIZE = 490;

    public GraphicalFrameJSWING(){
        utils = new UtilsJSWING();

        jf = new JFrame();
        jf.setSize(X_PANEL_SIZE, Y_PANEL_SIZE);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp = new JPanel();
        jp.setSize(X_PANEL_SIZE, Y_PANEL_SIZE);
        jp.setLayout(new RelativeLayout());

        jsp = new JScrollPane(jp);
        jsp.setSize(X_PREFERRED_SIZE, Y_PREFERRED_SIZE);

        jf.add(jsp);

    }

    private Binding createBindingMarginLeft(int margin){
        return  new Binding(Edge.LEFT, margin, Direction.RIGHT, Edge.LEFT, Binding.PARENT);
    }
    private Binding createBindingMarginTop(int margin){
        return  new Binding(Edge.TOP, margin, Direction.BELOW, Edge.TOP, Binding.PARENT);
    }
    @Override
    public void refreshFrame() {

    }

    int y = 20;
    @Override
    public void addMissionToFrame(Mission mission) {
        JLabel missionTitle = new JLabel(mission.getName());
        missionTitle.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION, X_TITRE, 0, 0));
        utils.setTitle(missionTitle);



        RelativeConstraints rc = new RelativeConstraints();
        rc.addBinding(createBindingMarginLeft(X_TITRE));
        rc.addBinding(createBindingMarginTop(y));
        y = y + DELTA_DESCRIPTION;
        jp.add(missionTitle,rc);
        if(mission.hasDescription()){
            JLabel missionDescription = new JLabel(mission.getDescription());
            missionDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION, X_DESCRIPTION, 0, 0));

            RelativeConstraints rc2 = new RelativeConstraints();
            rc2.addBinding(createBindingMarginLeft(X_DESCRIPTION));
            rc2.addBinding(createBindingMarginTop(y));

            utils.setDescription(missionDescription);
            jp.add(missionDescription,rc2);
            y = y + DELTA_DESCRIPTION;
        }
        if(mission.hasSubmission()){
            for(int i = 0;i < mission.getSubmissions().size();i++){
                Submission sub = mission.getSubmissions().get(i);
                JLabel missionSubmission = new JLabel(sub.getName());
                missionSubmission.setBorder(BorderFactory.createEmptyBorder(DELTA_SUBMISSION,X_SUBMISSION , 0, 0));

                RelativeConstraints rc3 = new RelativeConstraints();
                rc3.addBinding(createBindingMarginLeft(X_SUBMISSION));
                rc3.addBinding(createBindingMarginTop(y));

                utils.setSubtitle(missionSubmission);
                jp.add(missionSubmission,rc3);
                y = y + DELTA_SUBMISSION;

                if(sub.hasDescription()){
                    JLabel missionSubDescription = new JLabel(sub.getDescription());
                    missionSubDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION,X_SUBDESCRIPTION , 0, 0));

                    RelativeConstraints rc4 = new RelativeConstraints();
                    rc4.addBinding(createBindingMarginLeft(X_SUBDESCRIPTION));
                    rc4.addBinding(createBindingMarginTop(y));

                    utils.setSubdescription(missionSubDescription);
                    jp.add(missionSubDescription,rc4);
                    y = y + DELTA_DESCRIPTION;
                }
                Y_BASE = Y_BASE + DELTA_SUBMISSION;
            }
        }

        Y_BASE = Y_BASE + DELTA_MISSION;
    }
}
