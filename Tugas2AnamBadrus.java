import java.util.Scanner;

public class Tugas2AnamBadrus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Meminta input golongan karyawan
            System.out.print("Masukkan golongan karyawan (A/B/C): ");
            String golongan = scanner.nextLine().toUpperCase();

            // Validasi golongan karyawan
            if (!golongan.equals("A") && !golongan.equals("B") && !golongan.equals("C")) {
                System.out.println("Golongan karyawan tidak valid. Silakan masukkan golongan yang benar.");
                continue; // Ulangi loop untuk meminta input kembali
            }

            // Meminta input jumlah jam lembur
            System.out.print("Masukkan jumlah jam lembur: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Jumlah jam lembur harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Membersihkan buffer
                continue; // Ulangi loop untuk meminta input kembali
            }
            int jamLembur = scanner.nextInt();

            // Validasi jumlah jam lembur
            if (jamLembur < 0) {
                System.out.println("Jumlah jam lembur tidak boleh negatif. Silakan masukkan jumlah yang benar.");
                continue; // Ulangi loop untuk meminta input kembali
            }

            // Inisialisasi gaji pokok berdasarkan golongan
            int gajiPokok;
            switch (golongan) {
                case "A":
                    gajiPokok = 5000000;
                    break;
                case "B":
                    gajiPokok = 6500000;
                    break;
                case "C":
                    gajiPokok = 9500000;
                    break;
                default:
                    // Tidak akan terjadi karena validasi golongan sebelumnya
                    gajiPokok = 0;
            }

            // Menghitung gaji lembur berdasarkan jumlah jam lembur
            double persentaseLembur;
            if (jamLembur == 1) {
                persentaseLembur = 0.30;
            } else if (jamLembur == 2) {
                persentaseLembur = 0.32;
            } else if (jamLembur == 3) {
                persentaseLembur = 0.34;
            } else if (jamLembur == 4) {
                persentaseLembur = 0.36;
            } else if (jamLembur >= 5) {
                persentaseLembur = 0.38;
            } else {
                // Tidak akan terjadi karena validasi jumlah jam lembur sebelumnya
                persentaseLembur = 0;
            }

            // Hitung gaji lembur
            double gajiLembur = persentaseLembur * gajiPokok;

            // Hitung total penghasilan
            double totalPenghasilan = gajiPokok + gajiLembur;

            // Output hasil
            System.out.println("Gaji Golongan: Rp " + gajiPokok);
            System.out.println("Gaji Lembur: Rp " + gajiLembur);
            System.out.println("Jumlah Penghasilan: Rp " + totalPenghasilan);

            // Membersihkan buffer setelah nextInt()
            scanner.nextLine();

            // Tanya apakah ingin mengulang perhitungan
            System.out.print("Ingin menghitung lagi? (y/n): ");
            String ulang = scanner.nextLine();
            if (!ulang.equalsIgnoreCase("y")) {
                break; // Keluar dari loop jika tidak ingin mengulang
            }
        }

        scanner.close();
    }
}
