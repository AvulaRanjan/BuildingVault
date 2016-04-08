package miracle.com.arch.util;

public class Contants {
	public static final String MARETIAL_QUERY = "SELECT * FROM test.maretial_type_tbl;";
	public static final String TARE_QUERY = "SELECT * FROM test.tare_unites_tbl;";
	public static final String REA_REGISTRATION_QUERY = "SELECT * FROM test.dea_registration_tbl;";
	public static final String DEA_SCHEDULE_QUERY = "SELECT * FROM test.dea_schedule_tbl;";
	public static final String OWNER_QUERY = "SELECT * FROM test.owner_tbl;";
	public static final String DISPOSTION_QUERY = "SELECT * FROM test.disposition_tbl;";
	public static final String CHECKOUT_REG_QUERY = "SELECT * FROM test.checkout_restriction_tbl;";
	public static final String CONTENT_UNITES_QUERY = "SELECT * FROM test.content_unites_tbl;";
	public static final String STORE_LOCATION_QUERY = "SELECT * FROM test.storage_location_tbl;";

	public static final String INSERT_BOTTLE_QUERY = " INSERT INTO test.bottle_tbl "
			+ "(bottle_number, compound_name, sample_notebook_id, code, maretial_id, tare_unite_id, dea_registration_id, "
			+ "dea_schedule_id, inventory, owner_id, disposition_id, content_unites_id, location_id, comment, transaction_date, "
			+ "customer_nb_ref, customer_emp_no, css_emp_no, gross_amount, transaction_log_ref, restriction_id)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	public static final String CHCK_BOTLE_EXIST_QUERY = "SELECT count(bottle_number) bottle_number FROM test.bottle_tbl where  bottle_number=?;";
	public static final String BOTTLE_CREATE_FAIL = "Bottle is not created Fail";
	public static final String BOTTLE_FAIL_DB_ERROR = "Bottle is not created Fail due DB error ";
	public static final String SAVED_SUCCESSFULLY_MSG = "Bottle is saved Successfully";
	public static final String BOTTLE_ALREADY_EXISTED_MSG = " Bottle Number already existed in the system";
	
	public static final String SELECT_BOTLE_LIST_QUERY = "SELECT bottle_number,gross_amount,transaction_date,"
			+ "customer_nb_ref,transaction_log_ref,customer_emp_no,css_emp_no FROM test.bottle_tbl;";
	
	public static final String CREATE_BOTTLE_DAO = "createBottleDAO";
}
