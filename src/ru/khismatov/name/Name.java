package ru.khismatov.name;

/* Создайте сущность Имя, которая описывается тремя параметрами: 
Фамилия, Личное имя, Отчество. Имя может быть приведено к строковому виду, 
включающему традиционное представление всех трех параметров: 
Фамилия Имя Отчество (например “Иванов Иван Иванович”). 
Необходимо предусмотреть возможность того, что какой-либо из 
параметров может быть не задан, и в этом случае он не учитывается при приведении к текстовому виду. */

import java.util.StringJoiner;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        if ((lastName == null || lastName.isEmpty()) && (firstName == null || firstName.isEmpty())) {
            System.out.println("Error: Both first name and last name cannot be null or empty. At least one must be provided.");
            this.lastName = "";
            this.firstName = "Unknown";
            this.middleName = "";
            return;
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String firstName) {
        this(null, firstName, null);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
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
