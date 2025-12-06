public class ForEach {

    public static void main(String[] args) {
        String[] students = {"Artem", "Nicolas", "Jamie", "Helen"};
//        for (int i = 0; i < students.length; i++) {
//            System.out.println(students[i]);
//        }
        for (String name : students) {
            System.out.println(name);
        }


    }
}
