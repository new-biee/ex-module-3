package helper;

public class Query {
    public static final String SELECT_ALL_CATEGORY = "select * from category where status = 1";
    public static final String INSERT_CATEGORY_SQL = "insert into category(category_name, category_desc) values " + "(?,?);";
    public static final String SELECT_CATEGORY_BY_ID = "select * from category where id = ? and status = 1";
    public static final String UPDATE_CATEGORY_SQL = "update category set category_name = ?, category_desc = ? where id = ? and status = 1";
    public static final String REMOVE_CATEGORY_SQL = "update category set status = ? where id = ? and status = 1";
    public static final String SELECT_CATEGORY_BY_NAME = "select * from category where category_name like ? and status = 1";
    public static final String SELECT_ALL_PRODUCT = "select * from product where status = 1";
    public static final String SELECT_PRODUCT_BY_NAME = "select * from product where product_name like ? and status = 1";
    public static final String SELECT_PRODUCT_BY_ID = "select * from product where product_code = ? and status = 1";
    public static final String INSERT_PRODUCT_SQL = "insert into product(id, product_name, product_price, product_quantity, product_color, product_desc, category_id) values " + "(?,?,?,?,?,?,?)";



}
