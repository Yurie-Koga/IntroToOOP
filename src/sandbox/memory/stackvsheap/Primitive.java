package sandbox.memory.stackvsheap;

public class Primitive {
    public static void main(String[] args) {
        testPrimitive();
    }

    private static void testPrimitive() {
        System.out.println("----- default -----");
        System.out.println("< primitive = stored each stack, does not affect each other >");
        System.out.println("< 'int copyInt = orgInt;' = stored value of orgInt at new stack >");
        int orgInt = 1;
        int copyInt = orgInt;
        System.out.printf("origin   : %d%n", orgInt);
        System.out.printf("copy     : %d%n", copyInt);
        System.out.println();

        System.out.println("----- updated newer stack -----");
        System.out.println("< stack of copyInt is different than orgInt, so only copyInt is updated >");
        copyInt = 99;
        System.out.printf("origin   : %d%n", orgInt);
        System.out.printf("copy     : %d%n", copyInt);
        System.out.println();

        System.out.println("----- updated passing by parameter -----");
        System.out.println("< 1. pass primitive as parameter = a new primitive valuable is created = different stack >");
        System.out.println("< so update the new primitive valuable does not change orgInt passed as parameter >");
        updateStack(orgInt);
        System.out.printf("origin   : %d%n", orgInt);
    }

    private static void updateStack(int i) {
        i = 99;
        System.out.printf("@method   : %s%n", i);
    }
}
