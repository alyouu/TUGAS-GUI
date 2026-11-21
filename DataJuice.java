public class PesananJuice extends Menu {
    private String pemesan;
    private int jumlah;

    public PesananJuice(String pemesan, String namaMenu, int harga, int jumlah) {
        super(namaMenu, harga);
        this.pemesan = pemesan;
        this.jumlah = jumlah;
    }

    public String getPemesan() {
        return pemesan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubtotal() {
        return harga * jumlah;
    }
}