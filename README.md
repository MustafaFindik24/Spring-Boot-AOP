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

AOP kullanımı için belirli advice türleri mevcuttur.

![image](https://user-images.githubusercontent.com/91599453/221846021-a274bb76-8d8a-4a38-9088-18f4859f990c.png)

@Before : Belirtilen metot çalışmadan önce çalışacak olan kod bloğudur.
@AfterThrowing : Belirtilen metodun exception dönmesi durumunda çalışacak olan metotdur.
@AfterReturning : Belirtilen metot başarılı şekilde çalıştıktan sonra çalışacak olan metotdur.
@After : Belirtilen metot çalıştıktan sonra çalışacak olan kod bloğudur.
@Around : Belirtilen metodun öncesinde ve sonrasında çalışacak olan kod bloğudur.

Around dışındaki advice türlerinin JoinPoint ile kullanımı önerilmektedir. Around ise ProcedingJoinPoint ile kullanımı önerilir. Biz uygulamamızda ikisini birden kullandık. 

JoinPoint sınıfını kullanarak @Before advice ını kullandık. İçerisinde belirtilen value ise çalışması gereken sınıf veya sınıfları düzenlemek için kullandık. Sırasıyla paket adı, sınıf adı, ve metot adı belirtilir. Eğer spesifik bir yer belirtilmesi istenmiyorsa ilgili yerlere * işareti konulur.

![image](https://user-images.githubusercontent.com/91599453/221850683-fde3697c-d54a-46a0-af65-4dea3d85283d.png)

Pointcut kullanarak @Around metodunun nerede çalışması gerektiğini belirttik. ObjectMapper sınıfı üzerinden nesne üretip JSON formatında logging kullanarak ekranda göstermek için info() metodunu kullandık. 

![image](https://user-images.githubusercontent.com/91599453/221851874-c75507eb-24ea-46cb-adb2-83896bf95732.png)

Postman üzerinden Service paketimizde bulunan UserServiceImpl içerisindeki saveUser() metodunu tetikleyip ekranda log bilgileri gözükecektir.

![image](https://user-images.githubusercontent.com/91599453/221852336-d4c30995-93a0-49a1-99e8-6a72c6c2be40.png)




