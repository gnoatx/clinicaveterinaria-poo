public class Pet {
    private static int ultimaId = 0;
    private int id;

    public static int getUltimaId() {
        return ultimaId;
    }
    public static void setUltimaId(int ultimaId) {
        Pet.ultimaId = ultimaId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
