/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConn;

import javax.ejb.Remote;

/**
 *
 * @author Shiny
 */
@Remote
public interface DatabaseConnectEJBRemote {

    void DatabaseConnect();
    
}
