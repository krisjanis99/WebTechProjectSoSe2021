package HTW.WebTechProjectSoSe2021.WebTechProjectSoSe2021.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "list_name", nullable = false)
    private String listName;
    
    @Column(name = "author", nullable = false)
    private String author;


//    @ElementCollection
//    private final List<String> listItems = new ArrayList<String>();


    public ShoppingListEntity(String listName, String author) {
        this.listName = listName;
        this.author = author;
    }

    public ShoppingListEntity() {
    }

    //Getter for the id. It is not possible to set a new id for the list after its constructed.
    public Long getId() {
        return id;
    }

    //getter and setter for Name. It is possible to set a new name for the list.
    public String getListName() {
        return listName;
    }

    public void setListName(String name) {
        this.listName = listName;
    }

    //Getter for the author. It is not possible to set a new author for the list after its constructed.
    public String getAuthor() {
        return author;
    }

    //we dont need this???
    public void setAuthor(String name) {
        this.author = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingListEntity shoppinglist = (ShoppingListEntity) o;
        return Objects.equals(id, shoppinglist.id) &&
                Objects.equals(listName, shoppinglist.listName) &&
                Objects.equals(author, shoppinglist.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, listName, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("ID=").append(id);
        sb.append(", listName='").append(listName).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}