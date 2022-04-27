package Tugas2;

public class Queue {
    int max, front, rear, size;
    Mahasiswa[] antrian;

    Queue(int n) {
        max = n;
        Create();
    }

    public void Create() {
        antrian = new Mahasiswa[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void Enqueue(Mahasiswa antri) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            antrian[rear] = antri;
            size++;
        }
    }

    public Mahasiswa Dequeue() {
        Mahasiswa m = new Mahasiswa(" ", " ", 0, 0);
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            m = antrian[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return m;
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println("Antrian");
                System.out.println("NIM     : " + antrian[i].nim);
                System.out.println("Nama    : " + antrian[i].nama);
                System.out.println("Absen   : " + antrian[i].absen);
                System.out.println("IPK     : " + antrian[i].ipk);
                System.out.println("------------------------------");
                i = (i + 1) % max;
                System.out.println("");
            }
            System.out.println("Antrian");
            System.out.println("NIM   : " + antrian[i].nim);
            System.out.println("Nama  : " + antrian[i].nama);
            System.out.println("Absen : " + antrian[i].absen);
            System.out.println("IPK   : " + antrian[i].ipk);
            System.out.println("------------------------------");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Antrian Terdepan");
            System.out.println("NIM   : " + antrian[front].nim);
            System.out.println("Nama  : " + antrian[front].nama);
            System.out.println("Absen : " + antrian[front].absen);
            System.out.println("IPK   : " + antrian[front].ipk);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekRear() {
        if (!IsEmpty()) {
            System.out.println("Antrian Paling Akhir");
            System.out.println("NIM   : " + antrian[rear].nim);
            System.out.println("Nama  : " + antrian[rear].nama);
            System.out.println("Absen : " + antrian[rear].absen);
            System.out.println("IPK   : " + antrian[rear].ipk);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekPosition(String nim) {
        boolean position = false;
        for (int i = front; i <= rear; i++) {
            if (nim.equals(antrian[i].nim)) {
                System.out.println("Mahasiswa Berada Pada Antrian Ke-" + (i + 1));
                position = true;
            }
        }
        if (!position) {
            System.out.println("NIM Tidak Ditemukan");
        }
    }

    public void printMahasiswa(int posisi) {
        posisi = posisi - 1;
        if (posisi >= front && posisi <= rear) {
            System.out.println("Berdasarkan Posisi Antrian : " + (posisi + 1));
            System.out.println("NIM   : " + antrian[rear].nim);
            System.out.println("Nama  : " + antrian[rear].nama);
            System.out.println("Absen : " + antrian[rear].absen);
            System.out.println("IPK   : " + antrian[rear].ipk);
        } else {
            System.out.println("No Antrian Tidak Ditemukan!");
        }
    }
}