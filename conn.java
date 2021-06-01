import org.neo4j.driver.*;

public class App 
{
  public static void main( String[] args )
  {
    Config.ConfigBuilder builder = Config.builder().withEncryption();
    Config config = builder.build();

    Driver driver = GraphDatabase.driver("YOUR DATABASE URL", AuthTokens.basic( "YOUR DB USERNAME", "YOUR DB PASSWORD" ), config);

    Session session = driver.session();

    Result result = session.run("SOME UNIQUE QUERY");

    session.close();
    driver.close();
  }
}
