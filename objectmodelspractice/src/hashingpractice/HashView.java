/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingpractice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author cst
 */
public class HashView {
    //declare JFrame
    private static JFrame frame;
    
    

    
    public static int s = 0;
    public static int c = 0;
    public static int m = 0;
    public static JLabel snumlabel = new JLabel();
    public static JLabel cnumlabel = new JLabel();
    public static JLabel mnumlabel = new JLabel();
    
    public static void main(String[] args) {
        
   
      
        
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s =s+1;
                snumlabel.setText(String.valueOf(s));
                frame.setVisible(true);
                
                
            }
        };
        
        ActionListener Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s =s-1;
                snumlabel.setText(String.valueOf(s));
                frame.setVisible(true);
                
            }
        };
        
        
                        
        
        //add new frame
        //add a new frame
        frame = new JFrame("Hashing");
        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        //set a new panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(820, 400));
        panel.setBackground(Color.lightGray);
        frame.add(panel);
        
        //inside panel
        JPanel screenpanel = new JPanel();
        screenpanel.setPreferredSize(new Dimension(450, 400));
        screenpanel.setBackground(Color.LIGHT_GRAY);
        panel.add(screenpanel);
        
        screenpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        //in screenpanel
        JPanel hashingpanel = new JPanel();
        hashingpanel.setPreferredSize(new Dimension(450, 60));
        hashingpanel.setBackground(Color.GREEN);
        screenpanel.add(hashingpanel);
            //in hashingpanel
        JLabel hashlabel = new JLabel("************************************Hashing*******************************************");
        hashlabel.setPreferredSize(new Dimension(450, 25));
        hashingpanel.add(hashlabel);
        
        //text panel
        JPanel displaypanel = new JPanel();
        displaypanel.setPreferredSize(new Dimension(450, 400));
        displaypanel.setBackground(Color.WHITE);
        screenpanel.add(displaypanel);
        
        
    
        
        //inside panel
        JPanel operatepanel = new JPanel();
        operatepanel.setPreferredSize(new Dimension(360, 400));
        operatepanel.setBackground(Color.BLUE);
        panel.add(operatepanel);
        
        //operat panel layout

        
        //codepanel
        JPanel codepanel = new JPanel();
        
        codepanel.setPreferredSize(new Dimension(350, 400));
        codepanel.setBackground(Color.cyan);
        operatepanel.add(codepanel);
            //label
        JLabel hashinglabel = new JLabel("*******************************TextInput***************************");
        hashinglabel.setPreferredSize(new Dimension(350, 50));
        hashinglabel.setBackground(Color.red);
        codepanel.add(hashinglabel);
        
           
        JPanel spanel = new JPanel();
        spanel.setPreferredSize(new Dimension(350, 250));
        spanel.setBackground(Color.WHITE);
        codepanel.add(spanel);
        
        JTextArea textinputarea =new JTextArea("Input your text file");
        textinputarea.setBounds(0, 0, 320, 220);
        textinputarea.setBackground(Color.LIGHT_GRAY);
        spanel.add(textinputarea);
        
        //add number label
        snumlabel.setPreferredSize(new Dimension(350, 50));
        spanel.add(snumlabel);
        
        
            //butoon panel
        JPanel sbpanel = new JPanel();
        sbpanel.setPreferredSize(new Dimension(350, 150));
        sbpanel.setBackground(Color.cyan);
        codepanel.add(sbpanel);
        
        //button
        JButton sugaradd = new JButton("Encrypt");
        sugaradd.setBounds(60, 0, 5, 5);
        sugaradd.setBackground(Color.LIGHT_GRAY);
        sbpanel.add(sugaradd);
        sugaradd.addActionListener(addListener);
        
      
        
        frame.setSize(1200, 1200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    }//close main
    
    
}
