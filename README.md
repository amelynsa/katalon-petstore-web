# Web Automation Testing — JPetStore

## 1. Deskripsi Proyek

Proyek ini merupakan implementasi pengujian otomatis pada website demo JPetStore menggunakan Katalon Studio. Pengujian dilakukan untuk memverifikasi fungsi utama website, mulai dari akses halaman, navigasi produk, login, hingga penambahan produk ke keranjang.

Selain pengujian utama, proyek ini juga menerapkan **Hybrid Mode (Manual dan Script), Positive dan Negative Testing, Data-Driven Testing (DDT), serta Global Variables** pada pengujian login.

**Website yang diuji:** https://petstore.octoperf.com/actions/Catalog.action

## 2. Tools dan Teknologi

- **Katalon Studio 11.5.0** — untuk membuat dan menjalankan test case otomatis.
- **Groovy** — untuk penulisan script pengujian.
- **Web UI Testing** — untuk menguji fungsi pada website.
- **Object Repository** — untuk menyimpan dan mengelola objek web yang digunakan dalam pengujian.
- **Global Variables** — untuk menyimpan nilai yang dapat digunakan kembali oleh test case.
- **Data Files** — untuk menyediakan variasi data dalam Data-Driven Testing.
- **Test Suite** — untuk menjalankan beberapa test case dalam satu rangkaian pengujian.

## 3. Cakupan Pengujian (Test Coverage)

Pengujian utama mencakup lima skenario berikut.

| ID | Skenario Pengujian | Jenis Pengujian | Status |
|---|---|---|---|
| TC01 | Memastikan halaman utama berhasil dibuka | Positive | Passed |
| TC02 | Memastikan navigasi ke halaman produk berhasil | Positive | Passed |
| TC03 | Memastikan login dengan kredensial valid berhasil | Positive | Passed |
| TC04 | Memastikan login dengan kredensial tidak valid ditolak | Negative | Passed |
| TC05 | Memastikan produk berhasil ditambahkan ke keranjang | Positive | Passed |

**Positive Testing** digunakan untuk memastikan fungsi berjalan sesuai harapan ketika diberikan input atau kondisi yang valid.

**Negative Testing** digunakan untuk memastikan sistem memberikan respons yang sesuai ketika diberikan input yang tidak valid.

Status `Passed` menunjukkan bahwa test case berhasil dijalankan sesuai hasil yang diharapkan pada eksekusi yang tercatat.

## 4. Implementasi Hybrid Mode

Hybrid Mode diterapkan dengan memanfaatkan **Manual Mode dan Script Mode** di Katalon Studio.

- **Manual Mode:** langkah pengujian disusun menggunakan keyword dan objek web dari Object Repository.
- **Script Mode:** langkah pengujian ditulis menggunakan script Groovy untuk mengatur alur pengujian dan validasi hasil.

Pendekatan ini digunakan agar pengujian dapat dibuat melalui langkah visual maupun kode sesuai kebutuhan test case.

## 5. Implementasi Data-Driven Testing (DDT)

Data-Driven Testing diterapkan pada test case `Login_DataFile` yang berada di folder `tes_login`.

DDT digunakan untuk menjalankan skenario login dengan beberapa kombinasi username dan password dari file `Data Files/LoginData`, sehingga pengujian tidak perlu dibuat ulang untuk setiap kombinasi data.

| Nama Test Case | Skenario Pengujian | Jenis Pengujian | DDT |
|---|---|---|---|
| `Login_Positive` | Memastikan login berhasil menggunakan kredensial valid | Positive | Tidak |
| `Login_DataFile` | Menguji login menggunakan beberapa kombinasi username dan password dari file `LoginData` | Positive & Negative | Ya |
| `Login_Negative_Manual` | Memastikan login gagal menggunakan kredensial tidak valid melalui Manual Mode | Negative | Tidak |
| `Login_Positive_Manual` | Memastikan login berhasil melalui Manual Mode | Positive | Tidak |

File `LoginData` berisi data login valid dan tidak valid untuk memverifikasi bahwa sistem menerima kredensial yang benar dan menolak kredensial yang salah.

## 6. Implementasi Global Variables

Global Variables digunakan untuk menyimpan nilai yang dapat digunakan kembali oleh test case, sehingga kredensial tidak perlu ditulis langsung berulang kali di dalam script.

Pada proyek ini, Global Variables digunakan untuk kebutuhan pengujian login.

| Nama Variabel | Tipe Data | Nilai Default | Kegunaan |
|---|---|---|---|
| `GlobalVariable.username` | String | `j2ee` | Menyimpan username pengujian |
| `GlobalVariable.password` | String | `j2ee` | Menyimpan password pengujian |

Variabel tersebut dikelola melalui Profiles di Katalon Studio dan digunakan pada test case login berbasis Script, seperti `Login_Positive`.

Penggunaan Global Variables membantu pengelolaan data pengujian agar lebih terstruktur dan memudahkan perubahan kredensial tanpa harus mengubah nilai di setiap baris script.

## 7. Object Repository

Object Repository digunakan untuk menyimpan identifikasi elemen pada website yang dibutuhkan selama pengujian.

Objek yang digunakan dalam pengujian login antara lain:

- `username` — kolom input username.
- `password` — kolom input password.
- `loginButton` — tombol login.
- `signOutLink` — tautan sign out untuk memverifikasi bahwa pengguna berhasil login.

Penggunaan Object Repository membantu membuat pengujian lebih terorganisasi dan memudahkan pemeliharaan locator apabila elemen website berubah.

## 8. Test Suite

Seluruh test case digabungkan ke dalam Test Suite bernama `TS_PetStore_Web` agar dapat dijalankan dalam satu rangkaian pengujian.

Test Suite berisi sembilan test case:

1. `TC01_Access_Home`
2. `TC02_Navigate_Product`
3. `TC03_Login_Valid`
4. `TC04_Login_Invalid`
5. `TC05_Add_Product_To_Cart`
6. `Login_Positive`
7. `Login_DataFile`
8. `Login_Negative_Manual`
9. `Login_Positive_Manual`

## 9. Hasil Eksekusi

Berdasarkan hasil eksekusi terakhir `TS_PetStore_Web` di Katalon Studio, diperoleh hasil berikut:

| Keterangan | Hasil |
|---|---:|
| Total Test Case | 9 |
| Passed | 9 |
| Failed | 0 |
| Error | 0 |

Hasil tersebut menunjukkan bahwa seluruh test case dalam eksekusi terakhir berhasil dijalankan tanpa kegagalan maupun error.

Laporan hasil eksekusi dapat disertakan dalam repository setelah diekspor dari Katalon Studio.

## 10. Cara Menjalankan Pengujian

1. Clone atau unduh repository ini.
2. Buka project menggunakan Katalon Studio.
3. Pastikan browser yang akan digunakan sudah terpasang.
4. Buka folder `Test Suites`.
5. Pilih `TS_PetStore_Web`.
6. Klik **Run** dan pilih browser yang tersedia.
7. Tunggu hingga seluruh test case selesai dijalankan.
8. Periksa hasil eksekusi pada tab **Result** di Katalon Studio.

## 11. Struktur Project

Struktur utama project Katalon yang digunakan meliputi:

- `Test Cases/` — berisi test case pengujian website dan login.
- `Test Suites/` — berisi `TS_PetStore_Web`.
- `Object Repository/` — berisi objek dan locator elemen web.
- `Data Files/` — berisi file `LoginData` untuk DDT.
- `Profiles/` — berisi konfigurasi Global Variables.
- File project Katalon — digunakan untuk membuka project di Katalon Studio.

## 12. Kesimpulan

Proyek ini dibuat untuk mempraktikkan pengujian otomatis website menggunakan Katalon Studio. Pengujian mencakup akses halaman, navigasi produk, login valid dan tidak valid, serta penambahan produk ke keranjang.

Proyek ini juga menerapkan Hybrid Mode, Data-Driven Testing, Global Variables, Object Repository, dan Test Suite sebagai bagian dari proses pengujian web.

