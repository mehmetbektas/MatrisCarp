/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriscarp;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Innocent
 */
public class MatrisiDosyayaYaz{

    Integer[][] matris;
    String yol;
    
    
    public MatrisiDosyayaYaz(Integer[][] matris, String yol) {
        this.matris = matris;
        this.yol = yol;
    }

    
    public void yaz() {
        File dosya = new File(yol);
        try {
            FileWriter yazici = new FileWriter(dosya, false);
            try (BufferedWriter yaz = new BufferedWriter(yazici)) {
                if (matris != null) {
                    for (int i = 0; i < matris.length; i++) {
                        for (int j = 0; j < matris.length; j++) {
                            yaz.write(String.valueOf(matris[i][j]));
                            if (j != matris.length - 1) {
                                yaz.write("\t");
                            }
                        }
                        if (i != matris.length - 1) {
                            yaz.newLine();
                        }
                    }
                }
                
                
            }
            System.out.println(yol.substring(10, 17) + " oluşturuldu."); //silinecek

        } catch (IOException ex) {
            Logger.getLogger(MatrisiDosyayaYaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
