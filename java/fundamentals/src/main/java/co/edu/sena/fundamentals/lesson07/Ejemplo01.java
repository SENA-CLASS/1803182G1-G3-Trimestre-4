package co.edu.sena.fundamentals.lesson07;

public class Ejemplo01 {
    public static void main(String[] args) {
        String hola  = " HOLA MUNDO ";
        hola = hola + " asdfasd";
        System.out.println(hola.trim());
        System.out.println(hola.toLowerCase());
        System.out.println("asdfasdfasdfasdf".charAt(5));
        StringBuilder a = new StringBuilder(1000);
        a.append("hola mundo");
        a.append(" asdfadsfsdfsd");
        System.out.println(a);

        StringBuffer hh = new StringBuffer("hola desde string buffer");
        System.out.println(hh);

        String b = "hola";
        String c = "hola muando";
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        System.out.println(c.indexOf('a'));




    }
}
