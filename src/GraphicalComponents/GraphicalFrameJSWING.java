package GraphicalComponents;

import MainComponents.Mission;
import UtilsComponent.UtilsJSWING;
import edu.cmu.relativelayout.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class GraphicalFrameJSWING extends JFrame implements AbstractGraphicalFrame{

    JFrame jf;
    JPanel jp;
    JScrollPane jsp;
    JLabel labelTitle;

    ArrayList<JPanel> everyPanelMission;

    UtilsJSWING utils;
    private int X_TITRE = 20;

    private int X_PANEL_SIZE = 800;
    private int X_PREFERRED_SIZE = 795;
    private int Y_PANEL_SIZE = 520 ;
    private int Y_PREFERRED_SIZE = 490;
    private int y = 75;
    private int Y_BASE = 75;
    private int MISSION_SEPARATION = 10;
    private int X_TITLE = 350;
    private int Y_TITLE = 40;

    public GraphicalFrameJSWING(int xPanelSize,int yPanelSize,String title){
        utils = new UtilsJSWING();
        everyPanelMission = new ArrayList<JPanel>();
        jf = new JFrame();
        jf.setSize(xPanelSize, yPanelSize);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        jp = new JPanel();
        jp.setSize(X_PANEL_SIZE, Y_PANEL_SIZE);
        jp.setLayout(new RelativeLayout());

        labelTitle = new JLabel(title);
        RelativeConstraints rc = new RelativeConstraints();
        rc.addBinding(createBindingMarginTop(Y_TITLE, Binding.PARENT));
        rc.addBinding(createBindingMarginLeft(X_TITLE, Binding.PARENT));
        jp.add(labelTitle,rc);

        jsp = new JScrollPane(jp);
        jsp.setSize(X_PREFERRED_SIZE, Y_PREFERRED_SIZE);

        jf.add(jsp);

    }

    private Binding createBindingMarginLeft(int margin,Component comp){
        return  new Binding(Edge.LEFT, margin, Direction.RIGHT, Edge.LEFT,comp);
    }
    private Binding createBindingMarginTop(int margin,Component comp){
        return  new Binding(Edge.TOP, margin, Direction.BELOW, Edge.TOP,comp);
    }

    @Override
    public void refreshFrame() {
        for(int i = 0;i < jp.getComponentCount()-1;i++){
            if(i != 0){
                jp.remove(i);
            }
        }
        y = Y_BASE;
        for(int i = 0;i<this.everyPanelMission.size();i++){
            RelativeConstraints rc = new RelativeConstraints();
            rc.addBinding(createBindingMarginTop(y, Binding.PARENT));
            rc.addBinding(createBindingMarginLeft(X_TITRE, Binding.PARENT));
            y = y+ MISSION_SEPARATION + (int)this.everyPanelMission.get(i).getPreferredSize().getHeight();
            jp.add(this.everyPanelMission.get(i), rc);
        }
        this.repaint();
    }

    public void refreshWidth() {

        for(int i = 0;i<this.everyPanelMission.size();i++){
            this.everyPanelMission.get(i).setPreferredSize(new Dimension(DropDownPanelJSWING.maxWidth,(int)this.everyPanelMission.get(i).getPreferredSize().getHeight()));
        }
        this.repaint();
    }

    @Override
    public void addMissionToFrame(Mission mission) {
        RelativeConstraints rc = new RelativeConstraints();
        DropDownPanelJSWING panel = new DropDownPanelJSWING(mission,this,null);
        everyPanelMission.add(panel);
        rc.addBinding(createBindingMarginTop(y,Binding.PARENT));
        rc.addBinding(createBindingMarginLeft(X_TITRE,Binding.PARENT));
        jp.add(panel, rc);
        y = y+ 10 + (int)panel.getPreferredSize().getHeight();
        this.repaint();
    }

    public JScrollPane getScrollPane(){
        return jsp;
    }
}
