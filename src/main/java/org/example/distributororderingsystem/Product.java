package org.example.distributororderingsystem;

/**
 * Represents a product
 * @author Bethany Lee
 */
public class Product {

    // product id is always 6 numbers long, no letters
    private final int id;

    // name is often but not always a combination of the brand, sub-brand, and size
    // supplier and brand are self-explanatory
    // size may be in barrels, suitcases, or an x/y format where x is the number of drinks in the group and y is the individual drink size. May be blank
    private final String name, supplier, brand, size;

    // class is what kind of drink it is
    // B for beer, W for wine, S for spirits, N is for non-alcoholic
    private final char productClass;

    // true is active, false is restricted
    private boolean status;

    // available refers to the number of the product currently on hand
    // sales refers to how many have currently been sold in total
    // last received is in YYYYMMDD format
    private int available, sales, lastReceived;

    /**
     * Creates a product with the specified information after confirming information is valid
     * @param name The product's name, typically includes sub-brand and size.
     * @param status The product's status, either active (true) or restricted (false).
     * @param id The product's ID, 6 numbers.
     * @param supplier The product's supplier.
     * @param brand The product's brand.
     * @param size The product's size, in barrels, suitcases, or number/size format.
     * @param productClass The product's class, that being beer, wine, spirits, or non-alcoholic.
     * @param available The number of the product currently available.
     * @param sales The total number of the product sold so far.
     * @param lastReceived The date the product was last received in YYYYMMDD format.
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

    /**
     * Gets the product's supplier.
     * @return A sting representing the product's supplier.
     */
    public String getSupplier() {
        return this.supplier;
    }

    /**
     * Gets the product's brand.
     * @return A string representing the product's brand.
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Gets the product's size.
     * @return A String representing the product's size.
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Gets the product's class.
     * @return A string representing the product's class.
     */
    public String getProductClass() {
        if (this.productClass == 'B') {
            return "Beer";
        } else if (this.productClass == 'S') {
            return "Spirits";
        } else if (this.productClass == 'W') {
            return "Wine";
        } else if (this.productClass == 'N') {
            return "Non-Alcoholic";
        } else {return "ERROR";}
    }

    /**
     * Gets the number available of the product.
     * @return An int representing the product's available amount.
     */
    public int getAvailable() {
        return this.available;
    }

    /**
     * Gets the product's number of current sales.
     * @return An int representing the product's number of current sales.
     */
    public int getSales() {
        return this.sales;
    }

    /**
     * Gets the product's most recent date received.
     * @return A string representing the product's most recent date received.
     */
    public String getLastReceived() {
        int year = this.lastReceived / 10000;
        int month = (this.lastReceived - (year * 10000)) / 100;
        int day = (this.lastReceived - (year * 10000)) - (month * 100);
        return year + "/" + month + "/" + day;
    }

    /**
     * Changes product's status to true (Active).
     */
    public void setStatusActive() {
        this.status = true;
    }

    /**
     * Changes product's status to false (Restricted).
     */
    public void setStatusRestricted() {
        this.status = false;
    }

    /**
     * Adjusts the product's amount available and current sales.
     * @param amount An int representing how many of the product are bring ordered.
     */
    public void buy(int amount) {
        this.available -= amount;
        this.sales += amount;
    }

    /**
     * Updates the product's last received date.
     * @param date An int representing what date the product was most recently received in YYYYMMDD format.
     * @throws IllegalArgumentException If an invalid date is passed to the method. Specifically a date of the wrong length or with a year before 2000/after 2500
     */
    public void receive(int date) {
        if (date >= 25000000 || date < 20000000) {
            throw new IllegalArgumentException("Invalid date last received.");
        } else {this.lastReceived = date;}
    }
}