import org.neo4j.driver.*;

public class App 
{
  public static void main( String[] args )
  {
    Config.ConfigBuilder builder = Config.builder().withEncryption();
    Config config = builder.build();

    Driver driver = GraphDatabase.driver("YOUR DATABASE URL", AuthTokens.basic( "YOUR NEW DB USERNAME", "YOUR NEW DB PASSWORD" ), config);
    Driver driver2 = GraphDatabase.driver("YOUR DATABASE URL", AuthTokens.basic( "YOUR OLD DB USERNAME", "YOUR OLD DB PASSWORD" ), config);

    
    Session session = driver.session();
    Session session2 = driver2.session();

    Result result = session.run("SOME UNIQUE QUERY");
    Result result2 = session2.run("SOME UNIQUE QUERY");
    
    if (result === result2) {
      System.out.println("The two databases are the same");
    } else {
      System.out.println("The two databases are not the same");
    }


    session.close();
    session2.close();
    driver.close();
    driver2.close();
  }
}
