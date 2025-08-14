public class DemoPipeline {
    public static void main(String args[]) {
        System.out.println("Demo Pipeline");

        // Example 1: Variable declared but never used → will trigger a warning
        int unusedVariable;

        // Example 2: Deprecated API usage → triggers warning if checked by SonarQube
        @Deprecated
        class OldClass {}
        OldClass oldObj = new OldClass();

        // Example 3: Code smell: empty catch block
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            // empty catch block → SonarQube considers this a code smell
        }
    }
}
