// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Asus", "158-78", 16, 1000, "Windows 7", "черный");
        Notebook nb2 = new Notebook("Lenovo", "0078-14", 4, 256, "Windows 10", "белый");
        Notebook nb3 = new Notebook("Aser", "174-999", 8, 1000, "Windows 11", "серый");
        Notebook nb4 = new Notebook("HP", "555-444", 16, 256, "Windows 11", "черный");
        Notebook nb5 = new Notebook("Asus", "177-1233", 16, 512, "Windows 7", "серебристый");
        
        HashSet<Notebook> notebooks = new HashSet<Notebook>(
                Arrays.asList(nb1, nb2, nb3, nb4, nb5));

        Scanner sc = new Scanner(System.in, "cp866");

        System.out.println();
        System.out.println("Магазин техники DNS \n" +
                "Выберете ноутбук\n");
        boolean filter = true;
        while (filter) {
            System.out.println("Выбор по ОЗУ, введите - 1\n" +
                    "Выбор по объему ЖД, введите - 2\n" +
                    "Выбор по ОС, введите - 3\n" +
                    "Выбор по цвету, введите - 4\n" +
                    "Посмотр всех моделей, введите - 5\n" +
                    "Выход, введите - 0");
       
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, sc);
                    break;
                case "2":
                    FilterHardDisk(notebooks, sc);
                    break;
                case "3":
                    filterOS(notebooks, sc);
                    break;
                case "4":
                    filterColor(notebooks, sc);
                    break;
                case "5":
                    showCatalog(notebooks);
                    break;
                case "0":
                    System.out.println("Не выбрали ноутбук?жаль...");
                    filter = false;
                    break;
                default:
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                    break;
            }
        }

    }

    public static void filterRAM(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Notebook note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("Ноутбук с ОС"
                + ram.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Ошибка. Попробуйте снова");
            filterRAM(notebooks, scanner);
        }

    }
    public static void FilterHardDisk(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("Ноутбуки с объемом ЖД "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");

        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Ошибка. Попробуйте снова");
            FilterHardDisk(notebooks, scanner);
        }
    }
    // Функция поиска по ОС
    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            operSystems.add(note.getOperSystem());
        }
        System.out.println();
        System.out.println("Выбор по ОС: "
                + operSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую ОС: ");

        String oper = scanner.nextLine().toUpperCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOperSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Ошибка. Попробуйте снова");
            filterOS(notebooks, scanner);

        }
    }
    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("Выберете цвет ноутбука: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий цвет: ");
      
        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Ошибка. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }
    
    public static void showCatalog(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Все ноутбуки в магазине: ");
        System.out.println();
        for (Notebook note : notebooks) {
                note.showInfo();
        }
    }
}