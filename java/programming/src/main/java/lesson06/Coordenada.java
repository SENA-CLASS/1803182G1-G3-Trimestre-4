package lesson06;

import java.util.Objects;

public class Coordenada implements Comparable<Coordenada> {
    private double latidud;
    private double longitud;

    public Coordenada(double latidud, double longitud) {
        this.latidud = latidud;
        this.longitud = longitud;
    }

    public double getLatidud() {
        return latidud;
    }

    public void setLatidud(double latidud) {
        this.latidud = latidud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return Double.compare(that.latidud, latidud) == 0 &&
                Double.compare(that.longitud, longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latidud, longitud);
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "latidud=" + latidud +
                ", longitud=" + longitud +
                '}';
    }

    @Override
    public int compareTo(Coordenada o) {
        if (this.latidud < o.latidud)
            return -1;
        else if (this.latidud == o.latidud) return 0;
        else return 1;

    }
}
