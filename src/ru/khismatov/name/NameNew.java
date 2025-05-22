package ru.khismatov.name;

/* Создаем Имена. 
Измените сущность Имя из задачи 1.3. Новые требования включают: 
• Имя можно создать указав только Личное имя 
• Имя можно создать указав Личное имя и Фамилию. 
• Имя можно создать указав все три параметра: Личное имя, Фамилию, Отчество. Необходимо создать следующие имена: 
1. Клеопатра 
2. Александр Сергеевич Пушкин 
3. Владимир Маяковский 
4. Христофор Бонифатьевич (здесь Христофор это имя, а Бонифатьевич - фамилия)*/
import java.util.StringJoiner;

public class NameNew {
    private String lastName;
    private String firstName;
    private String middleName;

    public NameNew(String firstName, String lastName, String middleName) {
        if ((lastName == null || lastName.isEmpty()) && (firstName == null || firstName.isEmpty())) {
            System.out.println("Error: Both first name and last name cannot be null or empty. At least one must be provided.");
            this.firstName = "Unknown";
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

    public NameNew(String firstName) {
        this(firstName, null, null);
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
