/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f.businesslogiclayer;

/**
 *
 * @author phuong
 */
public interface BusinessLogicFactory {
    static BusinessLogicAPI getImplementation(){
        return new BusinessLogicAPI();
    };
}
