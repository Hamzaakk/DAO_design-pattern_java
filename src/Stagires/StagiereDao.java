package Stagires;

import java.util.List;

public interface StagiereDao {
     List<Stagiere> fetchall();
     Stagiere finById(int id);
     void addStagiere(Stagiere stagiere);
     void updateStagiere(Stagiere stagiere);
     void deleteStagiereById(int id);


}
