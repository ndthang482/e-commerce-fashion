package com.orderservice.domain.dto.output;

import com.orderservice.domain.entity.Cart;
import com.orderservice.domain.model.Report.CartDTONative;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private List<CartDTONative> carts;
    private Page<Cart> cartData;
    private Long totalCarts;
}
