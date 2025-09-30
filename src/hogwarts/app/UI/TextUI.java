package hogwarts.app.UI;
import hogwarts.data.House;

import java.util.Scanner;
import java.util.ArrayList;

public class TextUI {
    Scanner scan = new Scanner(System.in);
    ArrayList<String>options=new ArrayList<>();

    public TextUI() {
    }

    public String promptText(String msg) {
        System.out.println(msg);        //Stille brugeren et spørgsmål
        String input = scan.nextLine(); //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }
    
   /* public House promtHouse(String msg){
        System.out.println(msg);        //Stille brugeren et spørgsmål
        House input = scan.nextLine(); //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }*/

    public int promptNumeric(String msg) {
        System.out.println(msg);            //Stille brugeren et spørgsmål
        String input = scan.nextLine();     //Give brugere et sted at placere sit svar og vente på svaret
        int age = Integer.parseInt(input); //Konvertere svaret til et tal
        return age;
    }

    public Object promptChoice (){
        return null;
    }
    public void displayList(ArrayList<String> list, String msg){
        for (String option : options) {
            System.out.println(option);
        }
    }

}

