package pe.isil.pc04villaca.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    private String  sku;
    private String  name;
    private Integer stock;
    private Double  price;



}
