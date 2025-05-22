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

package ru.khismatov.employee;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        if (department == null || name == null || name.isEmpty()) {
            System.out.println("Error: Department and name cannot be null or empty");
            return; 
        }
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (department == null) { 
            return name + " (Error: department not set)";
        }
        if (this == department.getHead()) {
            return name + " начальник отдела " + department.getName();
        } else {
            Employee head = department.getHead();
            String headName = (head != null) ? head.getName() : "unknown"; 
            return name + " работает в отделе " + department.getName() + ", начальник которого " + headName;
        }
    }
}
