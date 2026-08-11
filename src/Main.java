
public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon(25, "pikachu", "electric", 35);
        
        System.out.println("Pokémon creado con éxito");
        System.out.println("Nombre: " + pikachu.getName());
        System.out.println("Tipo: " + pikachu.getType());
        System.out.println("HP: " + pikachu.getHp());
    }
    
}
