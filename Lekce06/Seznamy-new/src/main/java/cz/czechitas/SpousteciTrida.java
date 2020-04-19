package cz.czechitas;

import java.util.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        List<String> seznamJmen = new ArrayList<>();
        seznamJmen.add("Albert Eistein");
        seznamJmen.add("Nikola Tesla");
        seznamJmen.add("Jean-Paul Sartre");


        while (true) {
            System.out.println("Seznam jmen: ");

     /* for (String jmeno: seznamJmen){
      System.out.println(jmeno);  }
      */

            for (int i = 0; i < seznamJmen.size(); i++) {
                String jmeno = seznamJmen.get(i);
                System.out.println(i + " " + jmeno);
            }

        }


    }
}
