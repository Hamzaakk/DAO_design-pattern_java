import Stagires.Stagiere;
import Stagires.StagiereDao;
import Stagires.StagiereDaoImpl;

public class Main {
    public static void main(String[] args) throws Exception{
        StagiereDao stagiereDao = new StagiereDaoImpl();
        Stagiere newStagiere = new Stagiere();
        newStagiere.setName("John");
        newStagiere.setLastname("Doe");
        newStagiere.setAge(25);
        newStagiere.setLogin("john_doe");
        newStagiere.setPassword("password123");
        stagiereDao.addStagiere(newStagiere);
        // lister les stagieres
         ArrayList<Stagiere> s = new ArrayList<>();
        s = (ArrayList<Stagiere>) stagiereDao.fetchall();
        for ( Stagiere e : s){
            System.out.println("name : " +e.getName()+" " + e.getLastname());
        }
    }
}