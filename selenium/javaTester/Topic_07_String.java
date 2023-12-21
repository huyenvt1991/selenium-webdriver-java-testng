package javaTester;

public class Topic_07_String {
    public static void main(String[] args) {
        String firstName = "Minh";
        String lastName = "Hoang";

        String fullName = firstName + " " + lastName;

        System.out.println(fullName);

//        fullName = firstName.concat(" ").concat(lastName);
//        System.out.println(fullName);

        String hotelMsg = "Welcome " + fullName + " to Intercontinental hotel";
        System.out.println(hotelMsg);
    }
}
