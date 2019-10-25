package in.ac.ymcaust.AlumniBackendUMS.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


/**
 * Representing user details table in database
 * Contains the details mentioned below
 * @author Tushar
 *
 */
@Entity
@Table
public class UserDetails implements Serializable {
	
	/**
	 * Id required for serialization
	 */
	private static final long serialVersionUID = -7577871098124153567L;

	/*
			1.	Image [ED, NC]
			2.	Name[ NED, C]
			3.	Date of birth[NED,NC]
			4.	Batch Passout [NED, C]
			5.	Type of Degree [NED, C] (eg. B.Tech, MCA, MBA, etc]
			6.	Stream [NED, C] (eg. IT, Mech, etc)
			7.	Current Designation [ED, NC]
			8.	Company Name [ED, NC]
			9.	Location of Work [ED, NC]
			10.	Current location [Home] [ED, C]
			11.	Home Town Location [NED, C]
			12.	Gender [NED, C]
			13.	Business Domain [ED, NC]
			14.	Date of Anniversary[NED, NC]
			15.	Interests[ED,C]
			NOTE: ED- Editable, NED- Not Editable once filled, C- Compulsory, NC- Not compulsory
	*/
	
	// User id
	// Mandatory
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/*
	// User email_id
	// Mandatory
	@Column(nullable = false, unique = true) 
	private String email_id;
	*/
	
	//User name
	// Mandatory
	@Column(nullable = false)
	private String name;
	
	//User profile image
	// Not Mandatory
	@Column(nullable = true)
	private Blob image;
	
	//User date of birth
	// Not Mandatory
	@Column(nullable = true)
	private Date date_of_birth;

	//User passout batch
	// Mandatory
	@Column(nullable = false)
	private int passout_batch;
	
	// User degree type(eg. B.Tech, MCA, MBA, etc)
	// Mandatory
	@Column(nullable = false)
	private String type_of_degree;
	
	// User passout stream
	// Mandatory
	@Column(nullable = false)
	private String stream;
	
	// User current designation
	// Not Mandatory
	@Column(nullable = true)
	private String current_designation;
	
	// User current company name
	// Not Mandatory
	@Column(nullable = true)
	private String company_name;
	
	// User work location
	// Not Mandatory
	@Column(nullable = true)
	private String location_of_work;
	
	// User temporary location
	// Mandatory
	@Column(nullable = false)
	private String current_location;
	
	// User permanent location
	// Mandatory
	@Column(nullable = false)
	private String home_town_location;
	
	// User gender
	// Mandatory
	@Column(nullable = false)
	private String gender;
	
	// User expertise
	// Not Mandatory
	@Column(nullable = true)
	private String business_domain;
	
	// User anniversary date
	// Not Mandatory
	@Column(nullable = true)
	private Date anniversary_date;
	
	// User interests
	// Mandatory
	@Column(nullable = false)
	private String interests;

	/**
	 * Empty constructor for error re
	 */
	public UserDetails() {
		super();
	}

	
	/**
	 * Create User details with mandatory arguments
	 * @param name User name
	 * @param passout_batch passout batch
	 * @param type_of_degree degree type
	 * @param stream stream of study
	 * @param current_location current location
	 * @param home_town_location home town
	 * @param gender gender
	 * @param interests interests
	 */
	public UserDetails(String name, int passout_batch, String type_of_degree,
			String stream, String current_location, String home_town_location,
			String gender, String interests) {
		super();
		this.name = name;
		this.passout_batch = passout_batch;
		this.type_of_degree = type_of_degree;
		this.stream = stream;
		this.current_location = current_location;
		this.home_town_location = home_town_location;
		this.gender = gender;
		this.interests = interests;
	}

	public int getId() {
		return id;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getPassout_batch() {
		return passout_batch;
	}

	public String getType_of_degree() {
		return type_of_degree;
	}

	public String getStream() {
		return stream;
	}

	public String getCurrent_designation() {
		return current_designation;
	}

	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getLocation_of_work() {
		return location_of_work;
	}

	public void setLocation_of_work(String location_of_work) {
		this.location_of_work = location_of_work;
	}

	public String getCurrent_location() {
		return current_location;
	}

	public String getHome_town_location() {
		return home_town_location;
	}

	public String getGender() {
		return gender;
	}

	public String getBusiness_domain() {
		return business_domain;
	}

	public void setBusiness_domain(String business_domain) {
		this.business_domain = business_domain;
	}

	public Date getAnniversary_date() {
		return anniversary_date;
	}

	public void setAnniversary_date(Date anniversary_date) {
		this.anniversary_date = anniversary_date;
	}
	
	public String getInterests() {
		return interests;
	}
	
}
