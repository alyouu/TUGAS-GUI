import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JuiceBar {
    private String[] namaJus = {"Mango Sunset", "Berry Breeze", "Fresh Orange"};
    private int[] hargaJus = {15000, 18000, 12000};

    private Color latar = new Color(255, 251, 230);
    private Color aksen = new Color(255, 167, 38);

    private JFrame frame = new JFrame("Aplikasi Pemesanan Juice Bar");
    private JLabel lblJudul = new JLabel("JUICE BAR", JLabel.CENTER);
    private JTextField txtNama = new JTextField(), txtJumlah = new JTextField();
    private JComboBox<String> cmbJus = new JComboBox<String>();
    private JButton btnTambah = new JButton("Tambah"), btnHapus = new JButton("Hapus"), btnPesan = new JButton("Pesan");
    private DefaultTableModel modelPesanan = new DefaultTableModel(new String[]{"Pemesan", "Menu Jus", "Harga Satuan", "Jumlah", "Subtotal"}, 0);
    private JTable tabelPesanan = new JTable(modelPesanan);

    public JuiceBar() {
        lblJudul.setFont(new Font("Arial", Font.BOLD, 18));
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setBackground(aksen);
        lblJudul.setOpaque(true);

        btnPesan.setBackground(aksen);
        btnPesan.setForeground(Color.WHITE);

        for (int i = 0; i < namaJus.length; i++) {
            cmbJus.addItem(namaJus[i] + " - Rp " + hargaJus[i]);
        }
    }

    public void launchFrame() {
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
        panelForm.setBackground(latar);
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelForm.add(new JLabel("Nama Pemesan")); panelForm.add(txtNama);
        panelForm.add(new JLabel("Varian Jus"));   panelForm.add(cmbJus);
        panelForm.add(new JLabel("Jumlah Gelas")); panelForm.add(txtJumlah);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 6));
        panelTombol.setBackground(latar);
        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnPesan);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(lblJudul, BorderLayout.NORTH);
        frame.getContentPane().add(panelAtas, BorderLayout.CENTER);
        frame.getContentPane().add(new JScrollPane(tabelPesanan), BorderLayout.SOUTH);

        TombolHandler handler = new TombolHandler();
        btnTambah.addActionListener(handler);
        btnHapus.addActionListener(handler);
        btnPesan.addActionListener(handler);
        frame.addWindowListener(new WindowHandler());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class TombolHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnTambah) {
                try {
                    int jumlah = Integer.parseInt(txtJumlah.getText().trim());
                    if (jumlah < 1) {
                        JOptionPane.showMessageDialog(frame, "Jumlah gelas minimal 1!");
                        return;
                    }
                    int idx = cmbJus.getSelectedIndex();
                    int hargaSatuan = hargaJus[idx];
                    int subtotal = hargaSatuan * jumlah;

                    modelPesanan.addRow(new Object[]{txtNama.getText(), namaJus[idx], hargaSatuan, jumlah, subtotal});
                    txtJumlah.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Jumlah gelas harus diisi angka!");
                }
            } else if (e.getSource() == btnHapus) {
                int baris = tabelPesanan.getSelectedRow();
                if (baris != -1) {
                    modelPesanan.removeRow(baris);
                }
            } else if (e.getSource() == btnPesan) {
                JOptionPane.showMessageDialog(frame, "Terima kasih sudah order di Juice Bar!");
                modelPesanan.setRowCount(0);
                txtNama.setText("");
            }
        }
    }

    private class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JuiceBar().launchFrame();
    }
}