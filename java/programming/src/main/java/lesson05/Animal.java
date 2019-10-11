package lesson05;

public interface Animal {
    public abstract void comer();

    public default void morir(){
        System.out.println("me mori");
    }
}
