package com.visma.demowholesalers.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Rounding as 4.56 before return as json value
 *
 * Created by Vasif Mustafayev on 17.11.2016.
 * vmustafayev@gmail.com
 */
public class BigDecimalValueSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
