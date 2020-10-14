package lab1;

public class Driver {
    public static void main(String[] args) {
//        System.out.println("===== valid cases =====");
//        validCases();
//        System.out.println();

//        System.out.println("===== edge cases validation =====");
//        edgeCasesValidation();
//        System.out.println();

//        System.out.println("===== edge cases salary =====");
//        edgeCasesSalary();
//        System.out.println();

//        System.out.println("===== invalid cases =====");
//        invalidCases();
//        System.out.println();

        System.out.println("===== getter/setter cases =====");
        getSetCases();
        System.out.println();
    }

    private static void getSetCases() {
        try {
            Model m = new Model();
            m.setFirstName("Fname");
            System.out.println(m.getFirstName());
            m.setLastName("Lname");
            System.out.println(m.getLastName());
            m.setHeight(24);
            System.out.println(m.getHeight());
            m.setHeight(2, 2);
            System.out.println(m.getHeight());
            m.setWeight(120d);
            System.out.println(m.getWeight());
            System.out.println(m.getWeightKg(120d));
            m.setWeight(55);
            System.out.println(m.getWeight());
            m.setCanTravel(true);
            System.out.println(m.isCanTravel());
            m.setSmokes(false);
            System.out.println(m.isSmokes());

        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void validCases() {
        try {
            Model m;

            Object[][] cases = new Object[][] {
                    {"Susan", "Smith", 70, 120d, false, true},
                    {"Susan", "Smith", 70, 120d, true, false},
                    {"Susan", "Smith", 70, 120d, true, true},
                    {"Tiger", "Woods", 72, 109d, true, false},
            };
            for (int i = 0; i < cases.length; i++) {
                m = new Model(cases[i][0].toString(), cases[i][1].toString(), (int) cases[i][2], (double) cases[i][3], (boolean) cases[i][4], (boolean) cases[i][5]);
                System.out.println(String.format("---------- case %d ----------", i+1));
                System.out.println("----- print -----");
                m.printDetails();
                System.out.println("----- display -----");
                m.displayModelDetails();
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void edgeCasesValidation() {
        try {
            Model m;

            Object[][] cases = new Object[][] {
                    {"123", "FistName_min_3", 24, 120d, true, true},
                    {"123456789A123456789B", "FirstName_max_20", 24, 120d, true, true},
                    {"LastName_min_3", "123", 24, 120d, true, true},
                    {"LastName_max_20", "123456789A123456789B", 24, 120d, true, true},
                    {"Height", "min_24", 24, 120d, true, true},
                    {"Height", "max_84", 84, 120d, true, true},
                    {"Weight", "min_80", 70, 80d, true, true},
                    {"Weight", "max_280", 70, 280d, true, true},
            };
            for (int i = 0; i < cases.length; i++) {
                m = new Model(cases[i][0].toString(), cases[i][1].toString(), (int) cases[i][2], (double) cases[i][3], (boolean) cases[i][4], (boolean) cases[i][5]);
                System.out.println(String.format("---------- case %d ----------", i+1));
                System.out.println("----- print -----");
                m.printDetails();
                System.out.println("----- display -----");
                m.displayModelDetails();
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void edgeCasesSalary() {
        try {
            Model m;

            Object[][] cases = new Object[][] {
                    {"Tall", "below", 66, 120d, false, false},
                    {"Tall", "above", 67, 120d, false, false},
                    {"Thin", "below", 67, 139d, false, false},
                    {"Thin", "above", 67, 140d, false, false},
                    {"Travel", "can", 67, 140d, true, false},
                    {"Travel", "cannot", 67, 140d, false, false},
                    {"Smoke", "does", 67, 140d, false, true},
                    {"Smoke", "does not", 67, 140d, false, false},
            };
            for (int i = 0; i < cases.length; i++) {
                m = new Model(cases[i][0].toString(), cases[i][1].toString(), (int) cases[i][2], (double) cases[i][3], (boolean) cases[i][4], (boolean) cases[i][5]);
                System.out.println(String.format("---------- case %d ----------", i+1));
                System.out.println("----- print -----");
                m.printDetails();
                System.out.println("----- display -----");
                m.displayModelDetails();
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void invalidCases() {
        Object[][] cases = new Object[][] {
                {"12", "FistName_min_2", 24, 120d, true, true},
                {"123456789A123456789Ba", "FirstName_max_21", 24, 120d, true, true},
                {"LastName_min_2", "12", 24, 120d, true, true},
                {"LastName_max_21", "123456789A123456789Ba", 24, 120d, true, true},
                {"Height", "min_23", 23, 120d, true, true},
                {"Height", "max_85", 85, 120d, true, true},
                {"Weight", "min_79", 70, 79d, true, true},
                {"Weight", "max_281", 70, 281d, true, true},
        };
        for (int i = 0; i < cases.length; i++) {
            testInvalidCases(cases[i], i);
        }
    }

    private static void testInvalidCases(Object[] aCase, int caseIndex) {
        try {
            Model m;
            m = new Model(aCase[0].toString(), aCase[1].toString(), (int) aCase[2], (double) aCase[3], (boolean) aCase[4], (boolean) aCase[5]);
            System.out.println(String.format("---------- case %d ----------", caseIndex+1));
            System.out.println("----- print -----");
            m.printDetails();
            System.out.println("----- display -----");
            m.displayModelDetails();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
