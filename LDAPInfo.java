import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import java.util.Hashtable;
import javax.naming.NamingException;

public class LDAPInfo {
	public static void main(String[] args) throws Exception {
		if (args.length < 1){
			throw new RuntimeException("I need UID!"); //command line argument is obligatory
		}
		String uid = args[0]; //uid is taken from command line argument
		String query = String.format("(&(uid=%s)(objectClass=person))", uid); //query is constructed based command line argument.
		System.out.println("LDAP query: " + query); //the query is printed out upon call
		Hashtable<String, Object> env = new Hashtable<>();
		env.put("java.naming.provider.url", "ldap://localhost:9090/dc=example,dc=org");
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		InitialLdapContext ctx = new InitialLdapContext(env, null); //connection to LDAP is established
		SearchControls constraints = new SearchControls();
		constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
		constraints.setReturningAttributes(new String[] { "telephoneNumber" }); 
		NamingEnumeration<SearchResult> results = ctx.search("", query, constraints);
		try{
			if(!results.hasMore()) {
				System.out.println("Nobody found!"); //if the uid does not result in finding any record, print that
			} else {
				Object phone = results.next().getAttributes().get("telephoneNumber");
				System.out.println("Phone: " + phone); //otherwise print the phone
			}
		} catch (NamingException e) {
		} finally {
			results.close(); //close the result handle
		}
	}
}
	
