package UtilsComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julescantegril on 07/03/2015.
 */
public class UtilsJSWING implements AbstractUtils<JLabel> {

    public void setPanelTitle(JLabel text){
        Font font = new Font("Serif", Font.BOLD, 20);
        text.setFont(font);
    }

    public void setTitle(JLabel text){
        Font font = new Font("Serif", Font.BOLD, 20);
        text.setFont(font);
    }

    public void setDescription(JLabel text){
        Font font = new Font("Serif", Font.ITALIC, 18);
        text.setFont(font);
    }

    public void setSubtitle(JLabel text){
        Font font = new Font("Serif", Font.PLAIN, 18);
        text.setFont(font);
    }

    public void setSubdescription(JLabel text){
        Font font = new Font("Serif", Font.ITALIC, 16);
        text.setFont(font);
    }

}
