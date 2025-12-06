# Spring Boot Mikroservis Projesi: Çalışan ve Bölüm Servisleri

Bu proje, Spring Boot ve Spring Cloud kullanarak oluşturulmuş temel bir mikroservis uygulamasıdır. Proje, bir çalışanın (`IsciService`) hangi bölüme (`BolumService`) ait olduğunu gösteren basit bir senaryo üzerinden, modern mikroservis mimarilerinin temel prensiplerini uygulamalı olarak göstermeyi amaçlamaktadır.

## Projenin Amacı ve Öğrenilenler

Bu projenin temel amacı, monolitik bir yapıdan mikroservis mimarisine geçişte karşılaşılan temel zorlukları anlamak ve çözmektir. Bu süreçte aşağıdaki temel konseptler üzerinde durulmuştur:

1.  **Servis Kayıt ve Bulma (Service Registry & Discovery):**
    *   **Eski Yaklaşım:** Servisler, birbirlerinin adreslerini (`http://localhost:9090` gibi) kod içerisinde sabit olarak biliyordu. Bu, esnek olmayan ve yönetimi zor bir yapıydı.
    *   **Yeni Yaklaşım:** **Eureka Server** kullanarak bir servis kayıt merkezi oluşturuldu. Artık her servis başlangıçta kendini Eureka'ya kaydediyor ve başka bir servise ihtiyaç duyduğunda adresini Eureka'dan dinamik olarak soruyor. Bu, sistemi çok daha **esnek ve dayanıklı** hale getirdi.

2.  **Servisler Arası İletişim:**
    *   **Yeni Yaklaşım:** Servisler arası REST API iletişimini yönetmek için Spring Cloud **Feign Client** kullanıldı. Feign, `RestTemplate`'e göre çok daha temiz, okunabilir ve deklaratif bir yöntem sunarak boilerplate kodu azalttı.

3.  **Her Servise Ayrı Veritabanı (Database per Service):**
    *   Mikroservis mimarisinin temel prensiplerinden biri olarak, `IsciService` ve `BolumService` kendi bağımsız veritabanlarına (`isci_db` ve `bolum_db`) sahip olacak şekilde yapılandırıldı.

4.  **Dayanıklı ve Anlaşılır Hata Yönetimi (Resilient Error Handling):**
    *   Uygulama, veritabanında kayıt bulunamaması (`Optional` kullanımı) veya bir servisin `null` veri döndürmesi gibi durumlarda çökmemesi için geliştirildi. `NullPointerException` gibi genel hatalar yerine, "Çalışan bulunamadı" gibi **anlamlı ve özel hata mesajları** üreten bir yapıya geçildi.

5.  **Merkezi Proje Yönetimi:**
    *   Tüm mikroservis modülleri, tek bir ana **Maven (`pom.xml`)** projesi altında birleştirilerek proje yönetimi kolaylaştırıldı.

## Kullanılan Teknolojiler

*   **Java 17**
*   **Spring Boot:** Mikroservislerin temelini oluşturmak için.
*   **Spring Cloud:**
    *   **Eureka Server:** Servis Kayıt ve Bulma için.
    *   **OpenFeign:** Servisler arası deklaratif REST iletişimi için.
*   **Spring Data JPA / Hibernate:** Veritabanı işlemleri için.
*   **Maven:** Proje ve bağımlılık yönetimi için.
*   **MySQL:** Veritabanı olarak.

## Proje Nasıl Çalıştırılır?

1.  Bu repoyu klonlayın.
2.  MySQL veritabanınızın çalıştığından emin olun. Servisler, `createDatabaseIfNotExist=true` ayarı sayesinde kendi veritabanlarını oluşturacaktır.
3.  Aşağıdaki sırayla servisleri başlatın:
    1.  **Eureka Sunucusunu** (`eureka-server` projesi)
    2.  **Bölüm Servisini** (`bolumService`)
    3.  **Çalışan Servisini** (`isciService`)
4.  Eureka arayüzünü kontrol etmek için tarayıcınızdan `http://localhost:8761/` adresini ziyaret edin. `ISCISERVICE` ve `BOLUMSERVICE`'in kayıtlı olduğunu göreceksiniz.
5.  Aşağıdaki gibi bir istek göndererek sistemi test edebilirsiniz:
    *   `GET http://localhost:8081/uygulama/isciler/1`
