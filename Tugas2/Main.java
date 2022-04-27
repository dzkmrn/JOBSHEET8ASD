package Tugas2;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("Pilihan Menu");
        System.out.println("1. Input Data Baru (Enqueue)");
        System.out.println("2. Mengeluarkan Data (Dequeue)");
        System.out.println("3. Tampilkan Data Keseluruhan (Print)");
        System.out.println("4. Tampilkan Data Terdepan (Peek)");
        System.out.println("5. Tampilkan Data Terbelakang (PeekRear)");
        System.out.println("6. Search by NIM (PeekPosition)");
        System.out.println("7. Search by Position (PrintMahasiswa)");
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();

        Queue antr = new Queue(jumlah);
        int pilih;
        do {
            menu();
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Absen : ");
                    int absen = sc.nextInt();
                    System.out.print("IPK   : ");
                    double ipk = sc.nextDouble();

                    Mahasiswa m = new Mahasiswa(nim, nama, absen, ipk);
                    sc.nextLine();
                    antr.Enqueue(m);
                    break;
                case 2:
                    Mahasiswa mhs = antr.Dequeue();
                    if (!"".equals(mhs.nim) && !"".equals(mhs.nama) && mhs.absen != 0
                            && mhs.ipk != 0) {
                        System.out.println("Antrian yang keluar: " + mhs.nim + " " + mhs.nama + " " + mhs.absen +
                                " " + mhs.ipk);
                        break;
                    }
                case 3:
                    antr.print();
                    break;
                case 4:
                    antr.peek();
                    break;
                case 5:
                    antr.peekRear();
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNIM = str.nextLine();
                    antr.peekPosition(cariNIM);
                    break;
                case 7:
                    System.out.print("Masukkan antrian yang dicari: ");
                    int cariAntri = sc.nextInt();
                    antr.printMahasiswa(cariAntri);
                    break;
                default:
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7);
        sc.close();
        str.close();
    }
}