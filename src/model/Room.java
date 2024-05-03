package model;
public class Room {
    private int id;
    private int numeroQuarto;
    private int capacidadeAdultos;
    private int capacidadeCriancas;
    private float preco;

    // Constructor, getters and setters
    public Room(int id, int numeroQuarto, int capacidadeAdultos, int capacidadeCriancas, float preco) {
        this.id = id;
        this.numeroQuarto = numeroQuarto;
        this.capacidadeAdultos = capacidadeAdultos;
        this.capacidadeCriancas = capacidadeCriancas;
        this.preco = preco;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return numeroQuarto;
    }

    public int getAdultsCapacity() {
        return capacidadeAdultos;
    }

    public int getChildrenCapacity() {
        return capacidadeCriancas;
    }

    public float getPrice() {
        return preco;
    }
    
    //setters
    public void setId(int nid){
        id = nid;
    }
    public void setRoomNumber(int nRoom){
        numeroQuarto = nRoom;
    }
    public void setAdultsCapacity(int nAdultos){
        capacidadeAdultos = nAdultos;
    }
    public void setChildrenCapacity(int nCrianca){
        capacidadeCriancas = nCrianca;
    }
    public void setPrice(float nPreco){
        preco = nPreco;
    }
}

