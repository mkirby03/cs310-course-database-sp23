package edu.jsu.mcis.cs310.coursedb;

import edu.jsu.mcis.cs310.coursedb.dao.*;

public class Main {

    public static void main(String[] args) {
        
        DAOFactory daoFactory = new DAOFactory("coursedb");
        
        if ( !daoFactory.isClosed() ) {
            System.out.println("Connected Successfully!");
        }
        
        SectionDAO sectionDao = daoFactory.getSectionDAO();
        System.out.println(sectionDao.find(1, "CS", "201"));
        
        RegistrationDAO registrationDao = daoFactory.getRegistrationDAO();
        
        boolean result = registrationDao.create(1, DAOUtility.TERMID_SP23, 21098);
        
        System.out.println(result);
        
    }
    
}