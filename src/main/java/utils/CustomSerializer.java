package utils;

import java.io.IOException;
import java.util.List;

import org.auctionsense.domain.Bid;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomSerializer extends StdSerializer<List<Bid>> {

    public CustomSerializer() {
        this(null);
    }

    public CustomSerializer(Class<List<Bid>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Bid> bids, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {

        gen.writeStartArray();
        for (Bid bid : bids) {
            gen.writeStartObject();
            gen.writeStringField("id", bid.getId().toString());
            gen.writeNumberField("amount", bid.getAmount());
            gen.writeStringField("date", bid.getDate().toString());
            gen.writeFieldName("user");
            gen.writeStartObject();
            gen.writeStringField("id", bid.getUser().getId().toString());
            gen.writeStringField("email", bid.getUser().getEmail().toString());
            gen.writeEndObject();
            gen.writeFieldName("bidHistory");
            gen.writeStartObject();
            gen.writeStringField("id", bid.getBidHistory().getId().toString());
            gen.writeEndObject();
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
    
}