package sandbox.memory.stackvsheap;

class Class1 {
    String id;
    int value;

    @Override
    public String toString() {
        return "Class1{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {

//        testObject();
//        testPrimitive();
        testPrimitiveObject();
    }

    private static void testPrimitiveObject(){
        System.out.println("----- default -----");
        int stack = 1;
        int[] heap = new int[] {stack};
        System.out.printf("stack   : %d%n", stack);
        System.out.printf("heap    : %d%n", heap[0]);

        System.out.println("----- updated heap -----");
        updateHeap(heap);
        System.out.printf("stack   : %d%n", stack);
        System.out.printf("heap    : %d%n", heap[0]);
    }
    private static void updateHeap(int[] heap) {
        heap[0] = 99;
        System.out.printf("@method : %d%n", heap[0]);
    }

    private static void testPrimitive() {
        System.out.println("----- default -----");
        int orgInt = 1;
        int copyInt = orgInt;
        System.out.printf("origin   : %d%n", orgInt);
        System.out.printf("copy     : %d%n", copyInt);

        System.out.println("----- updated newer stack -----");
        copyInt = 99;
        System.out.printf("origin   : %d%n", orgInt);
        System.out.printf("copy     : %d%n", copyInt);

        System.out.println("----- updated passing by parameter -----");
        updateStack(orgInt);
        System.out.printf("origin   : %d%n", orgInt);
    }

    private static void updateStack(int i) {
        i = 99;
        System.out.printf("@method   : %s%n", i);
    }

    private static void testObject() {
        Class1 orgObj = new Class1();
        System.out.println("----- default -----");
        orgObj.id = "ID1";
        orgObj.value = 1;
        Class1 copyObj = orgObj;
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);

        System.out.println("----- updated newer stack -----");
        copyObj.id = "ID2";
        copyObj.value = 2;
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);

        System.out.println("----- null out newer object -----");
        copyObj = null;
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);

//        // reset
//        orgObj.id = "ID1";
//        orgObj.value = 1;

        System.out.println("----- updated as new stack passing by parameter -----");
        updateObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);

        System.out.println("----- null out as new stack passing by parameter -----");
        nullOutObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);

        // reset
        orgObj.id = "ID1";
        orgObj.value = 1;

        System.out.println("----- pass stack but create a new stack and updated it -----");
        updateNewObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);
    }

    private static void updateObj(Class1 obj) {
        obj.id = "Updated at Method";
        obj.value = 3;
        System.out.printf("@method   : %s%n", obj);
    }

    private static void nullOutObj(Class1 obj) {
        obj = null;
        System.out.printf("@method   : %s%n", obj);
    }

    private static void updateNewObj(Class1 obj) {
        obj = new Class1();
        obj.id = "Updated at Method";
        obj.value = 3;
        System.out.printf("@method   : %s%n", obj);
    }

}
