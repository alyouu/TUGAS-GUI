public class Menu {
    protected String namaMenu;
    protected int harga;

    public Menu(String namaMenu, int harga) {
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHarga() {
        return harga;
    }
}