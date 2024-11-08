import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String[]> conflicts = new ArrayList<>();
        Scheduling sched = new Scheduling();
        Scanner sc = new Scanner(System.in);
        System.out.print("Classes: ");
        String s = sc.nextLine();
        s = s.replaceAll(" ", "");
        String[] classes = s.split(",");
        System.out.println("Conflicting classes (cannot occur simultaneously):");
        String conflict = "test";
        while (!(conflict.equals(""))){
            conflict = sc.nextLine();
            if (!(conflict.equals(""))) {
                String[] c = conflict.split("-");
                conflicts.add(c);
            }
        }
        sched.colouring(classes, conflicts);
    }
}