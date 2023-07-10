//package com.foodieapp.menuService.service;
//
//import com.foodieapp.menuService.domain.Item;
//import com.foodieapp.menuService.exception.ItemAlreadyExistException;
//import com.foodieapp.menuService.exception.ItemNotFoundException;
//import com.foodieapp.menuService.repository.MenuRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class MenuServiceTest {
//
//    @Mock
//    private MenuRepository menuRepository;
//
//    @InjectMocks
//    private MenuServiceImpl menuService;
//
//    private Item item1, item2;
//    List<Item> itemList;
//
//    @BeforeEach
//    public void setUp() {
//        item1 = new Item(1, "Hakka Noodles", 250, "Chinese");
//        item2 = new Item(2, "Palak Paneer", 450, "North Indian");
//        itemList = Arrays.asList(item1, item2);
//    }
//
//    @AfterEach
//    void tearDown() {
//        item1 = null;
//        item2 = null;
//    }
//
//    @Test
//    public void givenItemToAddShouldAddItem() throws ItemAlreadyExistException {
//        when(menuRepository.findById(item1.getItemId())).thenReturn(Optional.ofNullable(null));
//        when(menuRepository.save(any())).thenReturn(item1);
//        assertEquals(item1, menuService.addItem(item1));
//        verify(menuRepository, times(1)).save(any());
//        verify(menuRepository, times(1)).findById(any());
//    }
//
//    @Test
//    public void givenItemToAddShouldAddItemReturnItemFailure() {
//        when(menuRepository.findById(item1.getItemId())).thenReturn(Optional.ofNullable(item1));
//        assertThrows(ItemAlreadyExistException.class, () -> menuService.addItem(item1));
//        verify(menuRepository, times(0)).save(any());
//        verify(menuRepository, times(1)).findById(any());
//    }
//
//    @Test
//    public void givenItemToDeleteShouldDeleteItemSuccess() throws ItemNotFoundException {
//        when(menuRepository.findById(item1.getItemId())).thenReturn(Optional.ofNullable(item1));
//        boolean flag = menuService.deleteItem(item1.getItemId());
//
//        verify(menuRepository,times(1)).deleteById(any());
//        verify(menuRepository,times(1)).findById(any());
//
//    }
//}