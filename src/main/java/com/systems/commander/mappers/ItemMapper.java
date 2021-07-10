package com.systems.commander.mappers;

import com.systems.commander.dto.ItemRequest;
import com.systems.commander.dto.ItemResponse;
import com.systems.commander.models.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Item convertToModel(ItemRequest request) {
        return modelMapper.map(request, Item.class);
    }

    public ItemResponse convertToResponse(Item item) {
        return modelMapper.map(item, ItemResponse.class);
    }
}
