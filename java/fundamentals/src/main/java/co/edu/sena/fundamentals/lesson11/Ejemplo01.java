package co.edu.sena.fundamentals.lesson11;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ejemplo01 {
    public static void main(String[] args) {
        Date fecha = new Date(2019,1,1);
        System.out.println(fecha);

        LocalDate horaLocal = LocalDate.now();
        System.out.println(horaLocal);

        LocalDateTime fechaHoraLocal = LocalDateTime.of(2019,01,01,18,12);
        System.out.println(fechaHoraLocal);

        LocalTime tiempoLocal = LocalTime.now();
        System.out.println(tiempoLocal);

        System.out.println(fechaHoraLocal.format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println(horaLocal.getEra());

        JapaneseDate fechaJaponesa = JapaneseDate.from(horaLocal);
        System.out.println(fechaJaponesa);

        System.out.println(horaLocal.minusMonths(1));
        System.out.println(horaLocal.plusWeeks(11));

        ArrayList<Integer> lista2 = new ArrayList<>();


        List<Integer> lista3 = new ArrayList<>();

        List<Integer> cola = new Stack<>();
        List<Integer> fila = new ArrayQueue<>(10);


    }
}
