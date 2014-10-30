/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.jsf.good;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.good.GoodDTO;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;

/**
 *
 * @author Łukasz Gadomski
 */
@Named
@Scope("request")
//TODO this class is no longer needed
public class AvailableGoodsBean {

    private List<GoodDTO> goodList;
    private Client client;
    private Gson gson;

    public AvailableGoodsBean() {
        goodList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        try {
            client = Client.create(); 
            client.setConnectTimeout(3000);
            gson = new Gson();
            goodList = getDataFromWebService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GoodDTO> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<GoodDTO> goodList) {
        this.goodList = goodList;
    }

    private List<GoodDTO> getDataFromWebService() {
            /*WebResource webResource = client
                    .resource("http://10.31.62.214:8080/was04-headoffice-web/rest/goods/list");
            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            List<GoodDTO> result = gson.fromJson(output, new TypeToken<List<GoodDTO>>() {
            }.getType());

            return result;*/
            return new ArrayList<>();
    }
}
