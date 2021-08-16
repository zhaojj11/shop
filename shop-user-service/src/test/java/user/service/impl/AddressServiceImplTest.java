package user.service.impl;

import com.pyjava.shop.user.UserApplication;
import com.pyjava.shop.user.model.AddressDO;
import com.pyjava.shop.user.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserApplication.class)
@Slf4j
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAddress() {
        AddressDO address = addressService.findAddress(1L);
        log.info(address.toString());
        Assertions.assertNotNull(address);
    }
}
