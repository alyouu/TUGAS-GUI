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
![Tampilan Awal] <img width="960" height="419" alt="JTable" src="https://github.com/user-attachments/assets/ef54e594-f53c-40a7-abad-a2185376d981" />


### 2. Pilihan Varian Menu (`JComboBox`)
![Pilihan Menu]<img width="1920" height="837" alt="JComboBox" src="https://github.com/user-attachments/assets/947dd759-9655-4c65-8710-fbd70e400c09" />


### 3. Tambah Pesanan ke Tabel (`JButton` Tambah & `JTable`)
![Tambah Data]<img width="1920" height="750" alt="JTable input data" src="https://github.com/user-attachments/assets/1131a9d7-ae52-4b17-ba45-870a74360bec" />


### 4. Konfirmasi Pesanan (`JOptionPane`)
![Pesan Data]<img width="960" height="349" alt="JOptionPane" src="https://github.com/user-attachments/assets/f90f0607-fc5b-4cf5-b021-78ad4a12e1ca" />
