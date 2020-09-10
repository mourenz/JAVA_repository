package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import poji.Msg;

public class TestJson {

    @Test
    public void testJson() throws Exception {

        Msg msg = new Msg("success",200);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(msg);
        System.out.println(s);


    }


}
