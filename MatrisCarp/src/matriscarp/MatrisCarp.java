/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriscarp;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Innocent
 */
public class MatrisCarp {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        
        
        
        
        MatrisCarp mc = new MatrisCarp();  //nesnemizi oluşturuyoruz
        final int boyut = Integer.parseInt(mc.getBoyut()); //matrisin boyutunu kullanıcıdan alıyoruz
        
        Integer[][] matris1 = mc.matrisOlustur(boyut); //matris1 i oluşturuyoruz
        Integer[][] matris2 = mc.matrisOlustur(boyut); ////matris2 i oluşturuyoruz
        
        new MatrisiDosyayaYaz(matris1,"matrisler/matris1.txt").yaz(); //matris1 i dosyaya yazdırıyoruz
        new MatrisiDosyayaYaz(matris2,"matrisler/matris2.txt").yaz(); //matris2 i dosyaya yazdırıyoruz
        mc.onayAl();
        long time1=System.nanoTime();
        Durum d = new Durum(boyut);
        Integer[][] carpimMatrisi = new Integer[boyut][boyut];
        for (int i = 0; i < boyut; i++) {
            carpimMatrisi[i]=mc.satiriCarp(matris1[i], matris2);
            d.guncelle(i+1);
        }
        d.dispose();
        new MatrisiDosyayaYaz(carpimMatrisi,"matrisler/carpim matrisi.txt").yaz(); //matris2 i dosyaya yazdırıyoruz
        long time2=System.nanoTime();
        System.out.println((time2-time1));
        mc.islemTamamlandi(time2-time1);
        
    }
    private String getBoyut() {
        return JOptionPane.showInputDialog(null,"Matris boyutunun giriniz:","Matris Boyutu",JOptionPane.PLAIN_MESSAGE);
    }
    
    private void onayAl() {
        JOptionPane.showMessageDialog(null, "Matrisler oluşturuldu. \nÇarpma işlemini başlatmak için tıklayın.", "Devam etmek için tıklayın.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void islemTamamlandi(long sure) {
        JOptionPane.showMessageDialog(null, "Matris carpma işlemi tamamlandı. \nSüre: " + sure + " nanosaniye \n" + sure / 1000000000 + " saniye", "İşlem Tamamlandı", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private Integer[] satiriCarp(Integer[] satir, Integer[][] matris2){
        int boyut = satir.length;
        Integer[] donenSatir = new Integer[boyut];
        
        for (int i = 0; i < boyut; i++) {
            Integer[] matris2Sutun = sutunAl(matris2, i);
            int toplam = 0;
            for (int j = 0; j < boyut; j++) {
                toplam += satir[j]*matris2Sutun[j];
            }
            donenSatir[i] = toplam;
        }
        return donenSatir;
    }
    
    private Integer[][] matrisOlustur(int boyut){
        Integer matris[][] = new Integer[boyut][boyut];
        Random r = new Random();
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                matris[i][j] = r.nextInt(10);
            }
        }
        
        return matris;
    }

    private Integer[] sutunAl(Integer[][] dizi, int sutunNo ) {
        Integer[] liste = new Integer[dizi.length];
        for (int i = 0; i < dizi.length; i++) {
            liste[i]=dizi[i][sutunNo];
        }
        return liste;
        
    }
}
