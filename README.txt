Merhaba iyi günler dilerim.
Yollamış olduğunuz case ile ilgili önemli bilgiler aşağıda ki gibidir.

1) Case'i micro-service arch. gibi kurgulamaya çalıştım. Birbiri ile ilişkili entity'ler arasında çok tercih edilmeyen  bir yöntem olsa da bu konuda ki yetkinliğimi de göstermek istedim.
2) Case'de kullanılan Postman request'leri collection şeklinde ana directory'e eklenmiştir.
3) Proje'de ki eksikler
    3.1) Global exception handling ile daha doğru ve stabil bir loglama ve handling işlemi yapılabilir.
    3.2) Interface ve Impl sınıfları şeklinde controller'lar ve service katmanları tasarlanabilir.
    3.3) Flyway gibi bir migration tool'u ile default datalar db'ye migrate edilebilir(Storage ve category dataları gibi).

DB olarak PostgreSQL kullanılmıştır. Resource altından connection string'e erişebilirsiz.

Görkem AYKAÇ
grkemaykac@gmail.com