package booking.mybatis.services;

import booking.model.Payment;
import booking.mybatis.mappers.PaymentMapper;

public class PaymentService extends BaseService<Payment, Integer, PaymentMapper> {

    @Override
    protected Class<PaymentMapper> getMapperClass() {
        return PaymentMapper.class;
    }
}
