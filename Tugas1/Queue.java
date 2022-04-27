package Tugas1;

public class Queue {

    int max, size, front, rear;
    int Q[];

    public Queue(int n) {
        max = n;
        Create();
    }

    public void Create() {
        Q = new int[max];
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

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + Q[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong!");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(Q[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(Q[i] + " ");
            System.out.println("Jumlah elemen: " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {

            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil di kosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int data) {
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
            Q[rear] = data;
            size++;
        }
    }

    public int Dequeue() {
        int data = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            data = Q[front];
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
        return data;
    }

    public void peekPosition(int a) {
        if (!IsEmpty()) {
            int i;
            boolean isi = false;
            for (i = front; i <= rear; i++) {
                if (a == Q[i]) {
                    System.out.println("Data " + a + " berada di indeks ke - " + i);
                    isi = true;
                }
            }
            if (!isi) {
                System.out.println("Data tidak ditemukan");
            }
        }
    }

    public void peekAt(int a) {
        if (!IsEmpty()) {
            if (a >= front && a <= rear) {
                System.out.println("Data pada indeks ke " + a + " adalah " + Q[a]);
            } else {
                System.out.println("Data pada indeks tersebut tidak ditemukan");
            }
        }
    }
}