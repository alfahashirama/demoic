import java.util.ArrayList;
import java.util.List;

public class DemoPipeline {

    public static void main(String args[]) {
        System.out.println("Demo Pipeline");

        // ------------------------
        // Code smell / warning
        // ------------------------
        int unusedVariable; // Warning: variable never used

        // ------------------------
        // Deprecated API usage
        // ------------------------
        @Deprecated
        class OldClass {}
        OldClass oldObj = new OldClass(); // Warning: usage of deprecated API

        // ------------------------
        // Empty catch block
        // ------------------------
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            // empty catch block → code smell
        }

        // ------------------------
        // Security hotspot (hardcoded password)
        // ------------------------
        String password = "123456"; // Security hotspot: hardcoded credential

        // ------------------------
        // Duplication / Redundancy
        // ------------------------
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>(); // similar repeated code → duplication

        // Another redundancy: repeated logic
        for(int i = 0; i < 5; i++) {
            System.out.println("Hello " + i);
        }
        for(int i = 0; i < 5; i++) {
            System.out.println("Hello " + i); // duplication
        }
    }
}
