package manhar.laziaf.springrecipeapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categorySet")
    private Set<Recipe> recipeSet;


}
