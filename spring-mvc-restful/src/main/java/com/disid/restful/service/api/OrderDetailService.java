package com.disid.restful.service.api;

import com.disid.restful.model.CustomerOrder;
import com.disid.restful.model.OrderDetail;
import com.disid.restful.model.OrderDetailPK;

import io.springlets.data.domain.GlobalSearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailService {

  Page<OrderDetail> findByCustomerOrder(CustomerOrder customerOrderField, GlobalSearch globalSearch,
      Pageable pageable);

  long countByCustomerOrder(CustomerOrder customerOrderField);

  OrderDetail findOne(OrderDetailPK orderDetailPK);

}
