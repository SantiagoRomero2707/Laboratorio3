package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Phone;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.rest.request.PhoneRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PhoneResponse;

@Component
public class PhoneRestMapper {
    public PhoneResponse fromTelefonoToTelefonoResponse(Phone phone) {
        if (phone == null) {
            return null;
        }
        PhoneResponse phoneResponse = new PhoneResponse();
        phoneResponse.setNum(phone.getNum());
        phoneResponse.setOper(phone.getOper());
        return phoneResponse;
    }

    public Phone fromTelefonoRequestToTelefono(PhoneRequest phoneRequest) {
        if (phoneRequest == null) {
            return null;
        }
        Phone phone = new Phone();
        phone.setNum(phoneRequest.getNum());
        phone.setOper(phoneRequest.getOper());
        return phone;
    }

    public List<Phone> fromListTelefonoRequestToListTelefono(List<PhoneRequest> phoneRequests) {
        List<Phone> phones = new ArrayList<>();
        for (PhoneRequest phoneRequest : phoneRequests) {
            phones.add(fromTelefonoRequestToTelefono(phoneRequest));
        }
        return phones;
    }

    public List<PhoneResponse> fromListTelefonoToListTelefonoResponse(List<Phone> phones) {
        List<PhoneResponse> phoneRespons = new ArrayList<>();
        for (Phone phone : phones) {
            phoneRespons.add(fromTelefonoToTelefonoResponse(phone));
        }
        return phoneRespons;
    }
}
