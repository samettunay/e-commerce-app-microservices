# Microservices Course - Spring Boot

Kurs: https://www.youtube.com/watch?v=jdeSV0GRvwI&t

![diagram](https://github.com/user-attachments/assets/b9aa5d87-e56e-4d47-ab12-930d4449fce5)

Bu proje, **Mikroservis Mimarisi**'ni Spring Boot ile derinlemesine öğrenmek için hazırlanmış bir eğitim içeriğidir.

## 🚀 Projede Kullanılan Temel Kavramlar
- **Service Registry and Discovery (Eureka)**: Mikroservislerin birbirini bulmasını sağlar.
- **API Gateway**: Tüm isteklerin geçtiği bir kapı, güvenlik ve yönlendirme sağlar.
- **CQRS (Command Query Responsibility Segregation)**: Okuma ve yazma işlemlerinin ayrılması.
- **Her Servise Ayrı Veritabanı (Database per Service)**: Mikroservisler için bağımsız veritabanı.
- **Event-Driven Architecture (Kafka)**: Mikroservisler arası mesajlaşma.
- **Saga Pattern**: Dağıtık işlemlerin yönetimi.
- **Circuit Breaker**: Hatalı servislerin diğerlerini etkilemesini engelleyen mekanizma.

## 🛠️ Proje İçeriği

### Bölüm 1: Spring Boot Temelleri
- Spring Framework teorik giriş
- Proje oluşturma
- Veritabanı bağlantısı (Hibernate, JPA)
- Servis, Controller, DTO, Exception Handling

### Bölüm 2: Mikroservis Mimarisi Tanıtımı
- Mikroservis nedir?
- Mikroservis mimarisinin temel prensipleri
- Mikroservis mimarisi desenleri

### Bölüm 3: Uygulama Geliştirme Adımları
- GitHub Mono-Repository oluşturma
- Müşteri, Sipariş, Ödeme, Bildirim servislerinin geliştirilmesi
- Config Server ile merkezi yapılandırma yönetimi
- Eureka Service Discovery entegrasyonu
- API Gateway ile istek yönlendirme
- Kafka ile asenkron iletişim
- E-posta bildirim servisi
- Dağıtık izleme (Zipkin)
- API Gateway üzerinden dökümantasyon sağlama

## 📂 Mikroservisler
- **Customer Service**
- **Order Service**
- **Payment Service**
- **Notification Service**

## 🐳 Docker Kullanımı
Proje, Docker Compose kullanılarak container ortamında çalıştırılmaktadır.


## 🔗 Teknolojiler
- Java Spring Boot
- Kafka
- Eureka
- API Gateway
- Docker
- Keyclaok & Zipkin
