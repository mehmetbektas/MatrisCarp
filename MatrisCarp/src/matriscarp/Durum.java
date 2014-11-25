/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriscarp;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author Innocent
 */
public class Durum extends JFrame{

    JProgressBar gosterge;
    
    public Durum(int boyut) {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 75);
        gosterge = new JProgressBar(0,boyut);
        gosterge.setStringPainted(true);
        getContentPane().add(gosterge);
        setVisible(true);
    }
    
    public void guncelle(int doluluk){
        gosterge.setValue(doluluk);
    }
    
    
    
}
