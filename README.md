# Eksplorasi GUI Java Pemesanan Juice Bar

Tugas Pemrograman Berorientasi Objek

- **Nama:** Alya Zulfadila
- **NIM:** F1D02510102

## Struktur Class
1. `Menu.java` : Superclass yang menyimpan atribut dasar `namaMenu` dan `harga`.
2. `PesananJuice.java` : Subclass dari `Menu` yang menyimpan data pemesan, jumlah gelas, dan perhitungan subtotal.
3. `DataJuice.java` : Menyimpan daftar varian menu jus dan harganya.
4. `Operasi.java` : Mengelola daftar pesanan (`ArrayList`) untuk operasi tambah, hapus, dan reset data.
5. `MainFrame.java` : Mengatur tampilan GUI (`JFrame`, `JPanel`, `JLabel`, `JTextField`, `JComboBox`, `JButton`, `JTable`, `JOptionPane`) serta *Event Handling* (`ActionListener` dan `WindowAdapter`).
6. `Main.java` : Class utama untuk menjalankan aplikasi.

## Dokumentasi Tampilan & Fitur

### 1. Tampilan Awal (`JFrame` & `JTable` Kosong)
![Tampilan Awal](screenshot/tampilan-awal.png)

### 2. Pilihan Varian Menu (`JComboBox`)
![Pilihan Menu](screenshot/komponen-jcombobox.png)

### 3. Tambah Pesanan ke Tabel (`JButton` Tambah & `JTable`)
![Tambah Data](screenshot/tambah-data.png)

### 4. Konfirmasi Pesanan (`JOptionPane`)
![Pesan Data](screenshot/pesan-data.png)