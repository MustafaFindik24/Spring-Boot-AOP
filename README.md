# Cross Cutting Concerns Nedir?

Oluşturulan projenin belirli kurallar içerisinde uygulanan logging, security, caching, validation, exception handling, performans, transaction management gibi belirlenen; uygulamadan soyut yapıların her biridir. 

![image](https://user-images.githubusercontent.com/91599453/221838780-1221c86b-477a-48aa-a22d-f86d2d962b09.png)

Uygulama içerisinde herhangi bir bağımlılık oluşturmadan kullanılabilir.


# Aspect Oriented Programming (AOP) Nedir?

Yukarıda belirtilen Cross Cutting Concern kısımlarının kullanıldığı, okunabilirliği yüksek, kod tekrarından kaçınmayı hedefleyen bir programlama paradigmasıdır. Uygulamanın daha esnek hale getirilmesi, scaling desteklemesi, kolay yönetilebilmesi hedeflediği amaçlar arasındadır.


# AOP kullanarak Spring Boot proje Oluşturulması

pom.xml dosyamıza aop kullanımı için dependency eklememiz gerekmekte.

![image](https://user-images.githubusercontent.com/91599453/221845631-b1eb6e1f-b542-47e9-8e13-776dda4d5cc8.png)

Spring Boot uygulamamızda AOP kullanmamız için Application sınıfımızda Aspect kullanımını aktif etmemiz gerekiyor.

![image](https://user-images.githubusercontent.com/91599453/221846453-2d20ae99-1212-4f60-83a5-7fa8062f81fe.png)

Aspects paketi altında AspectService sınıfını oluşturduk. @Aspect anotasyonu ile uygulamamıza bu sınıfın aspect kullanımı için düzenlenmesini ve bir Spring Bean olarak Spring'in görebilmesi içinde @Component anotasyonları ile belirtiyoruz. Logging için de Slf4j anotasyonunu log bilgilerini ekranda göstermek için aynı sınıfa ekledik.

![image](https://user-images.githubusercontent.com/91599453/221847991-ba7465ab-2978-4c49-91d4-507e372c18e0.png)



![image](https://user-images.githubusercontent.com/91599453/221846021-a274bb76-8d8a-4a38-9088-18f4859f990c.png)
