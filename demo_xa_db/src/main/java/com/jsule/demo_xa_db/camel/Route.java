package com.jsule.demo_xa_db.camel;

import com.jsule.demo_xa_db.delivery.DeliveryRepository;
import com.jsule.demo_xa_db.delivery.Delivery;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Route extends RouteBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(Route.class);

    private final DeliveryRepository deliveryRepository;

    public Route(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void configure() throws Exception {
        from("direct:camelRoute")
                .log("Camel Route Triggered")
                .process(newDelivery)
        ;


    }

    private final Processor newDelivery = new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            Delivery del = new Delivery("Jeremy", "204C", LocalDate.of(2018, 2, 12));
            deliveryRepository.save(del);
            LOG.info("Saved delivery");
        }

    };
}

