import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd;

        do {
            //displays list
            displayList();
            //displays menu options then gets choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            //executes choice
            switch (cmd){
                case "A":
                    addItem(SafeInput.getNonZeroLenString(in,"Enter the item you wish to add"));
                    break;
                case "D":
                    deleteItem(SafeInput.getRangedInt(in,"Enter the number of the item you wish to delete", 1, list.size()));
                    break;
                case "P":
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in,"Are you sure you would like to quit?")){
                        System.exit(0);
                    }
                    break;
            }
        }while(!done);
    }

    private static void displayList(){

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0){
            for (int i = 0; i < list.size(); i++){
                System.out.printf("%3d%35s%n", i + 1, list.get(i));
                //System.out.printf("%3s%n", list.get(i));
            }
        }
        else {
            System.out.println("+++            List is empty             +++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void addItem(String item){
        list.add(item);
    }
    private static void deleteItem(int item){
        String obj = list.get(item-1);
        list.remove(item-1);
        System.out.println(obj + " successfully removed!");
    }
}