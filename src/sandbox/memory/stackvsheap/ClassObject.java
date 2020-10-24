package sandbox.memory.stackvsheap;

public class ClassObject {
    public static void main(String[] args) {
        testObject();
    }

    private static void testObject() {
        System.out.println("----- default -----");
        System.out.println("< 2 stacks are sharing the same heap >");
        Class1 orgObj = new Class1("ID1", 1);
        Class1 copyObj = orgObj;
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);
        System.out.println();

        System.out.println("----- updated newer stack -----");
        System.out.println("< update = store at heap, and 2 stacks are sharing the same heap so same result >");
        copyObj.setId("ID2");
        copyObj.setValue(2);
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);
        System.out.println();

        System.out.println("----- null out newer object -----");
        System.out.println("< 'object = null' = remove stack info (reference address) but heap remains, so orgObj can show value in heap >");
        copyObj = null;
        System.out.printf("origin   : %s%n", orgObj);
        System.out.printf("copy     : %s%n", copyObj);
        System.out.println();

        orgObj.setDefault();    // reset

        System.out.println("----- updated as new stack passing by parameter -----");
        System.out.println("< 1. pass Object as parameter = a new Object is created = different stack but refer to the same heap >");
        System.out.println("< then again, update = store at heap, so orgObj shows the same value >");
        updateObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);
        System.out.println();

        System.out.println("----- null out as new stack passing by parameter -----");
        System.out.println("< 1. pass Object as parameter = a new Object is created = different stack but refer to the same heap >");
        System.out.println("< again, 'object = null' remove stack info, in this case null out the object created in the method, but heap remains >");
        nullOutObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);
        System.out.println();

        orgObj.setDefault();    // reset

        System.out.println("----- pass stack but create a new stack and updated it -----");
        System.out.println("< 1. pass Object as parameter but set 'new Class1' = a new Object is created and refer to the 'different heap' >");
        System.out.println("< so the values set to the new object is stored at different heap, and orgObje shows different values >");
        updateNewObj(orgObj);
        System.out.printf("origin   : %s%n", orgObj);
    }

    private static void updateObj(Class1 obj) {
        obj.setId("Updated at Method");
        obj.setValue(3);
        System.out.printf("@method   : %s%n", obj);
    }

    private static void nullOutObj(Class1 obj) {
        obj = null;
        System.out.printf("@method   : %s%n", obj);
    }

    private static void updateNewObj(Class1 obj) {
        obj = new Class1("Updated at Method", 3);
        System.out.printf("@method   : %s%n", obj);
    }
}
