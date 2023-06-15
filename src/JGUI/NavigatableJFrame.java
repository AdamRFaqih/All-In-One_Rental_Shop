/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JGUI;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author rahma
 */
public class NavigatableJFrame extends JFrame {
    protected NavigatableJFrame prevFrame;
    public void setPrevFrame(NavigatableJFrame prevFrame){
        this.prevFrame = prevFrame;
    }
}
