import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int  id;


    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_prc", nullable = false)
    private double price;

    @Column (name = "product_stock")
    private int stock;


    @OneToOne(fetch = FetchType.LAZY) // bu join sadece ıhtıyac duyuldugunda yapılır "tembel yukleme"
    @JoinColumn(name = "product_code_id" , referencedColumnName = "code_id")
    private Code code;


    //fetch = FetchType.EAGER :  her şekilde join"le
    @ManyToOne(fetch = FetchType.LAZY) // çoktan aza ilişkisi - bir urunun bır supplier ı var
    @JoinColumn(name = "product_supplier_id" , referencedColumnName = "supplier_id")
    //veri tabanındaki karsılıgı ^         // supplıer tarafındaki karşılıgı ^
    private  Supplier supplier;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id" , referencedColumnName = "category_id")
    private Category category;


    @ManyToMany(fetch = FetchType.LAZY) // birden çok ürünün birden çok rengi vardır
    @JoinTable (
            name = "pro2colors",   // aracı tablonun adı
            joinColumns = {           // product bu tabloda neye denk gelıyor belırlemek ıcın
                    @JoinColumn(name = "pro2color_product_id")},
            inverseJoinColumns = {@JoinColumn(name = "pro2color_color_id")} // ne ile ilişki kuracak belirliyoruz
    )
    private List<Color> colorList;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {  // product a aıt ozellıklerı ekrana basıyor
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", supplier=" + supplier + // supplıer ın tostrıng ını cagırıyor
                ", category=" + category +
                ", colorList=" + colorList +
                '}';
    }
}
