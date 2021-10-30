
package model.dao;

import java.util.ArrayList;
import model.bussiness.Translog;


public interface TranslogDao {
    public int newActivies(Translog translog);
    public ArrayList<Translog> getTranslogs(int logId);
}
