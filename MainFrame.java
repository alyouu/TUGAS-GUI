import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private DataJuice data = new DataJuice();
    private Operasi operasi = new Operasi();

    private Color latar = new Color(255, 251, 230);
    private Color aksen = new Color(255, 167, 38);

    private JLabel lblJudul = new JLabel("JUICE BAR", JLabel.CENTER);
    private JTextField txtNama = new JTextField(), txtJumlah = new JTextField();
    private JComboBox<String> cmbJus = new JComboBox<String>();
    private JButton btnTambah = new JButton("Tambah"), btnHapus = new JButton("Hapus"), btnPesan = new JButton("Pesan");
    private DefaultTableModel modelTabel = new DefaultTableModel(new String[]{"Pemesan", "Menu Jus", "Harga Satuan", "Jumlah", "Subtotal"}, 0);
    private JTable tabelPesanan = new JTable(modelTabel);

    public MainFrame() {
        super("Aplikasi Pemesanan Juice Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450);

        lblJudul.setFont(new Font("Arial", Font.BOLD, 18));
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setBackground(aksen);
        lblJudul.setOpaque(true);

        btnPesan.setBackground(aksen);
        btnPesan.setForeground(Color.WHITE);

        String[] namaJus = data.getNamaJus();
        int[] hargaJus = data.getHargaJus();
        for (int i = 0; i < namaJus.length; i++) {
            cmbJus.addItem(namaJus[i] + " - Rp " + hargaJus[i]);
        }

        susunLayout();
        daftarkanListener();
    }

    private void susunLayout() {
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
        panelForm.setBackground(latar);
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelForm.add(new JLabel("Nama Pemesan")); panelForm.add(txtNama);
        panelForm.add(new JLabel("Varian Jus"));   panelForm.add(cmbJus);
        panelForm.add(new JLabel("Jumlah Gelas")); panelForm.add(txtJumlah);

        // Tombol diletakkan di bagian bawah sesuai gambar referensi
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 8));
        panelTombol.setBackground(latar);
        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnPesan);

        JPanel panelUtama = new JPanel(new BorderLayout());
        panelUtama.add(panelForm, BorderLayout.NORTH);
        panelUtama.add(new JScrollPane(tabelPesanan), BorderLayout.CENTER);
        panelUtama.add(panelTombol, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(lblJudul, BorderLayout.NORTH);
        getContentPane().add(panelUtama, BorderLayout.CENTER);
    }

    private void daftarkanListener() {
        TombolHandler handler = new TombolHandler();
        btnTambah.addActionListener(handler);
        btnHapus.addActionListener(handler);
        btnPesan.addActionListener(handler);
        addWindowListener(new WindowHandler());
    }

    private void refreshTabel() {
        modelTabel.setRowCount(0);
        for (int i = 0; i < operasi.getList().size(); i++) {
            PesananJuice p = operasi.getList().get(i);
            modelTabel.addRow(new Object[]{p.getPemesan(), p.getNamaMenu(), p.getHarga(), p.getJumlah(), p.getSubtotal()});
        }
    }

    private class TombolHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnTambah) {
                try {
                    int jumlah = Integer.parseInt(txtJumlah.getText().trim());
                    if (jumlah < 1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Jumlah gelas minimal 1!");
                        return;
                    }
                    int idx = cmbJus.getSelectedIndex();
                    PesananJuice p = new PesananJuice(txtNama.getText(), data.getNamaJus()[idx], data.getHargaJus()[idx], jumlah);
                    operasi.tambah(p);
                    refreshTabel();
                    txtJumlah.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Jumlah gelas harus diisi angka!");
                }
            } else if (e.getSource() == btnHapus) {
                int baris = tabelPesanan.getSelectedRow();
                if (baris != -1) {
                    operasi.hapus(baris);
                    refreshTabel();
                }
            } else if (e.getSource() == btnPesan) {
                JOptionPane.showMessageDialog(MainFrame.this, "Terima kasih sudah order di Juice Bar!");
                operasi.reset();
                refreshTabel();
                txtNama.setText("");
            }
        }
    }

    private class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}