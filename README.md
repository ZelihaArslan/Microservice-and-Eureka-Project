# Spring Boot Mikroservis Projesi: API Gateway, Eureka ve Servisler

Bu proje, Spring Boot ve Spring Cloud kullanarak oluşturulmuş temel bir mikroservis uygulamasıdır. Proje, bir çalışanın (`IsciService`) hangi bölüme (`BolumService`) ait olduğunu gösteren basit bir senaryo üzerinden, **API Gateway arkasında çalışan** modern mikroservis mimarilerinin temel prensiplerini uygulamalı olarak göstermeyi amaçlamaktadır.

## Projenin Amacı ve Mimarisi

Bu projenin temel amacı, monolitik bir yapıdan mikroservis mimarisine geçişte karşılaşılan temel zorlukları anlamak ve çözmektir. Bu süreçte aşağıdaki temel konseptler üzerinde durulmuştur:

1.  **API Gateway (Tek Giriş Noktası):**
    *   Dış dünyadan (istemcilerden) gelen tüm istekler için tek bir giriş noktası oluşturmak amacıyla **Spring Cloud Gateway** kullanıldı. Gateway, gelen istekleri ilgili servise yönlendirir, URL'leri yeniden yazar (`/isciService/**` gibi) ve sistemin iç yapısını dış dünyadan gizleyerek güvenliği ve yönetilebilirliği artırır.

2.  **Servis Kayıt ve Bulma (Service Registry & Discovery):**
    *   Servislerin birbirlerinin ağ adreslerini dinamik olarak bulabilmesi için **Netflix Eureka** bir servis kayıt merkezi olarak yapılandırıldı. Artık servisler, birbirlerine sabit IP/port adresleri yerine Eureka'ya kaydettikleri servis isimleri (`lb://ISCISERVICE` gibi) üzerinden ulaşır. Bu, sistemi **esnek ve dayanıklı** hale getirir.

3.  **Servisler Arası İletişim:**
    *   Servisler arası REST API iletişimini yönetmek için **Spring Cloud OpenFeign** kullanıldı. Feign, `RestTemplate`'e göre çok daha temiz ve deklaratif bir yöntem sunarak geliştirici deneyimini iyileştirir.

4.  **Her Servise Ayrı Veritabanı (Database per Service):**
    *   Mikroservis mimarisinin temel prensiplerinden biri olarak, `IsciService` ve `BolumService` kendi bağımsız veritabanlarına (`isci_db` ve `bolum_db`) sahip olacak şekilde yapılandırıldı.

## Kullanılan Teknolojiler

*   **Java 17**
*   **Spring Boot:** Mikroservislerin temelini oluşturmak için.
*   **Spring Cloud:**
    *   **Spring Cloud Gateway:** API Gateway implementasyonu için.
    *   **Netflix Eureka Server:** Servis Kayıt ve Bulma için.
    *   **Spring Cloud OpenFeign:** Servisler arası deklaratif REST iletişimi için.
*   **Spring Data JPA / Hibernate:** Veritabanı işlemleri için.
*   **Maven:** Proje ve bağımlılık yönetimi için.
*   **MySQL:** Veritabanı olarak.

## Proje Nasıl Çalıştırılır?

1.  Bu repoyu klonlayın.
2.  MySQL veritabanınızın çalıştığından emin olun. Servisler, `createDatabaseIfNotExist=true` ayarı sayesinde kendi veritabanlarını oluşturacaktır.
3.  Aşağıdaki sırayla servisleri başlatın:
    1.  **Service Registry** (`serviceRegistry` projesi - Eureka Sunucusu)
    2.  **Bölüm Servisi** (`bolumService`)
    3.  **Çalışan Servisi** (`isciService`)
    4.  **API Gateway** (`apiGateway` projesi)
4.  Eureka arayüzünü kontrol etmek için tarayıcınızdan `http://localhost:8761/` adresini ziyaret edin. `ISCISERVICE`, `BOLUMSERVICE` ve `APIGATEWAY`'in kayıtlı olduğunu göreceksiniz.
5.  Aşağıdaki gibi bir istek göndererek sistemi **API Gateway üzerinden** test edebilirsiniz:

    *   **Çalışan Servisine Ulaşmak İçin:**
        ```
        GET http://localhost:8083/isciService/uygulama/isciler/1
        ```
    *   **Bölüm Servisine Ulaşmak İçin:**
        ```
        GET http://localhost:8083/bolumService/uygulama/bolumler/1
        ```
