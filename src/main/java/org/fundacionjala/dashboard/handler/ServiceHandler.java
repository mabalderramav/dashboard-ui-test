package org.fundacionjala.dashboard.handler;

import org.fundacionjala.dashboard.ui.pages.menu.ServiceFieldStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AldoBalderrama on 10/6/2016.
 */
public class ServiceHandler {
    private static List<Map<ServiceFieldStep, String>> listService;
    private static ServiceHandler serviceHandler;
    private ServiceHandler() {
        listService = new ArrayList<>();
    }

    public static ServiceHandler getInstance(){
        if(serviceHandler == null){
            serviceHandler = new ServiceHandler();
        }
        return serviceHandler;
    }
    public void addService(Map<ServiceFieldStep, String> service) {
        listService.add(service);
    }

    public boolean exist(Map<ServiceFieldStep, String> value) {
        //Optional<Map<ServiceFieldStep, String>> serviceMap =
        return listService.stream()
                .filter(s ->
                        value.get(ServiceFieldStep.TOKEN).equals(s.get(ServiceFieldStep.TOKEN)))
                .findFirst()
                .isPresent();
    }
}
