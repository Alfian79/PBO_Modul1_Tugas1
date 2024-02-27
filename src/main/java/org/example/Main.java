package org.example;
import java.util.Scanner;
class Library {
   String AdminUsername = "Admin";
   String AdminPassword = "Admin123";
   String Mahasiswa_NIM = "202310370311329";
   String Password_PIC = "1357997531";
    public boolean adminLogin(String username, String password) {
        return username.equals(AdminUsername) && password.equals(AdminPassword);
    }
    public boolean mahasiswaLogin(String nim, String password) {
        return nim.equals(Mahasiswa_NIM) && password.equals(Password_PIC);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===Selamat datang di sistem login library===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("3. Keluar");

            System.out.print("Pilih jenis login (1/2/3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Masukkan UserName: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String adminPassword = scanner.nextLine();

                    if (library.adminLogin(adminUsername, adminPassword)) {
                        System.out.println("Login Admin berhasil!");
                    } else {
                        System.out.println("Login Admin gagal. Periksa kembali UserName dan Password.");
                    }
                    break;
                case "2":
                    System.out.print("Masukkan NIM (15 digit): ");
                    String NIM = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String MahasiswaPassword = scanner.nextLine();

                    if (library.mahasiswaLogin(NIM, MahasiswaPassword)) {
                        System.out.println("Login Mahasiswa berhasil!");
                    } else {
                        System.out.println("Login Mahasiswa gagal. Periksa kembali NIM dan password.");
                    }
                    break;
                case "3":
                    System.out.println("Terima kasih telah menggunakan sistem login library.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }
}
