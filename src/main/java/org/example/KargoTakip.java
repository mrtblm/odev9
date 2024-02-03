package org.example;

public class KargoTakip {
    public String kargo(String TakipNumarasi) throws GecersizTakipException, GonderiYokException {

        if (TakipNumarasi == null || TakipNumarasi.isEmpty()) {
            throw new GecersizTakipException("Geçersiz Takip Numarası: " + TakipNumarasi);
        }

        // Kargo bulunamadı
        if (!isShipmentExist(TakipNumarasi)) {
            throw new GonderiYokException("Belirtilen Takip Numarasına Ait Kargo Bulunamadı: " + TakipNumarasi);
        }

        // Kargo takip bilgisi
        return getShipmentStatus(TakipNumarasi);
    }

    private boolean isShipmentExist(String TakipNumarasi) {
        // Örnek bir uygulama, herhangi bir kargo bulunup bulunmadığını kontrol ediyor
        return TakipNumarasi.equals("MRT1988");
    }

    // Kargo numarasına göre kargo durumu alınıyor
    private String getShipmentStatus(String TakipNumarasi) {
        return "Kargo yola çıktı";
    }

    public static void main(String[] args) {
        // Test senaryo
        KargoTakip TakipSistemi = new KargoTakip();

        try {
            // Geçerli bir takip numarasıyla kargo takip işlemi
            String status = TakipSistemi.kargo("ABC123");
            System.out.println("Kargo Durumu: " + status);
        } catch (GecersizTakipException | GonderiYokException e) {
            System.err.println("Hata Oluştu: " + e.getMessage());
        }

        try {
            // Geçersiz bir takip numarasıyla kargo takip işlemi
            String status = TakipSistemi.kargo("");
            System.out.println("Kargo Durumu: " + status);
        } catch (GecersizTakipException | GonderiYokException e) {
            System.err.println("Hata Oluştu: " + e.getMessage());
        }

        try {
            // Var olmayan bir kargo numarasıyla kargo takip işlemi
            String status = TakipSistemi.kargo("MRT1988");
            System.out.println("Kargo Durumu: " + status);
        } catch (GecersizTakipException | GonderiYokException e) {
            System.err.println("Hata Oluştu: " + e.getMessage());
        }
    }
}

// Özel bir hata sınıfı - Geçersiz takip numarası
class GecersizTakipException extends Exception {
    public GecersizTakipException(String message) {
        super(message);
    }
}

// Özel bir hata sınıfı - Kargo bulunamadı
class GonderiYokException extends Exception {
    public GonderiYokException(String message) {
        super(message);
    }
}
