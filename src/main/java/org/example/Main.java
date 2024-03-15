package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LibrarySystem {
    static Map<String, Map<String, String>> students = new HashMap<>();
    static String adminUsername = "Admin";
    static String adminPassword = "Admin13579";

    public static void displayLibrarySystem() {
        System.out.println("===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
    }

    public static void displayAdminMenu() {
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Students");
        System.out.println("3. Logout");
        System.out.print("Choose option (1-3): ");
    }

    public static void addStudent(String name, String nim, String faculty, String program) {
        students.put(nim, new HashMap<>());
        students.get(nim).put("name", name);
        students.get(nim).put("faculty", faculty);
        students.get(nim).put("program", program);
        System.out.println("Student successfully registered.");
    }

    public static void displayRegisteredStudents() {
        System.out.println("List of Registered Students:");
        for (Map.Entry<String, Map<String, String>> student : students.entrySet()) {
            System.out.println("Name: " + student.getValue().get("name"));
            System.out.println("Faculty: " + student.getValue().get("faculty"));
            System.out.println("NIM: " + student.getKey());
            System.out.println("Program: " + student.getValue().get("program"));
            System.out.println();
        }
    }

    public static void displayStudentMenu() {
        System.out.println("===== Student Menu =====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Pinjam Buku atau Logout");
        System.out.print("Choose option (1-3): ");
    }

    public static void displayBooks() {
        System.out.println("|| No. || Id buku || Nama Buku || Author || Category || Stock ||");
        System.out.println("|| 1 || 388c - e681-9152 || title || author || Sejarah || 4 ||");
        System.out.println("|| 2 || ed90 - be30-5cdb || title || author || Sejarah || 3 ||");
        System.out.println("|| 3 || d95e - 0c4a - 9523 || title || author || Sejarah || 0 ||");
        System.out.println("|| 99 || Input Id buku yang ingin dipinjam ( input 99 untuk back ) ||");
    }

    public static void borrowBook(String bookId) {
        System.out.println("Buku dengan Id buku " + bookId + " berhasil dipinjam.");
    }

    public static void backToMenu() {
        System.out.println("Kembali ke menu awal...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayLibrarySystem();
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter your NIM (input 99 untuk back): ");
                String nim = scanner.next();

                if (nim.equals("99")) {
                    backToMenu();continue;
                }

                if (!students.containsKey(nim)) {
                    System.out.println("NIM not found.");
                    continue;
                }

                while (true) {
                    displayStudentMenu();
                    option = scanner.nextInt();

                    if (option == 1) {
                        System.out.println("Buku terpinjam:");
                    } else if (option == 2) {
                        displayBooks();
                        System.out.print("Input Id buku yang ingin dipinjam (input 99 untuk back): ");
                        String bookId = scanner.next();

                        if (bookId.equals("99")) {
                            backToMenu();
                            break;
                        }

                        borrowBook(bookId);
                    } else if (option == 3) {
                        break;
                    }
                }
            } else if (option == 2) {
                System.out.print("Enter your username (Admin): ");
                String username = scanner.next();
                System.out.print("Enter your password (Admin13579): ");
                String password = scanner.next();

                if (!username.equals(adminUsername) || !password.equals(adminPassword)) {
                    System.out.println("Invalid credentials for admin.");
                    continue;
                }

                while (true) {
                    displayAdminMenu();
                    option = scanner.nextInt();

                    if (option == 1) {
                        System.out.print("Enter student name: ");
                        String name = scanner.next();
                        System.out.print("Enter student NIM: ");
                        String nim = scanner.next();
                        System.out.print("Enter student faculty: ");
                        String faculty = scanner.next();
                        System.out.print("Enter student program: ");
                        String program = scanner.next();

                        if (students.containsKey(nim)) {
                            System.out.println("Studentalready registered.");
                            continue;
                        }

                        addStudent(name, nim, faculty, program);
                    } else if (option == 2) {
                        displayRegisteredStudents();
                    } else if (option == 3) {
                        break;
                    }
                }
            } else if (option == 3) {
                break;
            }
        }

        scanner.close();
    }
}