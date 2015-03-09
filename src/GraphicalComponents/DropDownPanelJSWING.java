package GraphicalComponents;

import MainComponents.Mission;
import MainComponents.Submission;
import UtilsComponent.UtilsJSWING;
import edu.cmu.relativelayout.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class DropDownPanelJSWING extends JPanel implements AbstractDropDownPanel {

   static int maxWidth = 0;
    int Y_BASE = 20;
    int DELTA_MISSION = 15;
    int DELTA_SUBMISSION = 40;
    int DELTA_DESCRIPTION = 15;
    int X_TITRE = 20;
    int X_DESCRIPTION = 35;
    int X_SUBMISSION = 35;
    int X_SUBDESCRIPTION = 40;

    int normal_height = 0;
    int ALL_HIDE = 60;

    int y = 20;
    UtilsJSWING utils;

    JLabel missionSubmissionTest;
    GraphicalFrameJSWING gJF;

    private Binding createBindingMarginLeft(int margin){
        return  new Binding(Edge.LEFT, margin, Direction.RIGHT, Edge.LEFT, Binding.PARENT);
    }
    private Binding createBindingMarginTop(int margin){
        return  new Binding(Edge.TOP, margin, Direction.BELOW, Edge.TOP, Binding.PARENT);
    }

    public DropDownPanelJSWING(Mission mission,GraphicalFrameJSWING gJF){
        super();
        utils = new UtilsJSWING();
        this.gJF = gJF;
        this.setBackground(Color.blue);
        this.setLayout(new RelativeLayout());

        final JLabel missionTitle = new JLabel(mission.getName());
        missionTitle.setBorder(BorderFactory.createEmptyBorder(0, X_TITRE, 0, 0));
        utils.setTitle(missionTitle);

        y = y + DELTA_MISSION;

        RelativeConstraints rc = new RelativeConstraints();
        rc.addBinding(createBindingMarginLeft(X_TITRE));
        rc.addBinding(createBindingMarginTop(y));
        y = y + DELTA_DESCRIPTION;
        this.add(missionTitle, rc);
        if(mission.hasDescription()){
            JLabel missionDescription = new JLabel(mission.getDescription());
            missionDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION, X_DESCRIPTION, 0, 0));

            RelativeConstraints rc2 = new RelativeConstraints();
            rc2.addBinding(createBindingMarginLeft(X_DESCRIPTION));
            rc2.addBinding(createBindingMarginTop(y));

            utils.setDescription(missionDescription);
            this.add(missionDescription, rc2);
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
                this.add(missionSubmission, rc3);
                y = y + DELTA_SUBMISSION;

                if(sub.hasDescription()){
                    JLabel missionSubDescription = new JLabel(sub.getDescription());
                    missionSubDescription.setBorder(BorderFactory.createEmptyBorder(DELTA_DESCRIPTION,X_SUBDESCRIPTION , 0, 0));
                    missionSubmissionTest = missionSubDescription;

                    RelativeConstraints rc4 = new RelativeConstraints();
                    rc4.addBinding(createBindingMarginLeft(X_SUBDESCRIPTION));
                    rc4.addBinding(createBindingMarginTop(y));

                    utils.setSubdescription(missionSubDescription);
                    this.add(missionSubDescription, rc4);
                    y = y + DELTA_DESCRIPTION;
                }
                Y_BASE = Y_BASE + DELTA_SUBMISSION;
            }
        }

        Y_BASE = Y_BASE + DELTA_MISSION;

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                if (normal_height == 0) {
                    normal_height = (int) getPanel().getPreferredSize().getHeight();
                }

                if (missionSubmissionTest.isVisible()) {
                    missionSubmissionTest.setVisible(false);
                    getPanel().setPreferredSize(new Dimension(DropDownPanelJSWING.maxWidth,ALL_HIDE));
                    getPanel().repaint();
                } else {
                    missionSubmissionTest.setVisible(true);
                    getPanel().setPreferredSize(new Dimension(DropDownPanelJSWING.maxWidth,normal_height));
                    getPanel().repaint();
                }
                getgJF().refreshFrame();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        if(normal_height == 0){
            normal_height = (int)getPanel().getPreferredSize().getHeight();
        }
        missionSubmissionTest.setVisible(false);
        if( (int) getPanel().getPreferredSize().getWidth() > maxWidth){
            DropDownPanelJSWING.maxWidth = (int) getPanel().getPreferredSize().getWidth()+10;
        }
        getPanel().setPreferredSize(new Dimension(DropDownPanelJSWING.maxWidth, ALL_HIDE));
        getPanel().repaint();
        getgJF().refreshWidth();
    }

    @Override
    public void setMission(Mission mission) {

    }

    @Override
    public void dropDown(boolean drop) {

    }

    @Override
    public void addSubmissionToPanel(Submission mission) {

    }

    public DropDownPanelJSWING getPanel(){
        return this;
    }

    public GraphicalFrameJSWING getgJF(){
        return this.gJF;
    }
}
