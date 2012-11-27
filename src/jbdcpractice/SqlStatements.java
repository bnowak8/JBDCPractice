
package jbdcpractice;

public class SqlStatements {
    
    public SqlStatements(){
    
    }
    
        public final String selectEmployeeAll(){
                String sql = "SELECT * FROM employee"; // Selects All
                return sql;
        }
        
        public final String selectEmployeeFirstName(String firstName){
            String sql = "SELECT FROM employee WHERE first_name='"+firstName+"'";
            return sql;
        }
        
        public final String deleteEmployeeFirstName(String firstName){
            String sql = "DELETE FROM employee WHERE first_name='"+firstName+"'";
            return sql;
        }
        
        public final String addNewEmployee(String firstName, String lastName, String phone, int active){
            String sql = "INSERT INTO employee VALUES(null,'"+firstName+"','"+lastName+"','"+phone+"','"+active+"')";  // Adds new Employee
            return sql;
        }
        
        public final String selectManagerAll(){
            String sql = "SELECT * FROM manager";
            return sql;
        }
        
        public final String selectManagerFirstName(String firstName){
            String sql = "SELECT FROM manager WHERE first_name='"+firstName+"'";
            return sql;
        }
        
        public final String deleteManagerFirstName(String firstName){
            String sql = "DELETE FROM manager WHERE first_name='"+firstName+"'";
            return sql;
        }
        
        public final String addNewManager(String firstName, String lastName, String phone, int active){
            String sql = "INSERT INTO manager VALUES(null,'"+firstName+"','"+lastName+"','"+phone+"','"+active+"')";  // Adds new Employee
            return sql;
        }                

    
}
