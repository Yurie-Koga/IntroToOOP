package sandbox.memory.stackvsheap;

public class PrimitiveVsNonPrimitive {
    public static void main(String[] args) {
        testPrimitiveVsNonPrimitive();
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
}
