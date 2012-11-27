package jbdcpractice;

import java.sql.*;


public class Demo1 {
	private Connection conn;
	private String driverClassName;
	private String url;
	private String userName;
	private String password;

	public static void main(String[] args) {

		Demo1 db = new Demo1();
                SqlStatements statement = new SqlStatements();


		db.driverClassName = "com.mysql.jdbc.Driver";
		db.url = "jdbc:mysql://localhost:3306/hr";
		db.userName = "root";
		db.password = "admin";


		try {

			  Class.forName (db.driverClassName);

			  db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
		}
		catch ( ClassNotFoundException cnfex ) {
		   System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 ); 
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database!" );
		   sqlex.printStackTrace();
		   System.exit( 1 ); 
		}


		Statement stmt = null;


		ResultSet rs = null;

                
                String sql4 = "CREATE  TABLE `manager` ("
                    + "`manager_id` INT NOT NULL ,"
                    + "`first_name` VARCHAR(45) NULL ,"
                    + "`last_name` VARCHAR(45) NULL ,"
                    + "`phone` VARCHAR(45) NULL ,"
                    + "`active` TINYINT NULL DEFAULT 1 ,"
                    + "PRIMARY KEY (`manager_id`))";
                
                String sql5 = "INSERT INTO manager VALUES(null,'Bob','Sagget','333-444-5555',null)";
                
		try {

			stmt = db.conn.createStatement();
                        
//                        stmt.executeUpdate(sql4);
//                        stmt.executeUpdate(sql5);
			rs = stmt.executeQuery(statement.selectEmployeeAll());
                        
                        

                        

                        System.out.println("============================");
                        System.out.println("Output from MySQL Server...");
                        System.out.println("============================");
                        
			int count = 0;
			while( rs.next() ) {

                                System.out.println("\nRecord No: " + (count + 1));

				System.out.println("Employee Id: " + rs.getInt("employee_id"));
                                System.out.println( "Last Name: " + rs.getString("last_name") );
				System.out.println( "First Name: " + rs.getString("first_name") );
                                System.out.println("Phone Number: " + rs.getString("phone"));
                                System.out.println("Active Status: " + rs.getInt("active"));
				count++;
			}
			System.out.println( "==================\n" + count + " records found." );
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
        }
                          
                

	}
        

        

