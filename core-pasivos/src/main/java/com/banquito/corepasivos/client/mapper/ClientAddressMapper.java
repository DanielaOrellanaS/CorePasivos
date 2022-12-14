package com.banquito.corepasivos.client.mapper;

import com.banquito.corepasivos.client.dto.request.RequestDtoClientAddress;
import com.banquito.corepasivos.client.dto.response.ResponseDtoClientAddress;
import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;

public class ClientAddressMapper {
    public static ClientAddress map(RequestDtoClientAddress data) {
        ClientAddress address = new ClientAddress();
        ClientAddressPK pk = new ClientAddressPK();
        pk.setCodeLocation(data.getCodeLocation());
        pk.setIdentification(data.getIdentification());
        pk.setIdentificationtype(data.getIdentificationType());
        address.setPk(pk);
        address.setAddressLineOne(data.getAddressLineOne());
        address.setAddressLineTwo(data.getAddressLineTwo());
        address.setLatitude(data.getLatitude());
        address.setLongitude(data.getLongitude());
        return address;
    }

    public static ResponseDtoClientAddress map(ClientAddress data) {
        ResponseDtoClientAddress dto = new ResponseDtoClientAddress();
        dto.setCodeLocation(data.getPk().getCodeLocation());
        dto.setIdentification(data.getPk().getIdentification());
        dto.setIdentificationType(data.getPk().getIdentificationtype());
        dto.setAddressLineOne(data.getAddressLineOne());
        dto.setAddressLineTwo(data.getAddressLineTwo());
        dto.setLatitude(data.getLatitude());
        dto.setLongitude(data.getLongitude());
        return dto;
    }
}
