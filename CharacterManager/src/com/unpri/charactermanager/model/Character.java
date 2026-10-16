package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Fitur Baru Bagian B

    // Constructor 1: Default level 1, mana 100, recalculate HP & Attack
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.mana = 100;
        recalculateStats();
    }

    // Constructor 2: Kustomisasi level dan mana
    public Character(String name, CharacterType type, int level, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        setMana(mana); // Menggunakan setter untuk menerapkan validasi
        recalculateStats();
    }

    // Helper method internal untuk menghitung HP dan Attack berdasarkan Level
    private void recalculateStats() {
        this.hitPoints = this.level * 100;
        this.attackPower = this.level * 15;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    // setLevel menghitung ulang HP dan Attack secara internal
    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level harus minimal 1.");
        }
        this.level = level;
        recalculateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // Bagian B: Getter & Setter Mana dengan validasi
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Bagian B: Method isAlive()
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // Method levelUp untuk demo peningkatan level
    public void levelUp() {
        this.level++;
        recalculateStats();
        System.out.println(this.name + " naik ke level " + this.level + "!");
    }

    @Override
    public String toString() {
        return String.format("Character{name='%s', type=%s, level=%d, HP=%d, Attack=%d, Mana=%d, Alive=%b}",
                name, type, level, hitPoints, attackPower, mana, isAlive());
    }
}