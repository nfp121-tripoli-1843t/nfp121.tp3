package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {

        // d�clarer p1
        // d�clarer p2
        PileI<PolygoneRegulier> p1 = new Pile2<PolygoneRegulier>();
        PileI<Object> p2 = new Pile2<Object>();
        // p1 est ici une pile de polygones r�guliers PolygoneRegulier.java
        
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

    }
}