package sandbox.memory.stackvsheap;

public class PrimitiveVsNonPrimitive {
    public static void main(String[] args) {
//        testPrimitiveVsNonPrimitive();
        testString();
    }

    private static void testPrimitiveVsNonPrimitive() {
        System.out.println("----- default -----");
        System.out.println("< 1. primitive = stored at stack >");
        System.out.println("< 2. non-primitive including arrays = stored at heap >");
        System.out.println("< 3. set primitive value to array = stored at heap >");
        int stack = 1;
        int[] heap = new int[]{stack};
        System.out.printf("stack   : %d%n", stack);
        System.out.printf("heap    : %d%n", heap[0]);
        System.out.println();

        System.out.println("----- updated heap -----");
        System.out.println("< update arrays which set value of primitive valuable = update heap, so the original primitive valuable does not change >");
        updateHeap(heap);
        System.out.printf("stack   : %d%n", stack);
        System.out.printf("heap    : %d%n", heap[0]);
    }

    private static void updateHeap(int[] heap) {
        heap[0] = 99;
        System.out.printf("@method : %d%n", heap[0]);
    }

    private static void testString() {
        // '==' operator: compare memory locations
        //      -> should be used for primitive types which store data to memory directory (Stack)
        // 'equals()' method: compare the content stored in two objects
        //      -> should be used for non-primitive types which store data at Heap

        System.out.println("----- String Literal -----");
        // created at the time of compilation:
        //      allocated in HEAP or SCP (String Constant Pool, read-only memory)
        //  - the mechanism called 'Interning' = storing
        //  - 1. allocate in Heap and SCP if no matches of the same sequence of characters
        //  - 2. if found, compiler refers to SCP instead of creating a new object
        String name1 = "Yurie";
        System.out.println(name1 == "Yurie");   // return true

        System.out.println("----- String Object -----");
        // created at the runtime: always allocated in 'HEAP'
        String name2 = new String("Tomato");
        System.out.println(name2 == "Tomato");   // return false
    }
}
