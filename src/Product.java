/**
 * Represents a product
 * @author Bethany Lee
 */
public class Product {
    // true is active, false is restricted
    private boolean status;

    // product id is always 6 numbers long, no letters
    // available refers to the number of the product currently on hand
    // sales refers to how many have currently been sold in total
    // last received is in (year)(month)(day) format
    private int id, available, sales, lastReceived;

    // name is often but not always a combination of the brand, sub-brand, and size
    // supplier and brand are self-explanatory
    // size may be in barrels, suitcases, or a x/y format where x is the number of drinks in the group and y is the individual drink size. May be blank
    private String name, supplier, brand, size;

    // class is what kind of drink it is
    // B for beer, W for wine, S for spirits, N is for non-alcoholic
    private char productClass;

    /**
     * Creates a product with the specified information after confirming information is valid
     * @param name The product's name, typically includes sub-brand and size.
     * @param status The product's status, either active (true) or restricted (false).
     * @param id The prodect's ID, 6 numbers.
     * @param supplier The product's supplier.
     * @param brand The product's brand.
     * @param size The product's size, in barrels, suitcases, or number/size format.
     * @param productClass The product's class, that being beer, wine, spirits, or non-alcoholic.
     * @param available The number of the product currently available.
     * @param sales The total number of the product sold so far.
     * @param lastReceived The date the product was last received in (year)(month)(day) format.
     * @throws IllegalArgumentException If an invalid parameter is passed to the constructor. For example, a product id that is not 6 numbers.
     */
    public Product(String name, boolean status, int id, String supplier, String brand, String size, char productClass, int available, int sales, int lastReceived) {
        this.name = name;
        this.status = status;
        if (id >= 1000000 || id < 100000) {
            throw new IllegalArgumentException("Invalid product ID input.");
        } else {this.id = id;}
        this.supplier = supplier;
        this.brand = brand;
        this.size = size;
        if (productClass != 'B' && productClass != 'S' && productClass != 'W' && productClass != 'N') {
            throw new IllegalArgumentException("Invalid product class input.");
        } else {this.productClass = productClass;}
        this.available = available;
        this.sales = sales;
        if (lastReceived >= 25000000 || lastReceived < 20000000) {
            throw new IllegalArgumentException("Invalid date last received.");
        } else {this.lastReceived = lastReceived;}
    }

    /**
     * Sets the product's name.
     * @param name The product's name, typically includes sub-brand and size.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product's name.
     * @return A string representing the product's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the product's status.
     * @return A string ("Active" or "Restricted") representing the product's status.
     */
    public String getStatus() {
        if (this.status) {return "Active";}
        else {return "Restricted";}
    }

    /**
     * Gets the product's id.
     * @return An int representing the product's ID.
     */
    public int getId() {
        return this.id;
    }
}

// The products I plan to include are the top 300 in the master product list when sorted by Sales Current (column M in Excel, attribute sales on here)
