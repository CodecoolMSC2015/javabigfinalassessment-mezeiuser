package fileOperation;

import employeeManager.Person;

import java.util.Set;

/**
 * Created by Péter on 2016. 03. 16..
 */
public class DataReader {
    String searchCriteria;
    SearchType searchType;

    public Set<Person> getPerson(String sr, SearchType st){

        return null;
    }

    public void setSearchType(SearchType searchType) {

        this.searchType = searchType;
    }

    public void setSearchCriteria(String searchCriteria)
    {
        this.searchCriteria = searchCriteria;
    }


}
