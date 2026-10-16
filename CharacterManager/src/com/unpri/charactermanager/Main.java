package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO BAGIAN A: IMPLEMENTASI DASAR ===");
        
        // Membuka 3 karakter dasar
        Character c1 = new Character("Arthur", CharacterType.WARRIOR);
        Character c2 = new Character("Merlin", CharacterType.MAGE, 5, 200);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 3, 120);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("\n--- Demo Level Up ---");
        c1.levelUp();
        System.out.println("Status terbaru Arthur: " + c1);

        System.out.println("\n==========================================");
        System.out.println("=== DEMO BAGIAN B: EKSTENSI FITUR MANDIRI ===");
        
        // 5. Buat 1 karakter baru, set mana-nya, panggil isAlive(), cetak hasilnya
        Character c4 = new Character("Uther", CharacterType.PALADIN, 2, 80);
        System.out.println("Karakter Baru: " + c4.getName());
        System.out.println("Mana Awal: " + c4.getMana());
        
        c4.setMana(150);
        System.out.println("Mana Setelah Dimodifikasi: " + c4.getMana());
        
        System.out.println("Apakah " + c4.getName() + " masih hidup? " + c4.isAlive());
        System.out.println("ToString Karakter Baru: " + c4);

        // Demo Pengujian Validasi Mana Negatif
        try {
            System.out.println("\nMencoba set mana negatif...");
            c4.setMana(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi Exception (Sesuai Ekspektasi): " + e.getMessage());
        }
    }
}