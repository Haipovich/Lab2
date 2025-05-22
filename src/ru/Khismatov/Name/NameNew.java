package ru.Khismatov.Name; // Объявление пакета

/* Продолжение задания №<номер задачи или название> */
import java.util.StringJoiner;

// Renamed class to NameNew
public class NameNew {
    private String lastName;
    private String firstName;
    private String middleName;

    // Parameter order maintained from original Name_new: firstName, lastName, middleName
    public NameNew(String firstName, String lastName, String middleName) {
        if ((lastName == null || lastName.isEmpty()) && (firstName == null || firstName.isEmpty())) {
            // throw new IllegalArgumentException("Name or surname must not be null");
            System.out.println("Error: Both first name and last name cannot be null or empty. At least one must be provided.");
            // Assign default values or handle invalid state
            this.firstName = "Unknown"; // Prioritizing firstName as per constructor param order
            this.lastName = "";
            this.middleName = "";
            return;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public NameNew(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    // Constructor for only first name. lastName will be null.
    public NameNew(String firstName) {
        this(firstName, null, null);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        // Order in toString: lastName, firstName, middleName (common convention)
        // If a different order is desired, this can be changed.
        if (lastName != null && !lastName.isEmpty()) {
            joiner.add(lastName);
        }
        if (firstName != null && !firstName.isEmpty()) {
            joiner.add(firstName);
        }
        if (middleName != null && !middleName.isEmpty()) {
            joiner.add(middleName);
        }
        return joiner.toString();
    }
}
