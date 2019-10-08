package co.edu.sena.fundamentals.lesson08;

public class CarritoCompras {
    public static void main(String[] args) {
        Camisa miCamisa = new Camisa();
        System.out.println("inicial");
        System.out.println("color camisa: "+ miCamisa.codigoColor );
        System.out.println(miCamisa);
        cambiarColorCamisa(miCamisa, 'B');
        System.out.println("luego de ejecutar el metodo estatico");
        System.out.println("color camisa: "+ miCamisa.codigoColor );
        System.out.println(miCamisa);
    }

    private static void cambiarColorCamisa(Camisa laCamisa, char color) {
        laCamisa= new Camisa(); // crea una nueva referecia
        laCamisa.codigoColor= color;
        System.out.println("dentro del metodo estatico");
        System.out.println(laCamisa);
        System.out.println(laCamisa.codigoColor);
    }





}
