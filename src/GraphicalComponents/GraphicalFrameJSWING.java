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
    JPanel jpLittle;
    JPanel jp;
    JScrollPane jsp;

    ArrayList<JPanel> everyPanelMission;

    UtilsJSWING utils;
    int X_TITRE = 20;

    int X_PANEL_SIZE = 800;
    int X_PREFERRED_SIZE = 795;
    int Y_PANEL_SIZE = 520 ;
    int Y_PREFERRED_SIZE = 490;
    int y = 20;

    public GraphicalFrameJSWING(){
        utils = new UtilsJSWING();
        everyPanelMission = new ArrayList<JPanel>();
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

    private Binding createBindingMarginLeft(int margin,Component comp){
        return  new Binding(Edge.LEFT, margin, Direction.RIGHT, Edge.LEFT,comp);
    }
    private Binding createBindingMarginTop(int margin,Component comp){
        return  new Binding(Edge.TOP, margin, Direction.BELOW, Edge.TOP,comp);
    }
    @Override
    public void refreshFrame() {
        jp.removeAll();
        y = 20;
        for(int i = 0;i<this.everyPanelMission.size();i++){
            RelativeConstraints rc = new RelativeConstraints();
            rc.addBinding(createBindingMarginTop(y, Binding.PARENT));
            rc.addBinding(createBindingMarginLeft(X_TITRE, Binding.PARENT));
            y = y+ 10 + (int)this.everyPanelMission.get(i).getPreferredSize().getHeight();
            jp.add(this.everyPanelMission.get(i), rc);
        }
        this.repaint();
    }

    @Override
    public void addMissionToFrame(Mission mission) {
        RelativeConstraints rc = new RelativeConstraints();
        DropDownPanelJSWING panel = new DropDownPanelJSWING(mission,this);
        everyPanelMission.add(panel);
        rc.addBinding(createBindingMarginTop(y,Binding.PARENT));
        rc.addBinding(createBindingMarginLeft(X_TITRE,Binding.PARENT));
        jp.add(panel, rc);
        y = y+ 10 + (int)panel.getPreferredSize().getHeight();
    }
}
