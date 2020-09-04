public class RolodexChange {
    
    int number = 5;

    public RolodexChange() {}

    public int changeNumber() {
        return number + 5;
    }

    public static void main(String... args) {
        RolodexChange classe = new RolodexChange();
        System.out.println(classe.changeNumber());
    }
}

class Initialize {

    float floatArray[]; // Initialize later
    int[] integerArray = new int[10];
    String[] array = new String[] {"a", "b"};

    public static void main(String... args) {
        Initialize hopIn = new Initialize();
        System.out.println(hopIn.integerArray);
    }
}

