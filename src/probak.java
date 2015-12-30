import domeinuLogika.Erabiltzailea;

import java.util.List;

public class probak {
    public static void main(String[] args){
        Erabiltzailea c = new Erabiltzailea();
        List a = null;
        try {
            a = hibernateDatuBasea.datuBasea.instantzia().loginEgin("999","123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(a);
    }
}
