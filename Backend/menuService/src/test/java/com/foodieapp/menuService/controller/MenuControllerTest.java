//package com.foodieapp.menuService.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.foodieapp.menuService.domain.Item;
//import com.foodieapp.menuService.exception.ItemAlreadyExistException;
//import com.foodieapp.menuService.service.MenuServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class MenuControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private MenuServiceImpl menuService;
//
//    @InjectMocks
//    private MenuController menuController;
//
//    private Item item1, item2;
//    List<Item> itemList;
//
//    @BeforeEach
//    public void setUp() {
//        item1 = new Item(1, "Hakka Noodles", 250, "Chinese");
//        item2 = new Item(2, "Palak Paneer", 450, "North Indian");
//        itemList = Arrays.asList(item1, item2);
//
//        mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
//
//    }
//
//    @AfterEach
//    void tearDown() {
//       item1 = null;
//        item2 = null;
//    }
//
//    @Test
//    public void givenItemToAddShouldAddItem() throws Exception{
//        when(menuService.addItem(any())).thenReturn(item1);
//        mockMvc.perform(post("/menu/addItem")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(item1)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(menuService,times(1)).addItem(any());
//
//    }
//
//    @Test
//    public void givenItemToAddShouldAddItemFailure() throws Exception{
//        when(menuService.addItem(any())).thenThrow(ItemAlreadyExistException.class);
//        mockMvc.perform(post("/menu/addItem")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(item1)))
//                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        verify(menuService,times(1)).addItem(any());
//
//    }
//
//    @Test
//    public void givenItemToDeleteShouldDeleteItem() throws Exception{
//        when(menuService.deleteItem(anyInt())).thenReturn(true);
//        mockMvc.perform(delete("/menu/deleteItem/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(menuService,times(1)).deleteItem(anyInt());
//    }
//    private static String jsonToString(final Object obj) throws JsonProcessingException {
//        String result;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(obj);
//            result = jsonContent;
//        } catch(JsonProcessingException e) {
//            result = "JSON processing error";
//        }
//
//        return result;
//    }
//}
