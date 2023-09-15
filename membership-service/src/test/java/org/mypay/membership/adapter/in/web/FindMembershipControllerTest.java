package org.mypay.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mypay.membership.domain.MemberShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FindMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testFindMembership() throws Exception {
        RegisterMembershipRequest request1 = new RegisterMembershipRequest("name1","email1","address1",false);

        mockMvc.perform(
                    MockMvcRequestBuilders.post("/membership/register/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request1))
                )
                .andExpect(MockMvcResultMatchers.status().isOk());

        MemberShip expect = MemberShip.generateMember(
                new MemberShip.MemberShipId("1"),
                new MemberShip.MemberShipName("name1"),
                new MemberShip.MemberShipEmail("email1"),
                new MemberShip.MemberShipAddress("address1"),
                new MemberShip.MemberShipIsValid(true),
                new MemberShip.MemberShipIsCorp(false));

        mockMvc.perform(
                    MockMvcRequestBuilders.get("/membership/1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(expect)));
    }
}