package sandbox.memory.stackvsheap;

class Class1 {
    private String id;
    private int value;

    public Class1(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDefault() {
        setId("ID1");
        setValue(1);
    }

    @Override
    public String toString() {
        return "Class1{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
