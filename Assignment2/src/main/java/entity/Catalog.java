package entity;

import javax.persistence.*;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int catalogId;
    private String catalog_Name;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalog_Name() {
        return catalog_Name;
    }

    public void setCatalog_Name(String catalog_Name) {
        this.catalog_Name = catalog_Name;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Category_Id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
