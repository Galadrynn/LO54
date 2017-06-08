/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.controler;

import fr.utbm.entity.Client;
import fr.utbm.service.ConsultService;
import fr.utbm.service.RegisterService;
import java.util.List;

/**
 *
 * @author Moi
 */
public class ClientCtrl {
    private ConsultService consultService;
        
    public ClientCtrl () {
        consultService = new ConsultService();
    }
    
    public List<Client> getAllClient(){
       return consultService.getAllClients();
    }
}
