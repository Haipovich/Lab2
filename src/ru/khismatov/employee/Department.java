/*
* Задание 3
* Сотрудники и отделы.
* Создайте сущность Сотрудник, которая описывается именем (в строковой форме) и отделом,
* в котором сотрудник работает, причем у каждого отдела есть название и начальник,
* который также является Сотрудником. Сотрудник может быть приведен к текстовой форме вида:
* “Имя работает в отделе Название, начальник которого Имя”. В случае если сотрудник является
* руководителем отдела, то текстовая форма должна быть “Имя начальник отдела Название”.
* Необходимо выполнить следующие задачи:
* 1. Создать Сотрудников Петрова, Козлова, Сидорова работающих в отделе IT.
* 2. Сделать Козлова начальником IT отдела.
* 3. Вывести на экран текстовое представление всех трех Сотрудников (у всех троих должен оказаться один и тот же отдел и начальник).
*
* Задание 4
* Сотрудники и отделы.
* Измените решение, полученное в задаче 3 таким образом, чтобы имея ссылку на сотрудника,
* можно было бы узнать список всех сотрудников этого отдела.
*/

package ru.khismatov.employee;\

import java.util.ArrayList;

public class Department {
    private String name;
    private Employee head;
    private ArrayList<Employee> employees;

    public Department(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Department name cannot be null or empty");
        }
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public String getEmployeeNames() { 
        StringBuilder sb = new StringBuilder();
        for (Employee em : employees) {
            sb.append(em.getName()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
} 
