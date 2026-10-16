ANALISIS REFERENCE & RANCANGAN: CHARACTER MANAGER SPRINT #2
Nama: Royson Fajar Simatupang
NIM: 253303621268
Mata Kuliah: Java Visual (SIH-6406)
Tanggal: 16 Oktober 2026
1. Analisis Reference: Character a = new Character(...); Character b = a; b.setLevel(8);
Apa yang dicetak oleh a.getLevel() dan a == b? Method a.getLevel() akan mencetak angka 8, dan ekspresi a == b akan bernilai true.
Alasan (Konsep Reference): Di dalam Java, variabel objek menyimpan referensi (alamat memori), bukan nilai mentahnya secara langsung. Ketika perintah Character b = a; dieksekusi, alamat memori objek yang ditunjuk oleh a disalin ke b. Akibatnya, a dan b menunjuk ke satu objek fisik yang sama di heap memory. Ketika method b.setLevel(8) dipanggil, objek fisik tersebut yang diubah, sehingga saat a.getLevel() dipanggil, nilainya ikut berubah menjadi 8.
Cara Membuat b Benar-benar Independen: Untuk membuat objek b terpisah secara mandiri (deep copy atau clone), kita harus menginisialisasi objek baru menggunakan constructor dengan menyalin nilai atribut dari a, contohnya: Character b = new Character(a.getName(), a.getType(), a.getLevel(), a.getMana());. Dengan cara ini, a == b akan menghasilkan false karena keduanya berada di alamat memori yang berbeda.
2. Analogi Reference dan Primitive Value
Analogi Sehari-hari:
Primitive Value (Nilai Primitif): Bayangkan sebuah catatan kecil berisi angka uang di dompet Anda, misal Rp10.000. Jika Anda memfotokopi catatan itu lalu memberikannya kepada teman Anda, uang asli di dompet Anda tetap utuh dan tidak terpengaruh jika teman Anda mencorat-coret kertas fotokopinya.
Reference (Referensi): Bayangkan sebuah kunci loker penitipan barang di stasiun. Variabel a adalah kunci pertama yang membuka loker nomor 5. Ketika Anda menulis Character b = a;, Anda menduplikat kunci tersebut menjadi b. Sekarang ada dua kunci (a dan b) yang membuka loker nomor 5 yang sama. Jika b mengambil isi barang di dalam loker tersebut, maka saat a membuka loker itu, isinya juga sudah berubah atau kosong.
3. Mengapa totalCharacterCreated Bersifat static? Apa yang Terjadi Jika Tidak static?
Alasan Bersifat static: Variabel totalCharacterCreated digunakan untuk melacak total keseluruhan objek Character yang pernah berhasil dibuat oleh aplikasi dari semua instance yang ada. Keyword static membuat variabel tersebut melekat pada kelas (CharacterManager), bukan pada instance objek individual.
Risiko Jika Tidak static: Jika variabel tersebut bersifat non-static (variabel instance biasa), setiap kali objek CharacterManager baru dibuat, nilai hitungan akan terisolasi atau direset ulang dari nol untuk setiap objek manajer yang berbeda, sehingga akumulasi total global seluruh karakter gagal tercatat secara akurat.
4. Mengapa equals() Bawaan Kelas Object Tidak Cocok untuk Cek Duplikat Nama, dan Apa Solusinya?
Alasan Ketidakcocokan: Method equals() bawaan kelas Object membandingkan alamat memori fisik (==) dari dua objek, bukan isi atributnya. Meskipun dua objek Character memiliki nama string yang sama persis (misal Arthur), Java akan menganggapnya berbeda karena menempati lokasi memori yang berbeda.
Solusinya: Kita harus melakukan override (penulisan ulang) method equals() di dalam kelas Character agar logika pengecekan difokuskan pada kesamaan isi atribut teks nama (name.equals(...)), serta mengimplementasikan method hashCode() agar konsisten dengan kontrak pemrograman Java.
5. Apa Risiko Jika getAllCharacters() Mengembalikan ArrayList Asli? Kaitkan dengan Konsep Reference di Nomor 1
Risiko Enkapsulasi Jebol: Jika method getAllCharacters() mengembalikan referensi ke List internal secara langsung tanpa perlindungan, pihak luar (kode pemanggil di luar class) dapat memanggil method seperti .clear(), .remove(), atau memodifikasi elemen di dalamnya secara bebas tanpa melalui aturan validasi CharacterManager (misalnya melanggar aturan pencegahan duplikat nama).
Kaitan dengan Reference: Sama seperti kasus b = a, pemanggil memegang referensi alamat memori yang sama persis dengan list asli yang dikelola oleh manager. Oleh karena itu, kita menerapkan Defensive Copying dengan mengembalikan objek ArrayList baru yang berisi salinan elemen-elemen di dalamnya (new ArrayList<>(characters)).

