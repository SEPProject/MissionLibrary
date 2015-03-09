package GraphicalComponents;

import MainComponents.Mission;
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
    int X_TITRE = 20;

    int X_PANEL_SIZE = 800;
    int X_PREFERRED_SIZE = 795;
    int Y_PANEL_SIZE = 520 ;
    int Y_PREFERRED_SIZE = 490;
    int y = 20;

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

    @Override
    public void addMissionToFrame(Mission mission) {
        RelativeConstraints rc = new RelativeConstraints();
        rc.addBinding(createBindingMarginLeft(X_TITRE));
        rc.addBinding(createBindingMarginTop(y));
        DropDownPanelJSWING panel = new DropDownPanelJSWING(mission);
        jp.add(panel, rc);
        y = y+ 10 + (int)panel.getPreferredSize().getHeight();
        ;
    }
}
