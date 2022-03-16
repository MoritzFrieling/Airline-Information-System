/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.businessLogicLayer;

import f.persistencelayer.PersistenceAPI;

/**
 *
 * @author phuong
 */
public interface BusinessLogicFactory {
    static BusinessLogicAPIImplementation getImplementation(PersistenceAPI persistenceAPI){
        return new BusinessLogicAPIImplementation(persistenceAPI);
    };
}
