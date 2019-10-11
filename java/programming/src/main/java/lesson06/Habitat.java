package lesson06;

import lesson05.Animal;

import java.util.List;

public class Habitat {

    /**
     * este metodo se le pasa una lista de animales y una animal me retorna el animal si lo encunetra
     *
     * @param animales
     * @param animal
     * @param <T>
     * @return
     */
    public <T extends Animal> T buscarAnimal(List<T> animales, T animal){
        T animalEncontrado= null;
        for (T a:animales
             ) {
            if(a.equals(animal)){
                animalEncontrado= a;
            }
        }
        return animalEncontrado;
    }
}
