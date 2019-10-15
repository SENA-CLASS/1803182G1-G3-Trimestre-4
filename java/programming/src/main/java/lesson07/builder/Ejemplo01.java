package lesson07.builder;

public class Ejemplo01 {
    public static void main(String[] args) {
        Hero mage =
                new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK)
                        .withWeapon(Weapon.DAGGER).build();
        System.out.println(mage.toString());


        Hero h1 = new Hero.Builder(Profession.WARRIOR,"pedrito")
                .withHairColor(HairColor.RED)
                .withArmor(Armor.PLATE_MAIL)
                .withWeapon(Weapon.SWORD)
                .withHairType(HairType.LONG_STRAIGHT)
                .build();

    }
}
