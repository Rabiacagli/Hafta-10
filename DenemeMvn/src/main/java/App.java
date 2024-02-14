import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();



        // JPQL (Java Persistence Query Language)
        // SELECT  * FROM categories    jpql dilinde aşağıdaki gibi yazılır
       // Query getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat");   //tüm  listeyi 2 şekilde dönebiliriz aşağıdaki TypedQuery daha garanti
      /*  TypedQuery<Category>getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat", Category.class);
        List<Category> categoryList = getAllCategories.getResultList();

        for(Category category: categoryList){
            System.out.println(category.getName());
        }*/

        // SELECT  * FROM categories WHERE category_id      id'ye göre arama yapma
      /*  TypedQuery<Category>getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat WHERE cat.id = :id", Category.class);
        getAllCategories.setParameter("id",1);
        List<Category> categoryList = getAllCategories.getResultList();

        for(Category category: categoryList){
            System.out.println(category.getName());
        }*/

        // SELECT  * FROM categories WHERE category_id    tek id'ye göre arama yapma
       /* TypedQuery<Category>getAllCategories = entityManager.createQuery("SELECT cat FROM Category cat WHERE cat.id = :id", Category.class);
        getAllCategories.setParameter("id",2);
        Category category = getAllCategories.getSingleResult();
        System.out.println(category.getName());*/


      /*  // Koşullu sorgulama yaparken
        TypedQuery <Object[]> prodQuery = entityManager.createQuery("SELECT p.id,p.name,p.price FROM Product p WHERE p.price < 1235", Object[].class);
        List<Object[]> productCustomList = prodQuery.getResultList();

        for(Object[] obj : productCustomList){
            System.out.println("ID : " + obj[0] + " Name : " + obj[1] + " Price " + obj[2]);
        } */


      /*   Supplier s1 = new Supplier();
        s1.setAddress("Adres123");
        s1.setCompany("Kodluyoruz");
        s1.setContact("0545 454 545 ");
        s1.setMail("kod@kod.dev");
        s1.setPerson("Raç Çağ");
        entityManager.persist(s1);

        Code c1 = new Code();
        c1.setGroup("55555");
        c1.setSerial("666666");
        entityManager.persist(c1);

        Category ct1 = new Category();
        ct1.setName("Kulaklık");
        entityManager.persist(ct1);

        Product pr2 = new Product();
        pr2.setName("Samsung s21*");
        pr2.setPrice(6);
        pr2.setStock(50);
        pr2.setCode(c1);
        pr2.setSupplier(s1);
        pr2.setCategory(ct1);
        entityManager.persist(pr2);*/

        //Category ekleme
      /*  Category category = new Category();
        category.setName("Kulaklık");
        entityManager.persist(category);  // veri tabanına kaydetmek için kullanırız*/


      /*  //Supplier ekleme
        Supplier supplier = new Supplier();
        supplier.setAddress("Adres");
        supplier.setCompany("Patika");
        supplier.setContact("0545 123 123");
        supplier.setMail("info@patika.dev");
        supplier.setPerson("Rabia Çağlı");
        entityManager.persist(supplier);

        // Category ekleme
        Category category = new Category();
        category.setName("Bilgisayarlar");
        entityManager.persist(category);  // veri tabanına kaydetmek için kullanırız


        // Code ekleme
        Code code = new Code();
        code.setGroup("11233");
        code.setSerial("45554");
        entityManager.persist(code);

        // Ürün ekleme
        Product product = new Product();
        product.setName("Iphone 15pro");
        product.setPrice(1234);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);

        entityManager.persist(product);

        System.out.println(product.toString());

     /*   Product product = entityManager.find(Product.class,1);
        System.out.println(product.toString());

       /*
        Supplier supplier = entityManager.find(Supplier.class, 1);  // yeni veri ekleme
        Code code = new Code();
        code.setGroup("11233");
        code.setSerial("45554");
        entityManager.persist(code);

        Product product = new Product();
        product.setName("Samsung Galaxy");
        product.setPrice(1234);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        entityManager.persist(product);
        */

        /*
        Supplier supplier = entityManager.find(Supplier.class, 1);  // tüm listeyi getirmesi için alt alta
        for(Product product : supplier.getProductList()){
            System.out.println(product.toString());
        } */


      /*  Color blue = new Color("Blue");  // name için constructor olusturduk bu sekılde tabloya yenı renkler ekleyebıldık
        Color red = new Color("Red");
        Color yellow = new Color("Yellow");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);

        Product product = entityManager.find(Product.class,1);
        List<Color> colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);

        entityManager.persist(product);  */

     /*  Product product = entityManager.find(Product.class,1);   // sadece renkleri gormek ıcın
        System.out.println(product.getColorList().toString()); */


      /*  Color color = entityManager.find(Color.class,1);  // color"a ait product ı gormek ıcın
        System.out.println(color.getProductList().toString());*/


     //   Product product = entityManager.find(Product.class,1);
     //   System.out.println(product.getName());
     //   System.out.println(product.getSupplier().getCompany());
        transaction.commit();

    }
}
//Hibernate : select p1_0.product_id,c1_0.category_id,c1_0.category_name,c2_0.code_id,c2_0.code_group,c2_0.code_serial,p1_0.product_name,p1_0.product_prc,p1_0.product_stock,s1_0.supplier_id,s1_0.supplier_address,s1_0.supplier_company,s1_0.supplier_contact,s1_0.supplier_mail,s1_0.supplier_person from products p1_0
// left join categories c1_0 on c1_0.category_id=p1_0.product_category_id
// left join codes c2_0 on c2_0.code_id=p1_0.product_code_id
// left join suppliers s1_0 on s1_0.supplier_id=p1_0.product_supplier_id
// where p1_0.product_id=?       (ihtiyac duymadıgımız yerde joın kullanılması bır performans problemı , fetch"leme işleminden sonra bu durum olusmayacak)

/*

            CASCADE ilikiler arasındaki kurallar:

            Tür                Açıklama
       ------------        -----------------------------------------------------------
         PERSIST            Nesne persist edilirse alt nesne de persist edilir.
         MERGE              Nesne merge edilirse alt nesne de merge edilir.
         REMOVE             Nesne silinirse bağlı alt nesne de silinir.
         REFRESH            Nesne yenilenirse bağlı alt nesne de yenilenir.
         ALL tüm  işlemler birlikte yapılır.






*/